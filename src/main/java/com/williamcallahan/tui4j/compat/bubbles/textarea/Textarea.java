package com.williamcallahan.tui4j.compat.bubbles.textarea;

import com.ibm.icu.lang.UCharacter;
import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.lipgloss.color.AdaptiveColor;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor;
import com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static com.williamcallahan.tui4j.compat.bubbletea.Command.batch;

/**
 * Multi-line text editor bubble.
 * <p>
 * Port of {@code bubbles/textarea/textarea.go}.
 * Supports cursor movement, insertion, deletion, and line wrapping.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/textarea/textarea.go">bubbles/textarea/textarea.go</a>
 */
public class Textarea implements Model {

    /**
     * Compatibility helper for Style to keep API parity.
     */
    public static class Style {
        private com.williamcallahan.tui4j.compat.lipgloss.Style base;
        private com.williamcallahan.tui4j.compat.lipgloss.Style cursorLine;
        private com.williamcallahan.tui4j.compat.lipgloss.Style cursorLineNumber;
        private com.williamcallahan.tui4j.compat.lipgloss.Style endOfBuffer;
        private com.williamcallahan.tui4j.compat.lipgloss.Style lineNumber;
        private com.williamcallahan.tui4j.compat.lipgloss.Style placeholder;
        private com.williamcallahan.tui4j.compat.lipgloss.Style prompt;
        private com.williamcallahan.tui4j.compat.lipgloss.Style text;

        /**
         * Creates Style to keep this component ready for use.
         */
        public Style() {
            this.base = com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle();
            this.cursorLine = com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle();
            this.cursorLineNumber = com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle();
            this.endOfBuffer = com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle();
            this.lineNumber = com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle();
            this.placeholder = com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle();
            this.prompt = com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle();
            this.text = com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle();
        }

        /**
         * Handles base for this component.
         *
         * @param base base
         * @return result
         */
        public Style base(com.williamcallahan.tui4j.compat.lipgloss.Style base) {
            this.base = base;
            return this;
        }

        /**
         * Handles cursor line for this component.
         *
         * @param cursorLine cursor line
         * @return result
         */
        public Style cursorLine(com.williamcallahan.tui4j.compat.lipgloss.Style cursorLine) {
            this.cursorLine = cursorLine;
            return this;
        }

        /**
         * Handles cursor line number for this component.
         *
         * @param cursorLineNumber cursor line number
         * @return result
         */
        public Style cursorLineNumber(com.williamcallahan.tui4j.compat.lipgloss.Style cursorLineNumber) {
            this.cursorLineNumber = cursorLineNumber;
            return this;
        }

        /**
         * Handles end of buffer for this component.
         *
         * @param endOfBuffer end of buffer
         * @return result
         */
        public Style endOfBuffer(com.williamcallahan.tui4j.compat.lipgloss.Style endOfBuffer) {
            this.endOfBuffer = endOfBuffer;
            return this;
        }

        /**
         * Handles line number for this component.
         *
         * @param lineNumber line number
         * @return result
         */
        public Style lineNumber(com.williamcallahan.tui4j.compat.lipgloss.Style lineNumber) {
            this.lineNumber = lineNumber;
            return this;
        }

        /**
         * Handles placeholder for this component.
         *
         * @param placeholder placeholder
         * @return result
         */
        public Style placeholder(com.williamcallahan.tui4j.compat.lipgloss.Style placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        /**
         * Handles prompt for this component.
         *
         * @param prompt prompt
         * @return result
         */
        public Style prompt(com.williamcallahan.tui4j.compat.lipgloss.Style prompt) {
            this.prompt = prompt;
            return this;
        }

        /**
         * Handles text for this component.
         *
         * @param text text
         * @return result
         */
        public Style text(com.williamcallahan.tui4j.compat.lipgloss.Style text) {
            this.text = text;
            return this;
        }

        /**
         * Handles base for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style base() {
            return base;
        }

        /**
         * Handles cursor line for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style cursorLine() {
            return cursorLine;
        }

        /**
         * Handles cursor line number for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style cursorLineNumber() {
            return cursorLineNumber;
        }

        /**
         * Handles end of buffer for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style endOfBuffer() {
            return endOfBuffer;
        }

        /**
         * Handles line number for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style lineNumber() {
            return lineNumber;
        }

        /**
         * Handles placeholder for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style placeholder() {
            return placeholder;
        }

        /**
         * Handles prompt for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style prompt() {
            return prompt;
        }

        /**
         * Handles text for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style text() {
            return text;
        }

        /**
         * Handles computed cursor line for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style computedCursorLine() {
            return cursorLine.inherit(base).inline(true);
        }

        /**
         * Handles computed cursor line number for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style computedCursorLineNumber() {
            return cursorLineNumber.inherit(cursorLine).inherit(base).inline(true);
        }

        /**
         * Handles computed end of buffer for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style computedEndOfBuffer() {
            return endOfBuffer.inherit(base).inline(true);
        }

        /**
         * Handles computed line number for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style computedLineNumber() {
            return lineNumber.inherit(base).inline(true);
        }

        /**
         * Handles computed placeholder for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style computedPlaceholder() {
            return placeholder.inherit(base).inline(true);
        }

        /**
         * Handles computed prompt for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style computedPrompt() {
            return prompt.inherit(base).inline(true);
        }

        /**
         * Handles computed text for this component.
         *
         * @return result
         */
        public com.williamcallahan.tui4j.compat.lipgloss.Style computedText() {
            return text.inherit(base).inline(true);
        }
    }

    /**
     * Compatibility helper for KeyMap to keep API parity.
     */
    public static class KeyMap {
        private Binding characterBackward;
        private Binding characterForward;
        private Binding deleteAfterCursor;
        private Binding deleteBeforeCursor;
        private Binding deleteCharacterBackward;
        private Binding deleteCharacterForward;
        private Binding deleteWordBackward;
        private Binding deleteWordForward;
        private Binding insertNewline;
        private Binding lineEnd;
        private Binding lineNext;
        private Binding linePrevious;
        private Binding lineStart;
        private Binding paste;
        private Binding wordBackward;
        private Binding wordForward;
        private Binding inputBegin;
        private Binding inputEnd;
        private Binding uppercaseWordForward;
        private Binding lowercaseWordForward;
        private Binding capitalizeWordForward;
        private Binding transposeCharacterBackward;

