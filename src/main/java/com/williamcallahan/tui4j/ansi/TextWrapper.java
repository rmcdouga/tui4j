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
 * current line width would exceed the limit.
 */
public class TextWrapper {

    private static final String NBSP = "\u00A0";  // Non-breaking space

    /**
     * Creates a text wrapper instance.
     */
    public TextWrapper() {
    }

    private int limit;
    private int curWidth;
    private int wordLen;

    private StringBuilder buf = new StringBuilder();   // Final wrapped text
    private StringBuilder word = new StringBuilder();  // Current word
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
        TransitionTable table = TransitionTable.get();
        State pstate = State.GROUND;
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        int i = 0;
        while (i < bytes.length) {
            Transition transition = table.transition(pstate, bytes[i]);
            State state = transition.state();
            Action action = transition.action();

            if (state == State.UTF8) {
                i = processUtf8Grapheme(bytes, i);
                pstate = State.GROUND;
                continue;
            }

            char ch = (char) bytes[i];
            if (action == Action.PRINT || action == Action.EXECUTE) {
                processPrintableChar(ch);
            } else {
                word.append(ch);
            }

            if (pstate != State.UTF8) {
                pstate = state;
            }
            i++;
        }

        flushTrailingSpace();
        addWord();
        return buf.toString();
    }

    /**
     * Processes a UTF-8 multibyte grapheme cluster starting at the given index.
     *
     * @param bytes the UTF-8 byte array
     * @param i     current byte index
     * @return the next byte index after the grapheme cluster
     */
    private int processUtf8Grapheme(byte[] bytes, int i) {
        GraphemeResult graphemeResult = GraphemeCluster.getFirstGraphemeCluster(bytes, i, -1);
        if (graphemeResult == null) {
            return i + 1;
        }

        byte[] cluster = graphemeResult.cluster();
        int width = graphemeResult.width();
        String grapheme = new String(cluster, StandardCharsets.UTF_8);

        if (UCharacter.isWhitespace(grapheme.codePointAt(0)) && !NBSP.equals(grapheme)) {
            addWord();
            space.append(grapheme);
        } else {
            appendGraphemeToWord(grapheme, width);
        }

        return i + cluster.length;
    }

    /**
     * Appends a grapheme cluster to the current word, handling line breaks if needed.
     */
    private void appendGraphemeToWord(String grapheme, int width) {
        if (wordLen + width > limit) {
            addWord();
        }

        word.append(grapheme);
        wordLen += width;

        if (curWidth + wordLen + space.length() > limit) {
            addNewLine();
        }
    }

    /**
     * Processes a printable ASCII character (PRINT or EXECUTE action).
     */
    private void processPrintableChar(char ch) {
        if (ch == '\n') {
            handleNewline();
        } else if (UCharacter.isWhitespace(ch)) {
            handleWhitespace(ch);
        } else if (ch == '-') {
            handleHyphen(ch);
        } else {
            handleRegularChar(ch);
        }
    }

    /**
     * Handles a newline character: flushes word and starts new line.
     */
    private void handleNewline() {
        if (wordLen == 0) {
            if (curWidth + space.length() > limit) {
                curWidth = 0;
            } else {
                buf.append(space);
            }
            space.setLength(0);
        }
        addWord();
        addNewLine();
    }

    /**
     * Handles whitespace: ends current word and accumulates space.
     */
    private void handleWhitespace(char ch) {
        addWord();
        space.append(ch);
    }

    /**
     * Handles hyphen: allows line break after hyphen if at word boundary.
     */
    private void handleHyphen(char ch) {
        addSpace();
        if (curWidth + wordLen >= limit) {
            word.append(ch);
            wordLen++;
        } else {
            addWord();
            buf.append(ch);
            curWidth++;
        }
    }

    /**
     * Handles a regular printable character: appends to word with line-break logic.
     */
    private void handleRegularChar(char ch) {
        if (curWidth == limit) {
            addNewLine();
        }
        word.append(ch);
        wordLen++;

        if (wordLen == limit) {
            addWord();
        }

        if (curWidth + wordLen + space.length() > limit) {
            addNewLine();
        }
    }

    /**
     * Flushes trailing spaces at end of input.
     */
    private void flushTrailingSpace() {
        if (wordLen == 0) {
            if (curWidth + space.length() > limit) {
                curWidth = 0;
            } else {
                buf.append(space);
            }
            space.setLength(0);
        }
    }

    /**
     * Handles add space for this component.
     */
    private void addSpace() {
        curWidth += space.length();
        buf.append(space);
        space.setLength(0);
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
    }
}
