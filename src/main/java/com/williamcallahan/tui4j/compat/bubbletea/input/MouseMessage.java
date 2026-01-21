package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Mouse input event data.
 * Bubble Tea: bubbletea/mouse.go
 */
public class MouseMessage extends MouseMsg {

    public MouseMessage(int x, int y, boolean shift, boolean alt, boolean ctrl,
                        MouseAction action, MouseButton button) {
        super(x, y, shift, alt, ctrl, action, button);
    }

    @Override
    public String toString() {
        return String.format("MouseMessage(width=%d, height=%d, shift=%b, alt=%b, ctrl=%b, action=%s, button=%s)",
                column(), row(), isShift(), isAlt(), isCtrl(), getAction(), getButton());
    }

    public static MouseMessage parseX10MouseEvent(int col, int row, int button) {
        MouseMsg msg = MouseMsg.parseX10MouseEvent(col, row, button);
        return new MouseMessage(
                msg.column(),
                msg.row(),
                msg.isShift(),
                msg.isAlt(),
                msg.isCtrl(),
                msg.getAction(),
                msg.getButton()
        );
    }

    public static MouseMessage parseSGRMouseEvent(int button, int col, int row, boolean release) {
        MouseMsg msg = MouseMsg.parseSGRMouseEvent(button, col, row, release);
        return new MouseMessage(
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
