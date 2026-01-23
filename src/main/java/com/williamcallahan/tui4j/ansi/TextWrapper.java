package com.williamcallahan.tui4j.ansi;

import com.ibm.icu.lang.UCharacter;
import com.williamcallahan.tui4j.ansi.GraphemeCluster.GraphemeResult;
import com.williamcallahan.tui4j.compat.x.ansi.parser.Action;
import com.williamcallahan.tui4j.compat.x.ansi.parser.State;
import com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable;
import com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable.Transition;
import java.nio.charset.StandardCharsets;

/**
 * Wraps text to fit within a specified display width while preserving ANSI escape sequences.
 * <p>
 * Uses an ANSI state machine to parse input, handling:
 * <ul>
 *   <li>UTF-8 multibyte characters with correct display width calculation</li>
 *   <li>ANSI escape sequences (passed through without counting toward width)</li>
 *   <li>Word boundaries at whitespace and hyphens</li>
 *   <li>Non-breaking spaces (U+00A0) treated as non-whitespace</li>
 * </ul>
 * <p>
 * The algorithm accumulates words and spaces, inserting line breaks when the
 * current line width would exceed the limit, and hard-wrapping words that are
 * longer than the available line width.
 */
public class TextWrapper {

    private static final String NBSP = "\u00A0"; // Non-breaking space

    /**
     * Creates a text wrapper instance.
     */
    public TextWrapper() {}

    private static final String BREAKPOINTS = "";

    private int limit;
    private int curWidth;
    private int wordLen;
    private int spaceWidth;

    private StringBuilder buf = new StringBuilder(); // Final wrapped text
    private StringBuilder word = new StringBuilder(); // Current word
    private StringBuilder space = new StringBuilder(); // Current spaces

    /**
     * Wraps text to the specified display width limit.
     *
     * @param text  the text to wrap
     * @param limit maximum display width per line
     * @return wrapped text with line breaks inserted
     */
    public String wrap(String text, int limit) {
        if (limit < 1 || text == null) {
            return text;
        }

        this.limit = limit;
        this.curWidth = 0;
        this.wordLen = 0;
        this.spaceWidth = 0;
        this.buf.setLength(0);
        this.word.setLength(0);
        this.space.setLength(0);

        TransitionTable table = TransitionTable.get();
        State pstate = State.GROUND;
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        int i = 0;
        while (i < bytes.length) {
            Transition transition = table.transition(pstate, bytes[i]);
            State state = transition.state();
            Action action = transition.action();

            if (state == State.UTF8) {
                i = handleUtf8(bytes, i);
                pstate = State.GROUND;
                continue;
            }

            if (action == Action.PRINT || action == Action.EXECUTE) {
                handlePrint(bytes[i]);
            } else {
                // We're inside an ANSI escape sequence
                word.append((char) bytes[i]);
            }

            if (pstate != State.UTF8) {
                pstate = state;
            }
            i++;
        }

        if (wordLen == 0) {
            if (curWidth + spaceWidth > limit) {
                curWidth = 0;
            } else {
                buf.append(space);
            }
            space.setLength(0);
            spaceWidth = 0;
        }

        addWord();
        return buf.toString();
    }

    private int handleUtf8(byte[] bytes, int i) {
        GraphemeResult graphemeResult =
            GraphemeCluster.getFirstGraphemeCluster(bytes, i, -1);
        if (graphemeResult == null) {
            return i + 1;
        }

        byte[] cluster = graphemeResult.cluster();
        int width = graphemeResult.width();
        String grapheme = new String(cluster, StandardCharsets.UTF_8);
        int codePoint = grapheme.codePointAt(0);

        if (
            UCharacter.isWhitespace(codePoint) &&
            codePoint != NBSP.codePointAt(0)
        ) {
            addWord();
            space.append(grapheme);
            spaceWidth += width;
        } else if (containsAny(grapheme, BREAKPOINTS)) {
            addSpace();
            if (curWidth + wordLen + width > limit) {
                word.append(grapheme);
                wordLen += width;
            } else {
                addWord();
                buf.append(grapheme);
                curWidth += width;
            }
        } else {
            if (wordLen + width > limit) {
                addWord();
            }
            word.append(grapheme);
            wordLen += width;
            if (curWidth + wordLen + spaceWidth > limit) {
                addNewLine();
            }
            if (wordLen == limit) {
                addWord();
            }
        }

        return i + cluster.length;
    }

    private void handlePrint(byte b) {
        char ch = (char) b;
        if (ch == '\n') {
            if (wordLen == 0) {
                if (curWidth + spaceWidth > limit) {
                    curWidth = 0;
                } else {
                    buf.append(space);
                }
                space.setLength(0);
                spaceWidth = 0;
            }
            addWord();
            addNewLine();
        } else if (UCharacter.isWhitespace(ch)) {
            addWord();
            space.append(ch);
            spaceWidth++;
        } else if (ch == '-' || containsAny(ch, BREAKPOINTS)) {
            addSpace();
            if (curWidth + wordLen >= limit) {
                word.append(ch);
                wordLen++;
            } else {
                addWord();
                buf.append(ch);
                curWidth++;
            }
        } else {
            if (curWidth == limit) {
                addNewLine();
            }
            word.append(ch);
            wordLen++;
            if (wordLen == limit) {
                addWord();
            }
            if (curWidth + wordLen + spaceWidth > limit) {
                addNewLine();
            }
        }
    }

    /**
     * Handles add space for this component.
     */
    private void addSpace() {
        if (spaceWidth == 0 && space.length() == 0) {
            return;
        }
        curWidth += spaceWidth;
        buf.append(space);
        space.setLength(0);
        spaceWidth = 0;
    }

    /**
     * Handles add word for this component.
     */
    private void addWord() {
        if (word.isEmpty()) {
            return;
        }
        addSpace();
        curWidth += wordLen;
        buf.append(word);
        word.setLength(0);
        wordLen = 0;
    }

    /**
     * Handles add new line for this component.
     */
    private void addNewLine() {
        buf.append('\n');
        curWidth = 0;
        space.setLength(0);
        spaceWidth = 0;
    }

    /**
     * Returns whether a value contains any configured breakpoints.
     *
     * @param value string value to scan
     * @param breakpoints breakpoint characters
     * @return true when any breakpoint is present
     */
    private static boolean containsAny(String value, String breakpoints) {
        if (breakpoints.isEmpty() || value.isEmpty()) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            int codePoint = value.codePointAt(i);
            if (breakpoints.indexOf(codePoint) >= 0) {
                return true;
            }
            i += Character.charCount(codePoint) - 1;
        }
        return false;
    }

    /**
     * Returns whether a value contains any configured breakpoints.
     *
     * @param value character to check
     * @param breakpoints breakpoint characters
     * @return true when any breakpoint matches
     */
    private static boolean containsAny(char value, String breakpoints) {
        return !breakpoints.isEmpty() && breakpoints.indexOf(value) >= 0;
    }
}
