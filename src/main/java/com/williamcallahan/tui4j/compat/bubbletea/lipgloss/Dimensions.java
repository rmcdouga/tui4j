package com.williamcallahan.tui4j.compat.bubbletea.lipgloss;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.ColorProfile;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.Dimensions}.
 * This transitional shim preserves the legacy Bubble Tea profile type and will be removed
 * in a future release.
 * <p>
 * Lip Gloss: size.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Dimensions {
    private final ColorProfile profile;

    /**
     * Creates Dimensions to keep this component ready for use.
     *
     * @param profile profile
     */
    public Dimensions(ColorProfile profile) {
        this.profile = profile;
    }

    /**
     * Creates Dimensions to keep this component ready for use.
     */
    public Dimensions() {
        this(ColorProfile.ANSI256);
    }

    /**
     * Handles width for this component.
     *
     * @param text text
     * @return result
     */
    public int width(String text) {
        return com.williamcallahan.tui4j.compat.lipgloss.Size.width(text);
    }

    /**
     * Handles height for this component.
     *
     * @param text text
     * @return result
     */
    public int height(String text) {
        return com.williamcallahan.tui4j.compat.lipgloss.Size.height(text);
    }

    /**
     * Handles with profile for this component.
     *
     * @param profile profile
     * @return result
     */
    public Dimensions withProfile(ColorProfile profile) {
        return new Dimensions(profile);
    }

    /**
     * Handles profile for this component.
     *
     * @return result
     */
    public ColorProfile profile() {
        return profile;
    }
}
