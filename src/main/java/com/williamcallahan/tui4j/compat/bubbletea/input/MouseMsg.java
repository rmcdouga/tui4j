package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link MouseMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: mouse.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class MouseMsg extends MouseMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link MouseMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public MouseMsg(
        int x,
        int y,
        boolean shift,
        boolean alt,
        boolean ctrl,
        MouseAction action,
        MouseButton button
    ) {
        super(x, y, shift, alt, ctrl, action, button);
    }

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link MouseMessage#parseX10MouseEvent} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static MouseMsg parseX10MouseEvent(int col, int row, int button) {
        return fromNew(MouseMessage.parseX10MouseEvent(col, row, button));
    }

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link MouseMessage#parseSGRMouseEvent} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static MouseMsg parseSGRMouseEvent(
        int button,
        int col,
        int row,
        boolean release
    ) {
        return fromNew(MouseMessage.parseSGRMouseEvent(
            button,
            col,
            row,
            release
        ));
    }

    /**
     * Handles from new for this component.
     *
     * @param msg msg
     * @return result
     */
    private static MouseMsg fromNew(MouseMessage msg) {
        if (msg == null) {
            return null;
        }
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
