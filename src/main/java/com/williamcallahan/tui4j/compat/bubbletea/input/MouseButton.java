package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Mouse button values.
 * Bubble Tea: bubbletea/mouse.go
 */
public enum MouseButton {
    /** No button pressed. */
    MouseButtonNone("none"),

    /** Left mouse button. */
    MouseButtonLeft("left"),

    /** Middle mouse button (scroll wheel press). */
    MouseButtonMiddle("middle"),

    /** Right mouse button. */
    MouseButtonRight("right"),

    /** Scroll wheel up. */
    MouseButtonWheelUp("wheel up"),

    /** Scroll wheel down. */
    MouseButtonWheelDown("wheel down"),

    /** Scroll wheel left. */
    MouseButtonWheelLeft("wheel left"),

    /** Scroll wheel right. */
    MouseButtonWheelRight("wheel right"),

    /** Backward mouse button. */
    MouseButtonBackward("backward"),

    /** Forward mouse button. */
    MouseButtonForward("forward"),

    /** Additional mouse button 10. */
    MouseButton10("button 10"),

    /** Additional mouse button 11. */
    MouseButton11("button 11");

    private final String buttonName;

    MouseButton(String buttonName) {
        this.buttonName = buttonName;
    }

    /**
     * Returns the human-readable button name.
     *
     * @return button name
     */
    public String buttonName() {
        return buttonName;
    }

    @Override
    public String toString() {
        return buttonName;
    }
}
