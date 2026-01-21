package com.williamcallahan.tui4j.compat.bubbletea.input;

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
public class MouseMsg extends MouseMessage {

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
        super(x, y, shift, alt, ctrl, action, button);
    }

    /**
     * Returns a string representation of the mouse message.
     *
     * @return string representation
     * @deprecated Use {@link MouseMessage#toString()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @Override
    public String toString() {
        return String.format("MouseMsg(width=%d, height=%d, shift=%b, alt=%b, ctrl=%b, action=%s, button=%s)",
                column(), row(), isShift(), isAlt(), isCtrl(), getAction(), getButton());
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