        /**
         * Creates KeyMap to keep this component ready for use.
         */
        public KeyMap() {
            this.characterBackward = new Binding(Binding.withKeys("left", "ctrl+b"), Binding.withHelp("left", "character backward"));
            this.characterForward = new Binding(Binding.withKeys("right", "ctrl+f"), Binding.withHelp("right", "character forward"));
            this.wordForward = new Binding(Binding.withKeys("alt+right", "alt+f"), Binding.withHelp("alt+right", "word forward"));
            this.wordBackward = new Binding(Binding.withKeys("alt+left", "alt+b"), Binding.withHelp("alt+left", "word backward"));
            this.lineNext = new Binding(Binding.withKeys("down", "ctrl+n"), Binding.withHelp("down", "next line"));
            this.linePrevious = new Binding(Binding.withKeys("up", "ctrl+p"), Binding.withHelp("up", "previous line"));
            this.deleteWordBackward = new Binding(Binding.withKeys("alt+backspace", "ctrl+w"), Binding.withHelp("alt+backspace", "delete word backward"));
            this.deleteWordForward = new Binding(Binding.withKeys("alt+delete", "alt+d"), Binding.withHelp("alt+delete", "delete word forward"));
            this.deleteAfterCursor = new Binding(Binding.withKeys("ctrl+k"), Binding.withHelp("ctrl+k", "delete after cursor"));
            this.deleteBeforeCursor = new Binding(Binding.withKeys("ctrl+u"), Binding.withHelp("ctrl+u", "delete before cursor"));
            this.insertNewline = new Binding(Binding.withKeys("enter", "ctrl+m"), Binding.withHelp("enter", "insert newline"));
            this.deleteCharacterBackward = new Binding(Binding.withKeys("backspace", "ctrl+h"), Binding.withHelp("backspace", "delete character backward"));
            this.deleteCharacterForward = new Binding(Binding.withKeys("delete", "ctrl+d"), Binding.withHelp("delete", "delete character forward"));
            this.lineStart = new Binding(Binding.withKeys("home", "ctrl+a"), Binding.withHelp("home", "line start"));
            this.lineEnd = new Binding(Binding.withKeys("end", "ctrl+e"), Binding.withHelp("end", "line end"));
            this.paste = new Binding(Binding.withKeys("ctrl+v"), Binding.withHelp("ctrl+v", "paste"));
            this.inputBegin = new Binding(Binding.withKeys("alt+<", "ctrl+home"), Binding.withHelp("alt+<", "input begin"));
            this.inputEnd = new Binding(Binding.withKeys("alt+>", "ctrl+end"), Binding.withHelp("alt+>", "input end"));
            this.capitalizeWordForward = new Binding(Binding.withKeys("alt+c"), Binding.withHelp("alt+c", "capitalize word forward"));
            this.lowercaseWordForward = new Binding(Binding.withKeys("alt+l"), Binding.withHelp("alt+l", "lowercase word forward"));
            this.uppercaseWordForward = new Binding(Binding.withKeys("alt+u"), Binding.withHelp("alt+u", "uppercase word forward"));
            this.transposeCharacterBackward = new Binding(Binding.withKeys("ctrl+t"), Binding.withHelp("ctrl+t", "transpose character backward"));
        }

        /**
         * Handles character backward for this component.
         *
         * @return result
         */
        public Binding characterBackward() {
            return characterBackward;
        }

        /**
         * Handles character forward for this component.
         *
         * @return result
         */
        public Binding characterForward() {
            return characterForward;
        }

        /**
         * Handles delete after cursor for this component.
         *
         * @return result
         */
        public Binding deleteAfterCursor() {
            return deleteAfterCursor;
        }

        /**
         * Handles delete before cursor for this component.
         *
         * @return result
         */
        public Binding deleteBeforeCursor() {
            return deleteBeforeCursor;
        }

        /**
         * Handles delete character backward for this component.
         *
         * @return result
         */
        public Binding deleteCharacterBackward() {
            return deleteCharacterBackward;
        }

        /**
         * Handles delete character forward for this component.
         *
         * @return result
         */
        public Binding deleteCharacterForward() {
            return deleteCharacterForward;
        }

        /**
         * Handles delete word backward for this component.
         *
         * @return result
         */
        public Binding deleteWordBackward() {
            return deleteWordBackward;
        }

        /**
         * Handles delete word forward for this component.
         *
         * @return result
         */
        public Binding deleteWordForward() {
            return deleteWordForward;
        }

        /**
         * Handles insert newline for this component.
         *
         * @return result
         */
        public Binding insertNewline() {
            return insertNewline;
        }

        /**
         * Handles line end for this component.
         *
         * @return result
         */
        public Binding lineEnd() {
            return lineEnd;
        }

        /**
         * Handles line next for this component.
         *
         * @return result
         */
        public Binding lineNext() {
            return lineNext;
        }

        /**
         * Handles line previous for this component.
         *
         * @return result
         */
        public Binding linePrevious() {
            return linePrevious;
        }

        /**
         * Handles line start for this component.
         *
         * @return result
         */
        public Binding lineStart() {
            return lineStart;
        }

        /**
         * Handles paste for this component.
         *
         * @return result
         */
        public Binding paste() {
            return paste;
        }

        /**
         * Handles word backward for this component.
         *
         * @return result
         */
        public Binding wordBackward() {
            return wordBackward;
        }

        /**
         * Handles word forward for this component.
         *
         * @return result
         */
        public Binding wordForward() {
            return wordForward;
        }

        /**
         * Handles input begin for this component.
         *
         * @return result
         */
        public Binding inputBegin() {
            return inputBegin;
        }

        /**
         * Handles input end for this component.
         *
         * @return result
         */
        public Binding inputEnd() {
            return inputEnd;
        }

        /**
         * Handles uppercase word forward for this component.
         *
         * @return result
         */
        public Binding uppercaseWordForward() {
            return uppercaseWordForward;
        }

        /**
         * Handles lowercase word forward for this component.
         *
         * @return result
         */
        public Binding lowercaseWordForward() {
            return lowercaseWordForward;
        }

        /**
         * Handles capitalize word forward for this component.
         *
         * @return result
         */
        public Binding capitalizeWordForward() {
            return capitalizeWordForward;
        }

        /**
         * Handles transpose character backward for this component.
         *
         * @return result
         */
        public Binding transposeCharacterBackward() {
            return transposeCharacterBackward;
        }
    }

    /**
     * Compatibility helper for LineInfo to keep API parity.
     */
    public static class LineInfo {
        private int width;
        private int charWidth;
        private int height;
        private int startColumn;
        private int columnOffset;
        private int rowOffset;
        private int charOffset;

