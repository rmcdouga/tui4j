package com.williamcallahan.tui4j.compat.bubbletea.bubbles.cursor;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style;

import java.time.Duration;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/cursor/Cursor.java}.
 * <p>
 * Bubbles: cursor/cursor.go.
 *
 * @since 0.3.0
 */
public class Cursor implements Model {

    private com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor delegate;

    /**
     * Creates a cursor with default settings.
     */
    public Cursor() {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor();
    }

    /**
     * Creates a cursor shim seeded from a canonical cursor.
     *
     * @param delegate canonical cursor instance
     */
    public Cursor(com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor delegate) {
        this.delegate = delegate == null
            ? new com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor()
            : delegate;
    }

    /**
     * Returns the canonical cursor delegate.
     *
     * @return canonical cursor
     */
    public com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor toCanonical() {
        return delegate;
    }

    /**
     * Returns the initial blink command.
     *
     * @return initial command
     */
    @Override
    public Command init() {
        return delegate.init();
    }

    /**
     * Updates the cursor based on incoming messages.
     *
     * @param msg message to process
     * @return update result
     */
    @Override
    public UpdateResult<Cursor> update(Message msg) {
        UpdateResult<com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor> result = delegate.update(msg);
        this.delegate = result.model();
        return UpdateResult.from(this, result.command());
    }

    /**
     * Returns a command that toggles the cursor blink.
     *
     * @return blink command
     */
    public Command blinkCommand() {
        return delegate.blinkCommand();
    }

    /**
     * Emits an initial blink message.
     *
     * @return blink message
     */
    public static Message blink() {
        return com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor.blink();
    }

    /**
     * Focuses the cursor and optionally resumes blinking.
     *
     * @return blink command when needed
     */
    public Command focus() {
        return delegate.focus();
    }

    /**
     * Blurs the cursor and stops blinking.
     */
    public void blur() {
        delegate.blur();
    }

    /**
     * Renders the cursor view.
     *
     * @return cursor view
     */
    @Override
    public String view() {
        return delegate.view();
    }

    /**
     * Sets the cursor mode.
     *
     * @param mode cursor mode
     * @return blink command when needed
     */
    public Command setMode(CursorMode mode) {
        if (mode == null) {
            return delegate.setMode(null);
        }
        return delegate.setMode(mode.toNew());
    }

    /**
     * Returns the cursor mode.
     *
     * @return cursor mode
     */
    public CursorMode mode() {
        return CursorMode.fromNew(delegate.mode());
    }

    /**
     * Updates the cursor blink speed.
     *
     * @param blinkSpeed blink duration
     */
    public void setBlinkSpeed(Duration blinkSpeed) {
        delegate.setBlinkSpeed(blinkSpeed);
    }

    /**
     * Updates the cursor style.
     *
     * @param style style
     */
    public void setStyle(Style style) {
        delegate.setStyle(style);
    }

    /**
     * Updates the cursor text style.
     *
     * @param textStyle text style
     */
    public void setTextStyle(Style textStyle) {
        delegate.setTextStyle(textStyle);
    }

    /**
     * Resets the text style.
     */
    public void resetTextStyle() {
        delegate.resetTextStyle();
    }

    /**
     * Updates the character under the cursor.
     *
     * @param charUnderCursor character string
     */
    public void setChar(String charUnderCursor) {
        delegate.setChar(charUnderCursor);
    }

    /**
     * Forces the cursor blink state.
     *
     * @param blink blink state
     */
    public void setBlink(boolean blink) {
        delegate.setBlink(blink);
    }
}
