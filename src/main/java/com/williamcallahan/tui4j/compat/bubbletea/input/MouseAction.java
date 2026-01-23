package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Mouse action values.
 * Bubble Tea: bubbletea/mouse.go
 */
public enum MouseAction {
    /** Mouse button press action. */
    MouseActionPress("press"),
    /** Mouse button release action. */
    MouseActionRelease("release"),
    /** Mouse motion action. */
    MouseActionMotion("motion");

    private final String value;

    MouseAction(String value) {
        this.value = value;
    }

    /**
     * Returns the wire value for this action.
     *
     * @return action value
     */
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
