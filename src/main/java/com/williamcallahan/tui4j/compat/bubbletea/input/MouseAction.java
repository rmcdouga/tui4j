package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Mouse action values.
 * Bubble Tea: mouse.go.
 * <p>
 * Bubble Tea: key_windows.go.
 */
public enum MouseAction {
    /** Mouse button pressed. */
    MouseActionPress("press"),
    /** Mouse button released. */
    MouseActionRelease("release"),
    /** Mouse moved. */
    MouseActionMotion("motion");

    private final String value;

    /**
     * Creates MouseAction to keep this component ready for use.
     *
     * @param value value
     */
    MouseAction(String value) {
        this.value = value;
    }

    /**
     * Returns the string value of the action.
     *
     * @return string value
     */
    public String value() {
        return value;
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return value;
    }
}
