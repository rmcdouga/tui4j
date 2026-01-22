package com.williamcallahan.tui4j.compat.lipgloss.color;

/**
 * HSL (Hue, Saturation, Lightness) color representation.
 * <p>
 * Port of charmbracelet/lipgloss color.go HSL utilities.
 *
 * @param h hue in degrees (0-360)
 * @param s saturation (0-1)
 * @param l lightness (0-1)
 * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/color.go">lipgloss/color.go</a>
 * <p>
 * Lipgloss: color.go.
 */
public record HSL(float h, float s, float l) {

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
        double dH = (h - other.h) / 180.0;
        double dS = s - other.s;
        double dL = l - other.l;
        return (float)Math.sqrt(dH * dH + dS * dS + dL * dL);
    }
}
