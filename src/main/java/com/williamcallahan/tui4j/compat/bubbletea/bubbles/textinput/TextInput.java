package com.williamcallahan.tui4j.compat.bubbletea.bubbles.textinput;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.cursor.Cursor;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/textinput/TextInput.java}.
 * <p>
 * Bubbles: textinput/textinput.go.
 *
 * @since 0.3.0
 */
public class TextInput implements Model {

    private com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput delegate;

    /**
     * Creates TextInput to keep this component ready for use.
     */
    public TextInput() {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput();
    }

    /**
     * @deprecated Use {@link #TextInput()} and setters instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public TextInput(String placeholder) {
        this();
        setPlaceholder(placeholder);
    }

    /**
     * @deprecated Use {@link #TextInput()} and setters instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public TextInput(String placeholder, int width) {
        this();
        setPlaceholder(placeholder);
        setWidth(width);
    }

    /**
     * @deprecated Use {@link #TextInput()} and setters instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public TextInput(String placeholder, int width, int charLimit) {
        this();
        setPlaceholder(placeholder);
        setWidth(width);
        setCharLimit(charLimit);
    }

    /**
     * Returns the canonical text input delegate.
     *
     * @return canonical text input
     */
    public com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput toCanonical() {
        return delegate;
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
     * Returns the prompt.
     *
     * @return prompt
     */
    public String prompt() {
        return delegate.prompt();
    }

    /**
     * Updates the prompt style.
     *
     * @param promptStyle prompt style
     */
    public void setPromptStyle(Style promptStyle) {
        delegate.setPromptStyle(promptStyle);
    }

    /**
     * Updates the text style.
     *
     * @param textStyle text style
     */
    public void setTextStyle(Style textStyle) {
        delegate.setTextStyle(textStyle);
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
     * Returns the value.
     *
     * @return value
     */
    public String value() {
        return delegate.value();
    }

    /**
     * Reports whether the value is empty.
     *
     * @return whether empty
     */
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    /**
     * Returns the cursor position.
     *
     * @return cursor position
     */
    public int position() {
        return delegate.position();
    }

    /**
     * Sets the cursor position.
     *
     * @param position position
     */
    public void setCursor(int position) {
        delegate.setCursor(position);
    }

    /**
     * Moves the cursor to the start.
     */
    public void cursorStart() {
        delegate.cursorStart();
    }

    /**
     * Moves the cursor to the end.
     */
    public void cursorEnd() {
        delegate.cursorEnd();
    }

    /**
     * Reports whether the input has focus.
     *
     * @return whether focused
     */
    public boolean isFocused() {
        return delegate.isFocused();
    }

    /**
     * Focuses the input.
     *
     * @return focus command
     */
    public Command focus() {
        return delegate.focus();
    }

    /**
     * Blurs the input.
     */
    public void blur() {
        delegate.blur();
    }

    /**
     * Resets the input.
     */
    public void reset() {
        delegate.reset();
    }

    /**
     * Sets the suggestions array.
     *
     * @param suggestions suggestions
     */
    public void setSuggestions(String[] suggestions) {
        delegate.setSuggestions(suggestions);
    }

    /**
     * Initializes the model.
     *
     * @return init command
     */
    @Override
    public Command init() {
        return delegate.init();
    }

    /**
     * Updates the model.
     *
     * @param msg message
     * @return update result
     */
    @Override
    public UpdateResult<TextInput> update(Message msg) {
        UpdateResult<com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput> result = delegate.update(msg);
        this.delegate = result.model();
        return UpdateResult.from(this, result.command());
    }

    /**
     * Returns a paste message.
     *
     * @return paste message
     */
    public Message paste() {
        return delegate.paste();
    }

    /**
     * Renders the input view.
     *
     * @return view
     */
    @Override
    public String view() {
        return delegate.view();
    }

    /**
     * Renders the placeholder view.
     *
     * @return placeholder view
     */
    public String placeholderView() {
        return delegate.placeholderView();
    }

    /**
     * Emits an initial blink message.
     *
     * @return blink message
     */
    public static Message blink() {
        return com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput.blink();
    }

    /**
     * Renders the completion view with an offset.
     *
     * @param offset offset
     * @return completion view
     */
    public String completionView(int offset) {
        return delegate.completionView(offset);
    }

    /**
     * Accepts the current suggestion.
     */
    public void acceptSuggestion() {
        delegate.acceptSuggestion();
    }

    /**
     * Moves to the next suggestion.
     */
    public void nextSuggestion() {
        delegate.nextSuggestion();
    }

    /**
     * Moves to the previous suggestion.
     */
    public void previousSuggestion() {
        delegate.previousSuggestion();
    }

    /**
     * Updates the suggestions list.
     */
    public void updateSuggestions() {
        delegate.updateSuggestions();
    }

    /**
     * Returns the available suggestions.
     *
     * @return suggestions
     */
    public String[] availableSuggestions() {
        return delegate.availableSuggestions();
    }

    /**
     * Returns the matched suggestions.
     *
     * @return matched suggestions
     */
    public String[] matchedSuggestions() {
        return delegate.matchedSuggestions();
    }

    /**
     * Returns the current suggestion index.
     *
     * @return suggestion index
     */
    public int currentSuggestionIndex() {
        return delegate.currentSuggestionIndex();
    }

    /**
     * Returns the current suggestion.
     *
     * @return suggestion
     */
    public String currentSuggestion() {
        return delegate.currentSuggestion();
    }

    /**
     * Sets whether suggestions are shown.
     *
     * @param showSuggestions whether to show suggestions
     */
    public void setShowSuggestions(boolean showSuggestions) {
        delegate.setShowSuggestions(showSuggestions);
    }

    /**
     * Updates the placeholder text.
     *
     * @param placeholder placeholder
     */
    public void setPlaceholder(String placeholder) {
        delegate.setPlaceholder(placeholder);
    }

    /**
     * Updates the width.
     *
     * @param width width
     */
    public void setWidth(int width) {
        delegate.setWidth(width);
    }

    /**
     * Updates the character limit.
     *
     * @param charLimit character limit
     */
    public void setCharLimit(int charLimit) {
        delegate.setCharLimit(charLimit);
    }

    /**
     * Updates the echo mode.
     *
     * @param echoMode echo mode
     */
    public void setEchoMode(EchoMode echoMode) {
        if (echoMode == null) {
            delegate.setEchoMode(null);
            return;
        }
        delegate.setEchoMode(com.williamcallahan.tui4j.compat.bubbles.textinput.EchoMode.valueOf(echoMode.name()));
    }

    /**
     * Updates the echo character.
     *
     * @param echoCharacter echo character
     */
    public void setEchoCharacter(char echoCharacter) {
        delegate.setEchoCharacter(echoCharacter);
    }

    /**
     * Returns the cursor as the legacy shim type.
     *
     * @return cursor
     */
    public Cursor cursor() {
        return new Cursor(delegate.cursor());
    }
}
