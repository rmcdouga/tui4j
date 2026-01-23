package com.williamcallahan.tui4j.compat.lipgloss.color;

/**
 * Port of Lip Gloss HSL color.
 * Upstream: github.com/charmbracelet/lipgloss/color.go
 *
 * @param h hue in degrees
 * @param s saturation (0-1)
 * @param l lightness (0-1)
 */
public record HSL(float h, float s, float l) {

    /**
     * Returns true when the color is considered dark.
     *
     * @return true when lightness is below 0.5
     */
    public boolean isDark() {
        return l < 0.5;
    }

    /**
     * Returns the distance between this color and another HSL value.
     *
     * @param hsluv2 other HSL color
     * @return distance metric
     */
    public float distance(HSL hsluv2) {
        double dH = (h - hsluv2.h) / 100.0;
        double dS = s - hsluv2.s;
        double dL = l - hsluv2.l;
        return (float)Math.sqrt(dH * dH + dS * dS + dL * dL);
    }
}
