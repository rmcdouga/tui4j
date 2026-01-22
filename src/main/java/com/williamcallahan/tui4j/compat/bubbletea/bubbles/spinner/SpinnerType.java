package com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner;

import java.time.Duration;

/**
 * Spinner shape presets for Bubble Tea-compatible spinners.
 * <p>
 * Bubbles: spinner/spinner.go.
 */
public enum SpinnerType {

    /**
     * Simple line spinner.
     */
    LINE,
    /**
     * Braille dot spinner.
     */
    DOT,
    /**
     * Compact braille dot spinner.
     */
    MINI_DOT,
    /**
     * Jumping dot spinner.
     */
    JUMP,
    /**
     * Pulsing block spinner.
     */
    PULSE,
    /**
     * Three-dot points spinner.
     */
    POINTS,
    /**
     * Rotating globe spinner.
     */
    GLOBE,
    /**
     * Lunar phase spinner.
     */
    MOON,
    /**
     * See-no/ hear-no/ speak-no monkey spinner.
     */
    MONKEY,
    /**
     * Meter bar spinner.
     */
    METER,
    /**
     * Hamburger menu spinner.
     */
    HAMBURGER,
    /**
     * Ellipsis dot spinner.
     */
    ELLIPSIS;

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