        /**
         * Creates LineInfo to keep this component ready for use.
         */
        public LineInfo() {
        }

        /**
         * Creates LineInfo to keep this component ready for use.
         *
         * @param width width
         * @param charWidth char width
         * @param height height
         * @param startColumn start column
         * @param columnOffset column offset
         * @param rowOffset row offset
         * @param charOffset char offset
         */
        public LineInfo(int width, int charWidth, int height, int startColumn, int columnOffset, int rowOffset, int charOffset) {
            this.width = width;
            this.charWidth = charWidth;
            this.height = height;
            this.startColumn = startColumn;
            this.columnOffset = columnOffset;
            this.rowOffset = rowOffset;
            this.charOffset = charOffset;
        }

        /**
         * Handles width for this component.
         *
         * @return result
         */
        public int width() {
            return width;
        }

        /**
         * Handles char width for this component.
         *
         * @return result
         */
        public int charWidth() {
            return charWidth;
        }

        /**
         * Handles height for this component.
         *
         * @return result
         */
        public int height() {
            return height;
        }

        /**
         * Handles start column for this component.
         *
         * @return result
         */
        public int startColumn() {
            return startColumn;
        }

        /**
         * Handles column offset for this component.
         *
         * @return result
         */
        public int columnOffset() {
            return columnOffset;
        }

        /**
         * Handles row offset for this component.
         *
         * @return result
         */
        public int rowOffset() {
            return rowOffset;
        }

        /**
         * Handles char offset for this component.
         *
         * @return result
         */
        public int charOffset() {
            return charOffset;
        }

        /**
         * Handles width for this component.
         *
         * @param width width
         * @return result
         */
        public LineInfo width(int width) {
            this.width = width;
            return this;
        }

        /**
         * Handles char width for this component.
         *
         * @param charWidth char width
         * @return result
         */
        public LineInfo charWidth(int charWidth) {
            this.charWidth = charWidth;
            return this;
        }

        /**
         * Handles height for this component.
         *
         * @param height height
         * @return result
         */
        public LineInfo height(int height) {
            this.height = height;
            return this;
        }

        /**
         * Handles start column for this component.
         *
         * @param startColumn start column
         * @return result
         */
        public LineInfo startColumn(int startColumn) {
            this.startColumn = startColumn;
            return this;
        }

        /**
         * Handles column offset for this component.
         *
         * @param columnOffset column offset
         * @return result
         */
        public LineInfo columnOffset(int columnOffset) {
            this.columnOffset = columnOffset;
            return this;
        }

        /**
         * Handles row offset for this component.
         *
         * @param rowOffset row offset
         * @return result
         */
        public LineInfo rowOffset(int rowOffset) {
            this.rowOffset = rowOffset;
            return this;
        }

        /**
         * Handles char offset for this component.
         *
         * @param charOffset char offset
         * @return result
         */
        public LineInfo charOffset(int charOffset) {
            this.charOffset = charOffset;
            return this;
        }
    }

    private static final int MIN_HEIGHT = 1;
    private static final int DEFAULT_HEIGHT = 6;
    private static final int DEFAULT_WIDTH = 40;
    private static final int DEFAULT_CHAR_LIMIT = 0;
    private static final int DEFAULT_MAX_HEIGHT = 99;
    private static final int DEFAULT_MAX_WIDTH = 500;
    private static final int MAX_LINES = 10000;

    private String prompt;
    private String placeholder;
    private boolean showLineNumbers;
    private char endOfBufferCharacter;
    private KeyMap keyMap;
    private Style focusedStyle;
    private Style blurredStyle;
    private Style style;
    private Cursor cursor;
    private int charLimit;
    private int maxHeight;
    private int maxWidth;
    private int promptWidth;
    private int width;
    private int height;
    private List<char[]> value;
    private boolean focus;
    private int col;
    private int row;
    private int lastCharOffset;
    private Sanitizer sanitizer;
    private int lineNumberWidth;

    /**
     * Creates Textarea to keep this component ready for use.
     */
    public Textarea() {
        this.prompt = "| ";
        this.placeholder = "";
        this.showLineNumbers = true;
        this.endOfBufferCharacter = ' ';
        this.keyMap = new KeyMap();
        this.focusedStyle = defaultStyles(true);
        this.blurredStyle = defaultStyles(false);
        this.style = blurredStyle;
        this.cursor = new Cursor();
        this.charLimit = DEFAULT_CHAR_LIMIT;
        this.maxHeight = DEFAULT_MAX_HEIGHT;
        this.maxWidth = DEFAULT_MAX_WIDTH;
        this.promptWidth = TextWidth.measureCellWidth(prompt);
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
        this.value = new ArrayList<>();
        this.value.add(new char[0]);
        this.focus = false;
        this.col = 0;
        this.row = 0;
        this.lastCharOffset = 0;
        this.sanitizer = new Sanitizer(
                Sanitizer.replaceTabs("    ")
        );
        this.lineNumberWidth = 4;
    }

    /**
     * Handles default styles for this component.
     *
     * @param focused focused
     * @return result
     */
    private static Textarea.Style defaultStyles(boolean focused) {
        Textarea.Style style = new Textarea.Style();
        style.base(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle());
        if (focused) {
            style.cursorLine(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().background(new AdaptiveColor("255", "0")));
            style.cursorLineNumber(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(new AdaptiveColor("240", "240")));
            style.endOfBuffer(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(new AdaptiveColor("254", "0")));
            style.lineNumber(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(new AdaptiveColor("249", "7")));
            style.placeholder(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(Color.color("240")));
            style.prompt(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(Color.color("7")));
            style.text(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle());
        } else {
            style.cursorLine(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(new AdaptiveColor("245", "7")));
            style.cursorLineNumber(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(new AdaptiveColor("249", "7")));
            style.endOfBuffer(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(new AdaptiveColor("254", "0")));
            style.lineNumber(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(new AdaptiveColor("249", "7")));
            style.placeholder(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(Color.color("240")));
            style.prompt(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(Color.color("7")));
            style.text(com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foreground(new AdaptiveColor("245", "7")));
        }
        return style;
    }

    /**
     * Supplies the initial command for the model.
     *
     * @return initial command
     */
    @Override
    public Command init() {
        return null;
    }

