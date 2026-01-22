package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

/**
 * Supplies an RGB value for Bubble Tea-compatible color implementations.
 * <p>
 * Lipgloss: color.go.
 *
 */
public interface RGBSupplier {
    /**
     * Returns the RGB value for this color.
     *
     * @return RGB value
     */
    RGB rgb();
}
