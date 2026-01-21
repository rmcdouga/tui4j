package com.williamcallahan.tui4j.compat.bubbletea.input;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Mouse input event data.
 * <p>
 * Bubble Tea: bubbletea/mouse.go
 *
 * @deprecated Use {@link MouseMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/mouse.go">bubbletea/mouse.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class MouseMsg implements Message {

    private final MouseMessage message;

    /**
     * Creates a mouse message.
     *
     * @param x column position
     * @param y row position
     * @param shift shift modifier pressed
     * @param alt alt modifier pressed
     * @param ctrl ctrl modifier pressed
     * @param action mouse action
     * @param button mouse button
     * @deprecated Use {@link MouseMessage#MouseMessage(int, int, boolean, boolean, boolean, MouseAction, MouseButton)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public MouseMsg(int x, int y, boolean shift, boolean alt, boolean ctrl,
                    MouseAction action, MouseButton button) {
        this.message = new MouseMessage(x, y, shift, alt, ctrl, action, button);
    }

    /**
     * Returns the column position.
     *
     * @return column
     * @deprecated Use {@link MouseMessage#column()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int column() {
        return message.column();
    }

    /**
     * Returns the row position.
     *
     * @return row
     * @deprecated Use {@link MouseMessage#row()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int row() {
        return message.row();
    }

    /**
     * Returns whether shift was pressed.
     *
     * @return true if shift pressed
     * @deprecated Use {@link MouseMessage#isShift()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean isShift() {
        return message.isShift();
    }

    /**
     * Returns whether alt was pressed.
     *
     * @return true if alt pressed
     * @deprecated Use {@link MouseMessage#isAlt()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean isAlt() {
        return message.isAlt();
    }

    /**
     * Returns whether ctrl was pressed.
     *
     * @return true if ctrl pressed
     * @deprecated Use {@link MouseMessage#isCtrl()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean isCtrl() {
        return message.isCtrl();
    }

    /**
     * Returns the mouse action.
     *
     * @return mouse action
     * @deprecated Use {@link MouseMessage#getAction()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public MouseAction getAction() {
        return message.getAction();
    }

    /**
     * Returns the mouse button.
     *
     * @return mouse button
     * @deprecated Use {@link MouseMessage#getButton()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public MouseButton getButton() {
        return message.getButton();
    }

    /**
     * Returns whether this is a wheel event.
     *
     * @return true if wheel event
     * @deprecated Use {@link MouseMessage#isWheel()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean isWheel() {
        return message.isWheel();
    }

    /**
     * Returns a description of the event.
     *
     * @return description
     * @deprecated Use {@link MouseMessage#describe()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String describe() {
        return message.describe();
    }

    /**
     * Parses an X10 mouse event.
     *
     * @param col column position (1-based)
     * @param row row position (1-based)
     * @param button button code
     * @return parsed mouse message
     * @deprecated Use {@link MouseMessage#parseX10MouseEvent(int, int, int)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static MouseMsg parseX10MouseEvent(int col, int row, int button) {
        MouseMessage msg = MouseMessage.parseX10MouseEvent(col, row, button);
        return new MouseMsg(
                msg.column(),
                msg.row(),
                msg.isShift(),
                msg.isAlt(),
                msg.isCtrl(),
                msg.getAction(),
                msg.getButton()
        );
    }

    /**
     * Parses an SGR mouse event.
     *
     * @param button button code
     * @param col column position (1-based)
     * @param row row position (1-based)
     * @param release whether this is a release event
     * @return parsed mouse message
     * @deprecated Use {@link MouseMessage#parseSGRMouseEvent(int, int, int, boolean)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static MouseMsg parseSGRMouseEvent(int button, int col, int row, boolean release) {
        MouseMessage msg = MouseMessage.parseSGRMouseEvent(button, col, row, release);
        return new MouseMsg(
                msg.column(),
                msg.row(),
                msg.isShift(),
                msg.isAlt(),
                msg.isCtrl(),
                msg.getAction(),
                msg.getButton()
        );
    }
}
