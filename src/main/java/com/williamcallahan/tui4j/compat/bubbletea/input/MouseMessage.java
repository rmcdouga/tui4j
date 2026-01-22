package com.williamcallahan.tui4j.compat.bubbletea.input;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Mouse input event data.
 * <p>
 * Bubble Tea: mouse.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/mouse.go">bubbletea/mouse.go</a>
 * <p>
 * Bubble Tea: key_windows.go.
 */
public class MouseMessage implements Message {

    private final int x;
    private final int y;
    private final boolean shift;
    private final boolean alt;
    private final boolean ctrl;
    private final MouseAction action;
    private final MouseButton button;

    private static final int X10_MOUSE_BYTE_OFFSET = 32;

    /**
     * Creates a new mouse message.
     *
     * @param x column position
     * @param y row position
     * @param shift shift modifier
     * @param alt alt modifier
     * @param ctrl ctrl modifier
     * @param action mouse action
     * @param button mouse button
     */
    public MouseMessage(int x, int y, boolean shift, boolean alt, boolean ctrl,
                        MouseAction action, MouseButton button) {
        this.x = x;
        this.y = y;
        this.shift = shift;
        this.alt = alt;
        this.ctrl = ctrl;
        this.action = action;
        this.button = button;
    }

    /**
     * Returns the column position (0-based).
     *
     * @return column
     */
    public int column() {
        return x;
    }

    /**
     * Returns the row position (0-based).
     *
     * @return row
     */
    public int row() {
        return y;
    }

    /**
     * Returns whether shift was pressed.
     *
     * @return true if shift pressed
     */
    public boolean isShift() {
        return shift;
    }

    /**
     * Returns whether alt was pressed.
     *
     * @return true if alt pressed
     */
    public boolean isAlt() {
        return alt;
    }

    /**
     * Returns whether ctrl was pressed.
     *
     * @return true if ctrl pressed
     */
    public boolean isCtrl() {
        return ctrl;
    }

    /**
     * Returns the mouse action.
     *
     * @return mouse action
     */
    public MouseAction getAction() {
        return action;
    }

    /**
     * Returns the mouse button.
     *
     * @return mouse button
     */
    public MouseButton getButton() {
        return button;
    }

    /**
     * Returns whether this is a wheel event.
     *
     * @return true if wheel event
     */
    public boolean isWheel() {
        return button == MouseButton.MouseButtonWheelUp ||
                button == MouseButton.MouseButtonWheelDown ||
                button == MouseButton.MouseButtonWheelLeft ||
                button == MouseButton.MouseButtonWheelRight;
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return String.format("MouseMessage(width=%d, height=%d, shift=%b, alt=%b, ctrl=%b, action=%s, button=%s)",
                x, y, shift, alt, ctrl, action, button);
    }

    /**
     * Returns a human-readable description of the event.
     *
     * @return description
     */
    public String describe() {
        StringBuilder s = new StringBuilder();

        if (ctrl) {
            s.append("ctrl+");
        }
        if (alt) {
            s.append("alt+");
        }
        if (shift) {
            s.append("shift+");
        }

        if (button == MouseButton.MouseButtonNone) {
            if (action == MouseAction.MouseActionMotion || action == MouseAction.MouseActionRelease) {
                s.append(action.value());
            } else {
                s.append("unknown");
            }
        } else if (isWheel()) {
            s.append(button.buttonName());
        } else {
            String btn = button.buttonName();
            if (!btn.isEmpty()) {
                s.append(btn);
            }
            String act = action.value();
            if (!act.isEmpty()) {
                s.append(" ").append(act);
            }
        }

        return s.toString();
    }

    /**
     * Parses an X10 mouse event.
     *
     * @param col column position
     * @param row row position
     * @param button button code
     * @return parsed mouse message
     */
    public static MouseMessage parseX10MouseEvent(int col, int row, int button) {
        MouseEvent event = parseMouseButton(button, false);
        return new MouseMessage(
                col - 1,
                row - 1,
                event.shift,
                event.alt,
                event.ctrl,
                event.action,
                event.button
        );
    }

    /**
     * Parses an SGR mouse event.
     *
     * @param button button code
     * @param col column position
     * @param row row position
     * @param release whether this is a release event
     * @return parsed mouse message
     */
    public static MouseMessage parseSGRMouseEvent(int button, int col, int row, boolean release) {
        MouseEvent event = parseMouseButton(button, true);
        if (release && event.action != MouseAction.MouseActionMotion && !isWheelButton(event.button)) {
            event.action = MouseAction.MouseActionRelease;
            event.button = MouseButton.MouseButtonNone;
        }
        return new MouseMessage(
                col - 1,
                row - 1,
                event.shift,
                event.alt,
                event.ctrl,
                event.action,
                event.button
        );
    }

    /**
     * Compatibility port of MouseEvent to preserve upstream behavior.
     * <p>
     * Bubble Tea: mouse.go.
     */
    private static class MouseEvent {
        boolean shift;
        boolean alt;
        boolean ctrl;
        MouseAction action = MouseAction.MouseActionPress;
        MouseButton button = MouseButton.MouseButtonNone;
    }

    /**
     * Handles parse mouse button for this component.
     *
     * @param b b
     * @param isSGR is sgr
     * @return result
     */
    private static MouseEvent parseMouseButton(int b, boolean isSGR) {
        MouseEvent m = new MouseEvent();
        int e = b & 0xFF;
        if (!isSGR) {
            e = (e - X10_MOUSE_BYTE_OFFSET) & 0xFF;
        }

        final int BIT_SHIFT = 0b0000_0100;
        final int BIT_ALT = 0b0000_1000;
        final int BIT_CTRL = 0b0001_0000;
        final int BIT_MOTION = 0b0010_0000;
        final int BIT_WHEEL = 0b0100_0000;
        final int BIT_ADD = 0b1000_0000;
        final int BITS_MASK = 0b0000_0011;

        int buttonOffset = e & BITS_MASK;

        if ((e & BIT_ADD) != 0) {
            m.button = MouseButton.values()[MouseButton.MouseButtonBackward.ordinal() + buttonOffset];
        } else if ((e & BIT_WHEEL) != 0) {
            m.button = MouseButton.values()[MouseButton.MouseButtonWheelUp.ordinal() + buttonOffset];
        } else {
            if (buttonOffset == 0b11) {
                m.action = MouseAction.MouseActionRelease;
                m.button = MouseButton.MouseButtonNone;
            } else {
                m.button = MouseButton.values()[MouseButton.MouseButtonLeft.ordinal() + buttonOffset];
                m.action = MouseAction.MouseActionPress;
            }
        }

        if ((e & BIT_MOTION) != 0 && !isWheelButton(m.button)) {
            m.action = MouseAction.MouseActionMotion;
        } else if (m.action == null) {
            m.action = MouseAction.MouseActionPress;
        }

        m.alt = (e & BIT_ALT) != 0;
        m.ctrl = (e & BIT_CTRL) != 0;
        m.shift = (e & BIT_SHIFT) != 0;

        return m;
    }

    /**
     * Reports whether wheel button.
     *
     * @param button button
     * @return whether wheel button
     */
    private static boolean isWheelButton(MouseButton button) {
        return button == MouseButton.MouseButtonWheelUp ||
                button == MouseButton.MouseButtonWheelDown ||
                button == MouseButton.MouseButtonWheelLeft ||
                button == MouseButton.MouseButtonWheelRight;
    }
}
