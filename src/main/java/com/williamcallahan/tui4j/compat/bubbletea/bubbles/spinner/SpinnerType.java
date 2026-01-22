package com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner;

import java.time.Duration;

/**
 */
public enum SpinnerType {

    LINE, DOT, MINI_DOT, JUMP, PULSE, POINTS, GLOBE, MOON, MONKEY, METER, HAMBURGER, ELLIPSIS;

    /**
     * Handles to new for this component.
     *
     * @return result
     */
    public com.williamcallahan.tui4j.compat.bubbles.spinner.SpinnerType toNew() {
        return com.williamcallahan.tui4j.compat.bubbles.spinner.SpinnerType.valueOf(this.name());
    }

    /**
     * Handles from new for this component.
     *
     * @param type type
     * @return result
     */
    public static SpinnerType fromNew(com.williamcallahan.tui4j.compat.bubbles.spinner.SpinnerType type) {
        return SpinnerType.valueOf(type.name());
    }
    
}
