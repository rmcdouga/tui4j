package com.williamcallahan.tui4j.compat.bubbletea.bubbles.textarea;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.cursor.Cursor;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/textarea/Textarea.java}.
 * <p>
 * Bubbles: textarea/textarea.go.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Textarea implements Model {

    private com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea delegate;

    /**
     * Creates Textarea to keep this component ready for use.
     */
    public Textarea() {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea();
    }

    /**
     * @deprecated Use {@link #Textarea()} and setters instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Textarea(String placeholder) {
        this();
        setPlaceholder(placeholder);
    }

    /**
     * @deprecated Use {@link #Textarea()} and setters instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Textarea(String placeholder, int width, int height) {
        this();
        setPlaceholder(placeholder);
        setWidth(width);
        setHeight(height);
    }

    /**
     * @deprecated Use {@link #Textarea()} and setters instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Textarea(String placeholder, int width, int height, int charLimit) {
        this();
        setPlaceholder(placeholder);
        setWidth(width);
        setHeight(height);
        setCharLimit(charLimit);
    }

    /**
     * Returns the canonical textarea delegate.
     *
     * @return canonical textarea
     */
    public com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea toCanonical() {
        return delegate;
    }

    /**
     * Supplies the initial command for the model.
     *
     * @return initial command
     */
    @Override
    public Command init() {
        return delegate.init();
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg message to process
     * @return next model state and command
     */
    @Override
    public UpdateResult<Textarea> update(Message msg) {
        UpdateResult<com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea> result = delegate.update(msg);
        this.delegate = result.model();
        return UpdateResult.from(this, result.command());
    }

    /**
     * Renders the textarea view.
     *
     * @return view
     */
    @Override
    public String view() {
        return delegate.view();
    }

    /**
     * Handles style for this component.
     *
     * @return result
     */
    public Style style() {
        return Style.fromCanonical(delegate.style());
    }

    /**
     * Handles focused style for this component.
     *
     * @return result
     */
    public Style focusedStyle() {
        return Style.fromCanonical(delegate.focusedStyle());
    }

    /**
     * Handles blurred style for this component.
     *
     * @return result
     */
    public Style blurredStyle() {
        return Style.fromCanonical(delegate.blurredStyle());
    }

    /**
     * Handles cursor for this component.
     *
     * @return result
     */
    public Cursor cursor() {
        return new Cursor(delegate.cursor());
    }

    /**
     * Handles line info for this component.
     *
     * @return result
     */
    public LineInfo lineInfo() {
        return LineInfo.fromCanonical(delegate.lineInfo());
    }

    /**
     * Returns the current value.
     *
     * @return value
     */
    public String value() {
        return delegate.value();
    }

    /**
     * Updates the value.
     *
     * @param value value
     */
    public void setValue(String value) {
        delegate.setValue(value);
    }

    /**
     * Inserts a string at the current cursor.
     *
     * @param s string to insert
     */
    public void insertString(String s) {
        delegate.insertString(s);
    }

    /**
     * Inserts a rune at the current cursor.
     *
     * @param r rune to insert
     */
    public void insertRune(char r) {
        delegate.insertRune(r);
    }

    /**
     * Returns the total length.
     *
     * @return length
     */
    public int length() {
        return delegate.length();
    }

    /**
     * Returns the line count.
     *
     * @return line count
     */
    public int lineCount() {
        return delegate.lineCount();
    }

    /**
     * Returns the current line index.
     *
     * @return line index
     */
    public int line() {
        return delegate.line();
    }

    /**
     * Focuses the textarea.
     */
    public void focus() {
        delegate.focus();
    }

    /**
     * Blurs the textarea.
     */
    public void blur() {
        delegate.blur();
    }

    /**
     * Reports whether the textarea is focused.
     *
     * @return whether focused
     */
    public boolean focused() {
        return delegate.focused();
    }

    /**
     * Resets the textarea.
     */
    public void reset() {
        delegate.reset();
    }

    /**
     * Updates the width.
     *
     * @param w width
     */
    public void setWidth(int w) {
        delegate.setWidth(w);
    }

    /**
     * Updates the height.
     *
     * @param h height
     */
    public void setHeight(int h) {
        delegate.setHeight(h);
    }

    /**
     * Updates the prompt.
     *
     * @param prompt prompt
     */
    public void setPrompt(String prompt) {
        delegate.setPrompt(prompt);
    }

    /**
     * Updates the placeholder.
     *
     * @param placeholder placeholder
     */
    public void setPlaceholder(String placeholder) {
        delegate.setPlaceholder(placeholder);
    }

    /**
     * Toggles line number display.
     *
     * @param showLineNumbers show line numbers
     */
    public void setShowLineNumbers(boolean showLineNumbers) {
        delegate.setShowLineNumbers(showLineNumbers);
    }

    /**
     * Updates the character limit.
     *
     * @param charLimit char limit
     */
    public void setCharLimit(int charLimit) {
        delegate.setCharLimit(charLimit);
    }

    /**
     * Updates the max height.
     *
     * @param maxHeight max height
     */
    public void setMaxHeight(int maxHeight) {
        delegate.setMaxHeight(maxHeight);
    }

    /**
     * Updates the max width.
     *
     * @param maxWidth max width
     */
    public void setMaxWidth(int maxWidth) {
        delegate.setMaxWidth(maxWidth);
    }

    /**
     * Updates the end-of-buffer character.
     *
     * @param endOfBufferCharacter end of buffer character
     */
    public void setEndOfBufferCharacter(char endOfBufferCharacter) {
        delegate.setEndOfBufferCharacter(endOfBufferCharacter);
    }

    /**
     * Returns the current width.
     *
     * @return width
     */
    public int width() {
        return delegate.width();
    }

    /**
     * Returns the current height.
     *
     * @return height
     */
    public int height() {
        return delegate.height();
    }

    /**
     * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea.Style}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static class Style extends com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea.Style {
        private final com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea.Style delegate;

        /**
         * Creates Style to keep this component ready for use.
         */
        public Style() {
            super();
            this.delegate = this;
            setDefaults();
        }

        /**
         * Wraps the canonical style instance.
         *
         * @param delegate canonical style
         */
        Style(com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea.Style delegate) {
            super();
            this.delegate = delegate;
            setDefaults();
        }

        /**
         * Converts a canonical style to the legacy shim.
         *
         * @param canonical canonical style
         * @return legacy style shim
         */
        public static Style fromCanonical(com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea.Style canonical) {
            if (canonical instanceof Style legacy) {
                return legacy;
            }
            return new Style(canonical);
        }

        /**
         * Initializes legacy default styles and syncs them to the delegate.
         */
        private void setDefaults() {
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style baseStyle =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style.newStyle();
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style cursorLineStyle =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style.newStyle();
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style cursorLineNumberStyle =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style.newStyle();
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style endOfBufferStyle =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style.newStyle();
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style lineNumberStyle =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style.newStyle();
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style placeholderStyle =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style.newStyle();
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style promptStyle =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style.newStyle();
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style textStyle =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style.newStyle();

            if (delegate == this) {
                super.base(baseStyle);
                super.cursorLine(cursorLineStyle);
                super.cursorLineNumber(cursorLineNumberStyle);
                super.endOfBuffer(endOfBufferStyle);
                super.lineNumber(lineNumberStyle);
                super.placeholder(placeholderStyle);
                super.prompt(promptStyle);
                super.text(textStyle);
                return;
            }
            delegate.base(baseStyle);
            delegate.cursorLine(cursorLineStyle);
            delegate.cursorLineNumber(cursorLineNumberStyle);
            delegate.endOfBuffer(endOfBufferStyle);
            delegate.lineNumber(lineNumberStyle);
            delegate.placeholder(placeholderStyle);
            delegate.prompt(promptStyle);
            delegate.text(textStyle);
        }

        /**
         * Sets the base style using the legacy lipgloss wrapper.
         *
         * @param base base style
         * @return this style
         */
        public Style base(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style base) {
            if (delegate == this) {
                super.base(base);
                return this;
            }
            delegate.base(base);
            return this;
        }

        /**
         * Sets the base style using the canonical lipgloss type.
         *
         * @param base base style
         * @return this style
         */
        @Override
        public Style base(com.williamcallahan.tui4j.compat.lipgloss.Style base) {
            if (delegate == this) {
                super.base(base);
                return this;
            }
            delegate.base(base);
            return this;
        }

        /**
         * Sets the cursor line style using the legacy lipgloss wrapper.
         *
         * @param cursorLine cursor line style
         * @return this style
         */
        public Style cursorLine(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style cursorLine) {
            if (delegate == this) {
                super.cursorLine(cursorLine);
                return this;
            }
            delegate.cursorLine(cursorLine);
            return this;
        }

        /**
         * Sets the cursor line style using the canonical lipgloss type.
         *
         * @param cursorLine cursor line style
         * @return this style
         */
        @Override
        public Style cursorLine(com.williamcallahan.tui4j.compat.lipgloss.Style cursorLine) {
            if (delegate == this) {
                super.cursorLine(cursorLine);
                return this;
            }
            delegate.cursorLine(cursorLine);
            return this;
        }

        /**
         * Sets the cursor line number style using the legacy lipgloss wrapper.
         *
         * @param cursorLineNumber cursor line number style
         * @return this style
         */
        public Style cursorLineNumber(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style cursorLineNumber) {
            if (delegate == this) {
                super.cursorLineNumber(cursorLineNumber);
                return this;
            }
            delegate.cursorLineNumber(cursorLineNumber);
            return this;
        }

        /**
         * Sets the cursor line number style using the canonical lipgloss type.
         *
         * @param cursorLineNumber cursor line number style
         * @return this style
         */
        @Override
        public Style cursorLineNumber(com.williamcallahan.tui4j.compat.lipgloss.Style cursorLineNumber) {
            if (delegate == this) {
                super.cursorLineNumber(cursorLineNumber);
                return this;
            }
            delegate.cursorLineNumber(cursorLineNumber);
            return this;
        }

        /**
         * Sets the end-of-buffer style using the legacy lipgloss wrapper.
         *
         * @param endOfBuffer end-of-buffer style
         * @return this style
         */
        public Style endOfBuffer(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style endOfBuffer) {
            if (delegate == this) {
                super.endOfBuffer(endOfBuffer);
                return this;
            }
            delegate.endOfBuffer(endOfBuffer);
            return this;
        }

        /**
         * Sets the end-of-buffer style using the canonical lipgloss type.
         *
         * @param endOfBuffer end-of-buffer style
         * @return this style
         */
        @Override
        public Style endOfBuffer(com.williamcallahan.tui4j.compat.lipgloss.Style endOfBuffer) {
            if (delegate == this) {
                super.endOfBuffer(endOfBuffer);
                return this;
            }
            delegate.endOfBuffer(endOfBuffer);
            return this;
        }

        /**
         * Sets the line number style using the legacy lipgloss wrapper.
         *
         * @param lineNumber line number style
         * @return this style
         */
        public Style lineNumber(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style lineNumber) {
            if (delegate == this) {
                super.lineNumber(lineNumber);
                return this;
            }
            delegate.lineNumber(lineNumber);
            return this;
        }

        /**
         * Sets the line number style using the canonical lipgloss type.
         *
         * @param lineNumber line number style
         * @return this style
         */
        @Override
        public Style lineNumber(com.williamcallahan.tui4j.compat.lipgloss.Style lineNumber) {
            if (delegate == this) {
                super.lineNumber(lineNumber);
                return this;
            }
            delegate.lineNumber(lineNumber);
            return this;
        }

        /**
         * Sets the placeholder style using the legacy lipgloss wrapper.
         *
         * @param placeholder placeholder style
         * @return this style
         */
        public Style placeholder(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style placeholder) {
            if (delegate == this) {
                super.placeholder(placeholder);
                return this;
            }
            delegate.placeholder(placeholder);
            return this;
        }

        /**
         * Sets the placeholder style using the canonical lipgloss type.
         *
         * @param placeholder placeholder style
         * @return this style
         */
        @Override
        public Style placeholder(com.williamcallahan.tui4j.compat.lipgloss.Style placeholder) {
            if (delegate == this) {
                super.placeholder(placeholder);
                return this;
            }
            delegate.placeholder(placeholder);
            return this;
        }

        /**
         * Sets the prompt style using the legacy lipgloss wrapper.
         *
         * @param prompt prompt style
         * @return this style
         */
        public Style prompt(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style prompt) {
            if (delegate == this) {
                super.prompt(prompt);
                return this;
            }
            delegate.prompt(prompt);
            return this;
        }

        /**
         * Sets the prompt style using the canonical lipgloss type.
         *
         * @param prompt prompt style
         * @return this style
         */
        @Override
        public Style prompt(com.williamcallahan.tui4j.compat.lipgloss.Style prompt) {
            if (delegate == this) {
                super.prompt(prompt);
                return this;
            }
            delegate.prompt(prompt);
            return this;
        }

        /**
         * Sets the text style using the legacy lipgloss wrapper.
         *
         * @param text text style
         * @return this style
         */
        public Style text(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style text) {
            if (delegate == this) {
                super.text(text);
                return this;
            }
            delegate.text(text);
            return this;
        }

        /**
         * Sets the text style using the canonical lipgloss type.
         *
         * @param text text style
         * @return this style
         */
        @Override
        public Style text(com.williamcallahan.tui4j.compat.lipgloss.Style text) {
            if (delegate == this) {
                super.text(text);
                return this;
            }
            delegate.text(text);
            return this;
        }

        /**
         * Returns the base style using the legacy lipgloss wrapper.
         *
         * @return base style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style base() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.base();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.base();
        }

        /**
         * Returns the cursor line style using the legacy lipgloss wrapper.
         *
         * @return cursor line style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style cursorLine() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.cursorLine();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.cursorLine();
        }

        /**
         * Returns the cursor line number style using the legacy lipgloss wrapper.
         *
         * @return cursor line number style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style cursorLineNumber() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.cursorLineNumber();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.cursorLineNumber();
        }

        /**
         * Returns the end-of-buffer style using the legacy lipgloss wrapper.
         *
         * @return end-of-buffer style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style endOfBuffer() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.endOfBuffer();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.endOfBuffer();
        }

        /**
         * Returns the line number style using the legacy lipgloss wrapper.
         *
         * @return line number style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style lineNumber() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.lineNumber();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.lineNumber();
        }

        /**
         * Returns the placeholder style using the legacy lipgloss wrapper.
         *
         * @return placeholder style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style placeholder() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.placeholder();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.placeholder();
        }

        /**
         * Returns the prompt style using the legacy lipgloss wrapper.
         *
         * @return prompt style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style prompt() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.prompt();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.prompt();
        }

        /**
         * Returns the text style using the legacy lipgloss wrapper.
         *
         * @return text style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style text() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.text();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.text();
        }

        /**
         * Returns the computed cursor line style using the legacy lipgloss wrapper.
         *
         * @return computed cursor line style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style computedCursorLine() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.computedCursorLine();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.computedCursorLine();
        }

        /**
         * Returns the computed cursor line number style using the legacy lipgloss wrapper.
         *
         * @return computed cursor line number style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style computedCursorLineNumber() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.computedCursorLineNumber();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.computedCursorLineNumber();
        }

        /**
         * Returns the computed end-of-buffer style using the legacy lipgloss wrapper.
         *
         * @return computed end-of-buffer style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style computedEndOfBuffer() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.computedEndOfBuffer();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.computedEndOfBuffer();
        }

        /**
         * Returns the computed line number style using the legacy lipgloss wrapper.
         *
         * @return computed line number style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style computedLineNumber() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.computedLineNumber();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.computedLineNumber();
        }

        /**
         * Returns the computed placeholder style using the legacy lipgloss wrapper.
         *
         * @return computed placeholder style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style computedPlaceholder() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.computedPlaceholder();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.computedPlaceholder();
        }

        /**
         * Returns the computed prompt style using the legacy lipgloss wrapper.
         *
         * @return computed prompt style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style computedPrompt() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.computedPrompt();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.computedPrompt();
        }

        /**
         * Returns the computed text style using the legacy lipgloss wrapper.
         *
         * @return computed text style
         */
        public com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style computedText() {
            if (delegate == this) {
                return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) super.computedText();
            }
            return (com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style) delegate.computedText();
        }
    }

    /**
     * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea.LineInfo}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static class LineInfo extends com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea.LineInfo {

        /**
         * Creates LineInfo to keep this component ready for use.
         */
        public LineInfo() {
            super();
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
            super(width, charWidth, height, startColumn, columnOffset, rowOffset, charOffset);
        }

        /**
         * Creates a legacy line info from the canonical type.
         *
         * @param canonical canonical line info
         * @return legacy line info
         */
        public static LineInfo fromCanonical(com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea.LineInfo canonical) {
            if (canonical instanceof LineInfo legacy) {
                return legacy;
            }
            return new LineInfo(canonical.width(), canonical.charWidth(), canonical.height(),
                    canonical.startColumn(), canonical.columnOffset(), canonical.rowOffset(), canonical.charOffset());
        }

        /**
         * Updates the line width in characters.
         *
         * @param width line width
         * @return this line info
         */
        @Override
        public LineInfo width(int width) {
            super.width(width);
            return this;
        }

        /**
         * Updates the character width for the current line.
         *
         * @param charWidth character width
         * @return this line info
         */
        @Override
        public LineInfo charWidth(int charWidth) {
            super.charWidth(charWidth);
            return this;
        }

        /**
         * Updates the line height in rows.
         *
         * @param height line height
         * @return this line info
         */
        @Override
        public LineInfo height(int height) {
            super.height(height);
            return this;
        }

        /**
         * Updates the starting column for the line.
         *
         * @param startColumn starting column
         * @return this line info
         */
        @Override
        public LineInfo startColumn(int startColumn) {
            super.startColumn(startColumn);
            return this;
        }

        /**
         * Updates the column offset for the line.
         *
         * @param columnOffset column offset
         * @return this line info
         */
        @Override
        public LineInfo columnOffset(int columnOffset) {
            super.columnOffset(columnOffset);
            return this;
        }

        /**
         * Updates the row offset for the line.
         *
         * @param rowOffset row offset
         * @return this line info
         */
        @Override
        public LineInfo rowOffset(int rowOffset) {
            super.rowOffset(rowOffset);
            return this;
        }

        /**
         * Updates the character offset for the line.
         *
         * @param charOffset character offset
         * @return this line info
         */
        @Override
        public LineInfo charOffset(int charOffset) {
            super.charOffset(charOffset);
            return this;
        }
    }
}
