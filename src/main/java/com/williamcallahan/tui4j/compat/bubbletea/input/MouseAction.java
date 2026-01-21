package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Mouse action values.
 * Bubble Tea: bubbletea/mouse.go
 */
public enum MouseAction {
    /** Mouse button pressed. */
    MouseActionPress("press"),
    /** Mouse button released. */
    MouseActionRelease("release"),
    /** Mouse moved. */
    MouseActionMotion("motion");

    private final String value;

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

    @Override
    public String toString() {
        return value;
    }
}
