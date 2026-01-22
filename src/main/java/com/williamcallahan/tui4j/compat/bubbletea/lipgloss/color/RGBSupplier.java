package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

/**
 * Supplies an RGB value for Bubble Tea-compatible color implementations.
 * <p>
 * Lipgloss: color.go.
 *
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.color.RGBSupplier}.
 * This transitional shim preserves the legacy Bubble Tea return type and will be removed
 * in a future release.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public interface RGBSupplier {
    /**
     * Returns the RGB value for this color.
     *
     * @return RGB value
     */
    RGB rgb();
}
