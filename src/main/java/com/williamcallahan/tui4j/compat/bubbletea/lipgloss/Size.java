package com.williamcallahan.tui4j.compat.bubbletea.lipgloss;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.ColorProfile;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.Size}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: size.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Size {
    private final ColorProfile profile;

    /**
     * Creates Size to keep this component ready for use.
     */
    public Size() {
        this.profile = null;
    }

    /**
     * Creates a Size with the requested color profile.
     *
     * @param profile profile to attach
     */
    private Size(ColorProfile profile) {
        this.profile = profile;
    }

    /**
     * Handles width for this component.
     *
     * @param str str
     * @return result
     */
    public static int width(String str) {
        return com.williamcallahan.tui4j.compat.lipgloss.Size.width(str);
    }

    /**
     * Handles height for this component.
     *
     * @param str str
     * @return result
     */
    public static int height(String str) {
        return com.williamcallahan.tui4j.compat.lipgloss.Size.height(str);
    }

    /**
     * Handles with profile for this component.
     *
     * @param profile profile
     * @return result
     */
    public static Size withProfile(ColorProfile profile) {
        return new Size(profile);
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
