package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

/**
 * HSL (Hue, Saturation, Lightness) color representation.
 * <p>
 * Lipgloss: color.go
 *
 * @param h hue in degrees (0-360)
 * @param s saturation (0-1)
 * @param l lightness (0-1)
 * @since 0.3.0
 * @see com.williamcallahan.tui4j.compat.lipgloss.color.HSL
 */
public record HSL(float h, float s, float l) {

    /**
     * Converts to canonical HSL.
     *
     * @return canonical HSL
     */
    public com.williamcallahan.tui4j.compat.lipgloss.color.HSL toCanonical() {
        return new com.williamcallahan.tui4j.compat.lipgloss.color.HSL(h, s, l);
    }

    /**
     * Creates from canonical HSL.
     *
     * @param canonical the canonical HSL
     * @return deprecated HSL shim
     */
    public static HSL fromCanonical(com.williamcallahan.tui4j.compat.lipgloss.color.HSL canonical) {
        return new HSL(canonical.h(), canonical.s(), canonical.l());
    }

    /**
     * Returns true if this color is considered dark.
     *
     * @return true if lightness is below 0.5
     */
    public boolean isDark() {
        return l < 0.5;
    }

    /**
     * Calculates the distance to another HSL color.
     *
     * @param other the other HSL color
     * @return the Euclidean distance
     */
    public float distance(HSL other) {
        return toCanonical().distance(other.toCanonical());
    }
}
