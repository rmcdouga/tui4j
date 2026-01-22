package com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner;

import java.time.Duration;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.spinner.SpinnerType}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: spinner/spinner.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
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