    /**
     * Updates the model based on key events or command messages.
     * Handles cursor blink and text mutations.
     */
    @Override
    public UpdateResult<Textarea> update(Message msg) {
        if (!focus) {
            cursor.blur();
            return UpdateResult.from(this);
        }

        int oldRow = cursorLineNumber();
        int oldCol = col;

        if (value.get(row) == null) {
            value.set(row, new char[0]);
        }

        if (msg instanceof KeyPressMessage keyPressMessage) {
            handleKeyPress(keyPressMessage);
        }

        List<Command> commands = new LinkedList<>();

        UpdateResult<Cursor> cursorUpdateResult = cursor.update(msg);
        this.cursor = cursorUpdateResult.model();
        commands.add(cursorUpdateResult.command());

        if ((cursorLineNumber() != oldRow || col != oldCol) && cursor.mode() == CursorMode.Blink) {
            cursor.setBlink(false);
            commands.add(cursor.blinkCommand());
        }

        return UpdateResult.from(this, batch(commands.toArray(new Command[0])));
    }

    /**
     * Handles handle key press for this component.
     *
     * @param keyPressMessage key press message
     */
    private void handleKeyPress(KeyPressMessage keyPressMessage) {
        if (handleEditing(keyPressMessage)) {
            return;
        }
        if (handleNavigation(keyPressMessage)) {
            return;
        }
        if (handleTransform(keyPressMessage)) {
            return;
        }
        insertRunesFromUserInput(keyPressMessage.runes());
    }

