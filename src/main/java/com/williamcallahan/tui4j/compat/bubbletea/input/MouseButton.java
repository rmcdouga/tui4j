package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Mouse button values.
 * Bubble Tea: mouse.go.
 * <p>
 * Bubble Tea: key_windows.go.
 */
public enum MouseButton {
    /** No button. */
    MouseButtonNone("none"),

    /** Left button. */
    MouseButtonLeft("left"),

    /** Middle button (pressing the scroll wheel). */
    MouseButtonMiddle("middle"),

    /** Right button. */
    MouseButtonRight("right"),

    /** Turn scroll wheel up. */
    MouseButtonWheelUp("wheel up"),

    /** Turn scroll wheel down. */
    MouseButtonWheelDown("wheel down"),

    /** Push scroll wheel left. */
    MouseButtonWheelLeft("wheel left"),

    /** Push scroll wheel right. */
    MouseButtonWheelRight("wheel right"),

    /** 4th button (aka browser backward button). */
    MouseButtonBackward("backward"),

    /** 5th button (aka browser forward button). */
    MouseButtonForward("forward"),

    /** Button 10. */
    MouseButton10("button 10"),

    /** Button 11. */
    MouseButton11("button 11");

    private final String buttonName;

    /**
     * Creates MouseButton to keep this component ready for use.
     *
     * @param buttonName button name
     */
    MouseButton(String buttonName) {
        this.buttonName = buttonName;
    }

    /**
     * Returns the button name.
     *
     * @return button name
     */
    public String buttonName() {
        return buttonName;
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return buttonName;
    }
}