    /**
     * Handles handle editing for this component.
     *
     * @param keyPressMessage key press message
     * @return whether ndle editing
     */
    private boolean handleEditing(KeyPressMessage keyPressMessage) {
        if (Binding.matches(keyPressMessage, keyMap.deleteAfterCursor())) {
            handleDeleteAfterCursor();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.deleteBeforeCursor())) {
            handleDeleteBeforeCursor();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.deleteCharacterBackward())) {
            handleDeleteCharacterBackward();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.deleteCharacterForward())) {
            handleDeleteCharacterForward();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.deleteWordBackward())) {
            handleDeleteWordBackward();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.deleteWordForward())) {
            handleDeleteWordForward();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.insertNewline())) {
            handleInsertNewline();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.paste())) {
            insertRunesFromUserInput(keyPressMessage.runes());
            return true;
        }
        return false;
    }

    /**
     * Handles handle navigation for this component.
     *
     * @param keyPressMessage key press message
     * @return whether ndle navigation
     */
    private boolean handleNavigation(KeyPressMessage keyPressMessage) {
        if (Binding.matches(keyPressMessage, keyMap.lineEnd())) {
            cursorEnd();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.lineStart())) {
            cursorStart();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.characterForward())) {
            characterRight();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.lineNext())) {
            cursorDown();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.wordForward())) {
            wordRight();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.characterBackward())) {
            characterLeft(false);
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.linePrevious())) {
            cursorUp();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.wordBackward())) {
            wordLeft();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.inputBegin())) {
            moveToBegin();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.inputEnd())) {
            moveToEnd();
            return true;
        }
        return false;
    }

    /**
     * Handles handle transform for this component.
     *
     * @param keyPressMessage key press message
     * @return whether ndle transform
     */
    private boolean handleTransform(KeyPressMessage keyPressMessage) {
        if (Binding.matches(keyPressMessage, keyMap.lowercaseWordForward())) {
            lowercaseRight();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.uppercaseWordForward())) {
            uppercaseRight();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.capitalizeWordForward())) {
            capitalizeRight();
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.transposeCharacterBackward())) {
            transposeLeft();
            return true;
        }
        return false;
    }

    /**
     * Handles handle insert newline for this component.
     */
    private void handleInsertNewline() {
        if (maxHeight > 0 && value.size() >= maxHeight) {
            return;
        }
        col = clamp(col, 0, value.get(row).length);
        splitLine(row, col);
    }

    /**
     * Handles handle delete word forward for this component.
     */
    private void handleDeleteWordForward() {
        col = clamp(col, 0, value.get(row).length);
        if (col >= value.get(row).length) {
            mergeLineBelow(row);
        } else {
            deleteWordRight();
        }
    }

    /**
     * Handles handle delete word backward for this component.
     */
    private void handleDeleteWordBackward() {
        if (col <= 0) {
            mergeLineAbove(row);
        } else {
            deleteWordLeft();
        }
    }

    /**
     * Handles handle delete character forward for this component.
     */
    private void handleDeleteCharacterForward() {
        if (value.get(row).length > 0 && col < value.get(row).length) {
            char[] newLine = new char[value.get(row).length - 1];
            System.arraycopy(value.get(row), 0, newLine, 0, col);
            System.arraycopy(value.get(row), col + 1, newLine, col, value.get(row).length - col - 1);
            value.set(row, newLine);
        }
        if (col >= value.get(row).length) {
            mergeLineBelow(row);
        }
    }

    /**
     * Handles handle delete character backward for this component.
     */
    private void handleDeleteCharacterBackward() {
        col = clamp(col, 0, value.get(row).length);
        if (col <= 0) {
            mergeLineAbove(row);
        } else if (value.get(row).length > 0) {
            char[] newLine = new char[max(0, value.get(row).length - 1)];
            System.arraycopy(value.get(row), 0, newLine, 0, max(0, col - 1));
            System.arraycopy(value.get(row), col, newLine, max(0, col - 1), value.get(row).length - col);
            value.set(row, newLine);
            setCursor(col - 1);
        }
    }

    /**
     * Handles handle delete before cursor for this component.
     */
    private void handleDeleteBeforeCursor() {
        col = clamp(col, 0, value.get(row).length);
        if (col <= 0) {
            mergeLineAbove(row);
        } else {
            deleteBeforeCursor();
        }
    }

    /**
     * Handles handle delete after cursor for this component.
     */
    private void handleDeleteAfterCursor() {
        col = clamp(col, 0, value.get(row).length);
        if (col >= value.get(row).length) {
            mergeLineBelow(row);
        } else {
            deleteAfterCursor();
        }
    }

    /**
     * Renders the model view for display.
     *
     * @return rendered view
     */
    @Override
    public String view() {
        if (value() == null || value().isEmpty()) {
            return placeholderView();
        }

        cursor.resetTextStyle();
        cursor.setTextStyle(style.computedCursorLine());

        StringBuilder sb = new StringBuilder();

        int displayLine = 0;
        for (int l = 0; l < value.size(); l++) {
            char[] line = value.get(l);
            List<char[]> wrappedLines = wrap(Arrays.copyOf(line, line.length), width);

            for (int wl = 0; wl < wrappedLines.size(); wl++) {
                char[] wrappedLine = wrappedLines.get(wl);

                String promptStr = getPromptString(displayLine);
                sb.append(style.computedPrompt().render(promptStr));
                displayLine++;

                if (showLineNumbers) {
                    String lineNum;
                    if (wl == 0) {
                        lineNum = formatLineNumber(l + 1);
                    } else {
                        lineNum = " ";
                    }
                    if (row == l) {
                        sb.append(style.computedCursorLine().render(
                            style.computedCursorLineNumber().render(lineNum)));
                    } else {
                        sb.append(style.computedLineNumber().render(lineNum));
                    }
                }

                int lineWidth = TextWidth.measureCellWidth(new String(wrappedLine));
                int padding = max(0, width - lineWidth);

                if (row == l) {
                    LineInfo lineInfo = lineInfo();
                    sb.append(style.computedText().render(
                        new String(Arrays.copyOf(wrappedLine, lineInfo.columnOffset()))));

                    String charAfterCursor = "";
                    if (lineInfo.columnOffset() < wrappedLine.length) {
                        charAfterCursor = new String(new char[]{wrappedLine[lineInfo.columnOffset()]});
                    }
                    cursor.setChar(charAfterCursor);
                    sb.append(cursor.view());

                    if (lineInfo.columnOffset() + 1 < wrappedLine.length) {
                        sb.append(style.computedText().render(
                            new String(Arrays.copyOfRange(wrappedLine, lineInfo.columnOffset() + 1, wrappedLine.length))));
                    }
                } else {
                    sb.append(style.computedText().render(new String(wrappedLine)));
                }

                sb.append(" ".repeat(padding));
                sb.append('\n');
            }
        }

        int remainingLines = max(0, height - displayLine);
        for (int i = 0; i < remainingLines; i++) {
            String promptStr = getPromptString(displayLine);
            sb.append(style.computedPrompt().render(promptStr));
            displayLine++;

            String eob = style.computedEndOfBuffer().render(String.valueOf(endOfBufferCharacter));
            int rightGapWidth = max(0, width - 1 + lineNumberWidth);
            String rightGap = " ".repeat(rightGapWidth);
            sb.append(eob).append(rightGap);
            sb.append('\n');
        }

        return style.base().render(sb.toString());
    }

    /**
     * Handles placeholder view for this component.
     *
     * @return result
     */
    private String placeholderView() {
        if (placeholder == null || placeholder.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] placeholderLines = placeholder.split("\n");

        for (int i = 0; i < height; i++) {
            String promptStr = getPromptString(i);
            sb.append(style.computedPrompt().render(promptStr));

            if (showLineNumbers) {
                String lineNum = i < placeholderLines.length ? formatLineNumber(i + 1) : " ";
                if (i == 0) {
                    sb.append(style.computedCursorLine().render(
                        style.computedCursorLineNumber().render(lineNum)));
                } else if (i < placeholderLines.length) {
                    sb.append(style.computedLineNumber().render(lineNum));
                } else {
                    sb.append(style.computedLineNumber().render(" "));
                }
            }

            if (i == 0 && placeholderLines.length > 0) {
                cursor.resetTextStyle();
                cursor.setTextStyle(style.computedPlaceholder());
                if (placeholderLines[0].length() > 0) {
                    char firstChar = placeholderLines[0].charAt(0);
                    cursor.setChar(String.valueOf(firstChar));
                    sb.append(cursor.view());
                    sb.append(style.computedPlaceholder().render(
                        placeholderLines[0].substring(1)));
                }
            } else if (i < placeholderLines.length) {
                int lineWidth = TextWidth.measureCellWidth(placeholderLines[i]);
                int padding = max(0, width - lineWidth);
                sb.append(style.computedPlaceholder().render(placeholderLines[i]));
                sb.append(" ".repeat(padding));
            } else {
                sb.append(style.computedEndOfBuffer().render(String.valueOf(endOfBufferCharacter)));
            }

            sb.append('\n');
        }

        return style.base().render(sb.toString());
    }

    /**
     * Returns the prompt string.
     *
     * @param displayLine display line
     * @return result
     */
    private String getPromptString(int displayLine) {
        return prompt;
    }

    /**
     * Handles format line number for this component.
     *
     * @param num num
     * @return result
     */
    private String formatLineNumber(int num) {
        int digits = String.valueOf(maxHeight).length();
        return String.format(" %" + digits + "d ", num);
    }

    /**
     * Handles insert runes from user input for this component.
     *
     * @param runes runes
     */
    private void insertRunesFromUserInput(char[] runes) {
        char[] paste = sanitizer.sanitize(runes);

        if (charLimit > 0) {
            int availSpace = charLimit - length();
            if (availSpace <= 0) {
                return;
            }
            if (availSpace < paste.length) {
                paste = Arrays.copyOfRange(paste, 0, availSpace);
            }
        }

        List<char[]> lines = new ArrayList<>();
        int lstart = 0;
        for (int i = 0; i < paste.length; i++) {
            if (paste[i] == '\n') {
                lines.add(Arrays.copyOfRange(paste, lstart, i));
                lstart = i + 1;
            }
        }
        if (lstart <= paste.length) {
            lines.add(Arrays.copyOfRange(paste, lstart, paste.length));
        }

        int allowedHeight = max(0, MAX_LINES - value.size() + 1);
        while (lines.size() > allowedHeight) {
            lines.remove(lines.size() - 1);
        }

        if (lines.isEmpty()) {
            return;
        }

        char[] tail = Arrays.copyOfRange(value.get(row), col, value.get(row).length);

        char[] newCurrentLine = new char[col + lines.get(0).length];
        System.arraycopy(value.get(row), 0, newCurrentLine, 0, col);
        System.arraycopy(lines.get(0), 0, newCurrentLine, col, lines.get(0).length);
        value.set(row, newCurrentLine);
        col += lines.get(0).length;

        if (lines.size() > 1) {
            int numExtraLines = lines.size() - 1;
            int originalRow = row;

            List<char[]> newValue = new ArrayList<>(value.size() + numExtraLines);
            newValue.addAll(value.subList(0, originalRow + 1));

            for (int i = 1; i < lines.size(); i++) {
                row++;
                newValue.add(lines.get(i));
            }

            newValue.addAll(value.subList(originalRow + 1, value.size()));
            value = newValue;

            col = lines.get(lines.size() - 1).length;
        }

        char[] finalLine = new char[value.get(row).length + tail.length];
        System.arraycopy(value.get(row), 0, finalLine, 0, value.get(row).length);
        System.arraycopy(tail, 0, finalLine, value.get(row).length, tail.length);
        value.set(row, finalLine);

        setCursor(col);
    }

    /**
     * Updates the cursor.
     *
     * @param newCol new col
     */
    private void setCursor(int newCol) {
        col = clamp(newCol, 0, value.get(row).length);
        lastCharOffset = 0;
    }

    /**
     * Handles cursor start for this component.
     */
    private void cursorStart() {
        setCursor(0);
    }

    /**
     * Handles cursor end for this component.
     */
    private void cursorEnd() {
        setCursor(value.get(row).length);
    }

    /**
     * Handles cursor down for this component.
     */
    private void cursorDown() {
        LineInfo li = lineInfo();
        int charOffset = max(lastCharOffset, li.charOffset());
        lastCharOffset = charOffset;

        if (li.rowOffset() + 1 >= li.height() && row < value.size() - 1) {
            row++;
            col = 0;
        } else {
            int trailingSpace = 2;
            int rowLen = value.get(row).length;
            col = rowLen == 0 ? 0 : max(0, min(li.startColumn() + li.width() + trailingSpace, rowLen - 1));
        }

        LineInfo nli = lineInfo();
        col = nli.startColumn();

        if (nli.width() <= 0) {
            return;
        }

        int offset = 0;
        while (offset < charOffset) {
            if (row >= value.size() || col >= value.get(row).length || offset >= nli.charWidth() - 1) {
                break;
            }
            offset += TextWidth.measureCellWidth(String.valueOf(value.get(row)[col]));
            col++;
        }
    }

    /**
     * Handles cursor up for this component.
     */
    private void cursorUp() {
        LineInfo li = lineInfo();
        int charOffset = max(lastCharOffset, li.charOffset());
        lastCharOffset = charOffset;

        if (li.rowOffset() <= 0 && row > 0) {
            row--;
            col = value.get(row).length;
        } else {
            int trailingSpace = 2;
            col = max(0, li.startColumn() - trailingSpace);
        }

        LineInfo nli = lineInfo();
        col = nli.startColumn();

        if (nli.width() <= 0) {
            return;
        }

        int offset = 0;
        while (offset < charOffset) {
            if (col >= value.get(row).length || offset >= nli.charWidth() - 1) {
                break;
            }
            offset += TextWidth.measureCellWidth(String.valueOf(value.get(row)[col]));
            col++;
        }
    }

    /**
     * Handles character right for this component.
     */
    private void characterRight() {
        if (col < value.get(row).length) {
            setCursor(col + 1);
        } else {
            if (row < value.size() - 1) {
                row++;
                cursorStart();
            }
        }
    }

    /**
     * Handles character left for this component.
     *
     * @param insideLine inside line
     */
    private void characterLeft(boolean insideLine) {
        if (col == 0 && row != 0) {
            row--;
            cursorEnd();
            if (!insideLine) {
                return;
            }
        }
        if (col > 0) {
            setCursor(col - 1);
        }
    }

    /**
     * Handles word left for this component.
     */
    private void wordLeft() {
        while (true) {
            if (row == 0 && col == 0) {
                break;
            }
            characterLeft(true);
            if (col < value.get(row).length && !UCharacter.isWhitespace(value.get(row)[col])) {
                break;
            }
        }

        while (col > 0) {
            if (UCharacter.isWhitespace(value.get(row)[col - 1])) {
                break;
            }
            setCursor(col - 1);
        }
    }

    /**
     * Handles word right for this component.
     */
    private void wordRight() {
        while (col >= value.get(row).length || UCharacter.isWhitespace(value.get(row)[col])) {
            if (row == value.size() - 1 && col == value.get(row).length) {
                break;
            }
            characterRight();
        }

        while (col < value.get(row).length && !UCharacter.isWhitespace(value.get(row)[col])) {
            setCursor(col + 1);
        }
    }

    /**
     * Handles delete before cursor for this component.
     */
    private void deleteBeforeCursor() {
        value.set(row, Arrays.copyOfRange(value.get(row), col, value.get(row).length));
        setCursor(0);
    }

    /**
     * Handles delete after cursor for this component.
     */
    private void deleteAfterCursor() {
        value.set(row, Arrays.copyOfRange(value.get(row), 0, col));
        setCursor(value.get(row).length);
    }

    /**
     * Handles delete word left for this component.
     */
    private void deleteWordLeft() {
        if (col == 0 || value.get(row).length == 0) {
            return;
        }

        int oldCol = col;
        setCursor(col - 1);
        while (col > 0 && UCharacter.isWhitespace(value.get(row)[col])) {
            setCursor(col - 1);
        }

        while (col > 0) {
            if (!UCharacter.isWhitespace(value.get(row)[col])) {
                setCursor(col - 1);
            } else {
                setCursor(col + 1);
                break;
            }
        }

        if (oldCol > value.get(row).length) {
            value.set(row, Arrays.copyOfRange(value.get(row), 0, col));
        } else {
            char[] newLine = new char[col + (value.get(row).length - oldCol)];
            System.arraycopy(value.get(row), 0, newLine, 0, col);
            System.arraycopy(value.get(row), oldCol, newLine, col, value.get(row).length - oldCol);
            value.set(row, newLine);
        }
    }

    /**
     * Handles delete word right for this component.
     */
    private void deleteWordRight() {
        if (col >= value.get(row).length || value.get(row).length == 0) {
            return;
        }

        int oldCol = col;

        while (col < value.get(row).length && UCharacter.isWhitespace(value.get(row)[col])) {
            setCursor(col + 1);
        }

        while (col < value.get(row).length) {
            if (!UCharacter.isWhitespace(value.get(row)[col])) {
                setCursor(col + 1);
            } else {
                break;
            }
        }

        if (col > value.get(row).length) {
            value.set(row, Arrays.copyOfRange(value.get(row), 0, oldCol));
        } else {
            char[] newLine = new char[oldCol + (value.get(row).length - col)];
            System.arraycopy(value.get(row), 0, newLine, 0, oldCol);
            System.arraycopy(value.get(row), col, newLine, oldCol, value.get(row).length - col);
            value.set(row, newLine);
        }

        setCursor(oldCol);
    }

    /**
     * Handles split line for this component.
     *
     * @param splitRow split row
     * @param splitCol split col
     */
    private void splitLine(int splitRow, int splitCol) {
        char[] line = value.get(splitRow);
        char[] head = Arrays.copyOfRange(line, 0, splitCol);
        char[] tail = Arrays.copyOfRange(line, splitCol, line.length);

        value.add(splitRow + 1, tail);
        value.set(splitRow, head);

        col = 0;
        row++;
    }

    /**
     * Handles merge line below for this component.
     *
     * @param mergeRow merge row
     */
    private void mergeLineBelow(int mergeRow) {
        if (mergeRow >= value.size() - 1) {
            return;
        }

        char[] newLine = new char[value.get(mergeRow).length + value.get(mergeRow + 1).length];
        System.arraycopy(value.get(mergeRow), 0, newLine, 0, value.get(mergeRow).length);
        System.arraycopy(value.get(mergeRow + 1), 0, newLine, value.get(mergeRow).length, value.get(mergeRow + 1).length);
        value.set(mergeRow, newLine);

        value.remove(mergeRow + 1);
    }

    /**
     * Handles merge line above for this component.
     *
     * @param mergeRow merge row
     */
    private void mergeLineAbove(int mergeRow) {
        if (mergeRow <= 0) {
            return;
        }

        col = value.get(mergeRow - 1).length;
        row = mergeRow - 1;

        char[] newLine = new char[value.get(mergeRow - 1).length + value.get(mergeRow).length];
        System.arraycopy(value.get(mergeRow - 1), 0, newLine, 0, value.get(mergeRow - 1).length);
        System.arraycopy(value.get(mergeRow), 0, newLine, value.get(mergeRow - 1).length, value.get(mergeRow).length);
        value.set(mergeRow - 1, newLine);

        value.remove(mergeRow);
    }

    /**
     * Handles transpose left for this component.
     */
    private void transposeLeft() {
        if (col == 0 || value.get(row).length < 2) {
            return;
        }
        if (col >= value.get(row).length) {
            setCursor(col - 1);
        }
        char temp = value.get(row)[col - 1];
        value.get(row)[col - 1] = value.get(row)[col];
        value.get(row)[col] = temp;
        if (col < value.get(row).length) {
            setCursor(col + 1);
        }
    }

    /**
     * Handles uppercase right for this component.
     */
    private void uppercaseRight() {
        doWordRight((charIdx, i) -> {
            value.get(row)[i] = Character.toUpperCase(value.get(row)[i]);
        });
    }

    /**
     * Handles lowercase right for this component.
     */
    private void lowercaseRight() {
        doWordRight((charIdx, i) -> {
            value.get(row)[i] = Character.toLowerCase(value.get(row)[i]);
        });
    }

    /**
     * Handles capitalize right for this component.
     */
    private void capitalizeRight() {
        doWordRight((charIdx, i) -> {
            if (charIdx == 0) {
                value.get(row)[i] = Character.toTitleCase(value.get(row)[i]);
            }
        });
    }

    /**
     * Handles do word right for this component.
     *
     * @param consumer consumer
     */
    private void doWordRight(WordConsumer consumer) {
        while (col >= value.get(row).length || UCharacter.isWhitespace(value.get(row)[col])) {
            if (row == value.size() - 1 && col == value.get(row).length) {
                break;
            }
            characterRight();
        }

        int charIdx = 0;
        while (col < value.get(row).length && !UCharacter.isWhitespace(value.get(row)[col])) {
            consumer.accept(charIdx, col);
            setCursor(col + 1);
            charIdx++;
        }
    }

    /**
     * Compatibility helper for WordConsumer to keep API parity.
     */
    @FunctionalInterface
    private interface WordConsumer {
        /**
         * Handles accept for this component.
         *
         * @param charIdx char idx
         * @param pos pos
         */
        void accept(int charIdx, int pos);
    }

    /**
     * Handles move to begin for this component.
     */
    private void moveToBegin() {
        row = 0;
        setCursor(0);
    }

    /**
     * Handles move to end for this component.
     */
    private void moveToEnd() {
        row = value.size() - 1;
        setCursor(value.get(row).length);
    }

    /**
     * Handles line info for this component.
     *
     * @return result
     */
    public LineInfo lineInfo() {
        List<char[]> grid = wrap(value.get(row), width);

        int counter = 0;
        for (int i = 0; i < grid.size(); i++) {
            char[] line = grid.get(i);
            if (counter + line.length == col && i + 1 < grid.size()) {
                return new LineInfo()
                        .charOffset(0)
                        .columnOffset(0)
                        .height(grid.size())
                        .rowOffset(i + 1)
                        .startColumn(col)
                        .width(grid.get(i + 1).length)
                        .charWidth(TextWidth.measureCellWidth(new String(line)));
            }

            if (counter + line.length >= col) {
                String lineStr = new String(line);
                int charOffset = TextWidth.measureCellWidth(lineStr.substring(0, max(0, col - counter)));
                return new LineInfo()
                        .charOffset(charOffset)
                        .columnOffset(col - counter)
                        .height(grid.size())
                        .rowOffset(i)
                        .startColumn(counter)
                        .width(line.length)
                        .charWidth(TextWidth.measureCellWidth(lineStr));
            }

            counter += line.length;
        }
        return new LineInfo();
    }

    /**
     * Handles cursor line number for this component.
     *
     * @return result
     */
    private int cursorLineNumber() {
        int line = 0;
        for (int i = 0; i < row; i++) {
            line += wrap(value.get(i), width).size();
        }
        line += lineInfo().rowOffset();
        return line;
    }

    /**
     * Handles wrap for this component.
     *
     * @param runes runes
     * @param maxWidth max width
     * @return result
     */
    private List<char[]> wrap(char[] runes, int maxWidth) {
        if (maxWidth <= 0) {
            return List.of(runes);
        }

        List<char[]> lines = new ArrayList<>();
        lines.add(new char[0]);

        List<Character> word = new ArrayList<>();
        int spaces = 0;

        for (char r : runes) {
            if (UCharacter.isWhitespace(r)) {
                spaces++;
            } else {
                word.add(r);
            }

            char[] wordArr = new char[word.size()];
            for (int i = 0; i < word.size(); i++) {
                wordArr[i] = word.get(i);
            }

            if (spaces > 0) {
                int currentLineWidth = TextWidth.measureCellWidth(new String(lines.get(lines.size() - 1)));
                int wordWidth = TextWidth.measureCellWidth(new String(wordArr));
                if (currentLineWidth + wordWidth + spaces > maxWidth) {
                    lines.add(wordArr);
                    char[] spaceArr = new char[spaces];
                    Arrays.fill(spaceArr, ' ');
                    lines.add(spaceArr);
                    word.clear();
                    spaces = 0;
                } else {
                    char[] lastLine = new char[lines.get(lines.size() - 1).length + wordArr.length + spaces];
                    System.arraycopy(lines.get(lines.size() - 1), 0, lastLine, 0, lines.get(lines.size() - 1).length);
                    System.arraycopy(wordArr, 0, lastLine, lines.get(lines.size() - 1).length, wordArr.length);
                    Arrays.fill(lastLine, lines.get(lines.size() - 1).length + wordArr.length, lastLine.length, ' ');
                    lines.set(lines.size() - 1, lastLine);
                    word.clear();
                    spaces = 0;
                }
            } else {
                char[] lastLine = lines.get(lines.size() - 1);
                int currentLineWidth = TextWidth.measureCellWidth(new String(lastLine));
                int wordWidth = TextWidth.measureCellWidth(new String(wordArr));

                if (currentLineWidth + wordWidth > maxWidth) {
                    if (lastLine.length > 0) {
                        lines.add(wordArr);
                    } else {
                        lines.set(lines.size() - 1, wordArr);
                    }
                    word.clear();
                } else {
                    char[] newLastLine = new char[lastLine.length + wordArr.length];
                    System.arraycopy(lastLine, 0, newLastLine, 0, lastLine.length);
                    System.arraycopy(wordArr, 0, newLastLine, lastLine.length, wordArr.length);
                    lines.set(lines.size() - 1, newLastLine);
                    word.clear();
                }
            }
        }

        if (!word.isEmpty() || spaces > 0) {
            char[] wordArr = new char[word.size()];
            for (int i = 0; i < word.size(); i++) {
                wordArr[i] = word.get(i);
            }

            int currentLineWidth = TextWidth.measureCellWidth(new String(lines.get(lines.size() - 1)));
            int wordWidth = TextWidth.measureCellWidth(new String(wordArr));
            if (currentLineWidth + wordWidth + spaces >= maxWidth) {
                lines.add(wordArr);
                char[] spaceArr = new char[spaces + 1];
                Arrays.fill(spaceArr, ' ');
                lines.add(spaceArr);
            } else {
                char[] lastLine = new char[lines.get(lines.size() - 1).length + wordArr.length + spaces + 1];
                System.arraycopy(lines.get(lines.size() - 1), 0, lastLine, 0, lines.get(lines.size() - 1).length);
                System.arraycopy(wordArr, 0, lastLine, lines.get(lines.size() - 1).length, wordArr.length);
                Arrays.fill(lastLine, lines.get(lines.size() - 1).length + wordArr.length, lastLine.length, ' ');
                lines.set(lines.size() - 1, lastLine);
            }
        }

        return lines;
    }

    /**
     * Handles value for this component.
     *
     * @return result
     */
    public String value() {
        if (value == null || value.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.size(); i++) {
            sb.append(value.get(i));
            if (i < value.size() - 1) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    /**
     * Updates the value.
     *
     * @param value value
     */
    public void setValue(String value) {
        reset();
        insertString(value);
    }

    /**
     * Handles insert string for this component.
     *
     * @param s s
     */
    public void insertString(String s) {
        insertRunesFromUserInput(s.toCharArray());
    }

    /**
     * Handles insert rune for this component.
     *
     * @param r r
     */
    public void insertRune(char r) {
        insertRunesFromUserInput(new char[]{r});
    }

    /**
     * Handles length for this component.
     *
     * @return result
     */
    public int length() {
        int l = 0;
        for (char[] rowChars : value) {
            l += TextWidth.measureCellWidth(new String(rowChars));
        }
        return l + value.size() - 1;
    }

    /**
     * Handles line count for this component.
     *
     * @return result
     */
    public int lineCount() {
        return value.size();
    }

    /**
     * Handles line for this component.
     *
     * @return result
     */
    public int line() {
        return row;
    }

    /**
     * Handles focus for this component.
     */
    public void focus() {
        focus = true;
        style = focusedStyle;
        cursor.focus();
    }

    /**
     * Handles blur for this component.
     */
    public void blur() {
        focus = false;
        style = blurredStyle;
        cursor.blur();
    }

    /**
     * Handles focused for this component.
     *
     * @return whether cused
     */
    public boolean focused() {
        return focus;
    }

    /**
     * Handles reset for this component.
     */
    public void reset() {
        value = new ArrayList<>();
        value.add(new char[0]);
        col = 0;
        row = 0;
        setCursor(0);
    }

    /**
     * Updates the width.
     *
     * @param w w
     */
    public void setWidth(int w) {
        this.width = w;
    }

    /**
     * Updates the height.
     *
     * @param h h
     */
    public void setHeight(int h) {
        if (maxHeight > 0) {
            this.height = clamp(h, MIN_HEIGHT, maxHeight);
        } else {
            this.height = max(h, MIN_HEIGHT);
        }
    }

    /**
     * Updates the prompt.
     *
     * @param prompt prompt
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
        this.promptWidth = TextWidth.measureCellWidth(prompt);
    }

    /**
     * Updates the placeholder.
     *
     * @param placeholder placeholder
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    /**
     * Updates the show line numbers.
     *
     * @param showLineNumbers show line numbers
     */
    public void setShowLineNumbers(boolean showLineNumbers) {
        this.showLineNumbers = showLineNumbers;
    }

    /**
     * Updates the char limit.
     *
     * @param charLimit char limit
     */
    public void setCharLimit(int charLimit) {
        this.charLimit = charLimit;
    }

    /**
     * Updates the max height.
     *
     * @param maxHeight max height
     */
    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * Updates the max width.
     *
     * @param maxWidth max width
     */
    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * Updates the end of buffer character.
     *
     * @param endOfBufferCharacter end of buffer character
     */
    public void setEndOfBufferCharacter(char endOfBufferCharacter) {
        this.endOfBufferCharacter = endOfBufferCharacter;
    }

    /**
     * Handles style for this component.
     *
     * @return result
     */
    public Style style() {
        return style;
    }

    /**
     * Handles focused style for this component.
     *
     * @return result
     */
    public Style focusedStyle() {
        return focusedStyle;
    }

    /**
     * Handles blurred style for this component.
     *
     * @return result
     */
    public Style blurredStyle() {
        return blurredStyle;
    }

    /**
     * Handles cursor for this component.
     *
     * @return result
     */
    public Cursor cursor() {
        return cursor;
    }

    /**
     * Handles width for this component.
     *
     * @return result
     */
    public int width() {
        return width;
    }

    /**
     * Handles height for this component.
     *
     * @return result
     */
    public int height() {
        return height;
    }

    /**
     * Handles clamp for this component.
     *
     * @param v v
     * @param low low
     * @param high high
     * @return result
     */
    private static int clamp(int v, int low, int high) {
        return Math.max(low, Math.min(high, v));
    }
}
