package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

/**
 * ANSI 16/256 color lookup table for the Bubble Tea-compatible API surface.
 * <p>
 * Lipgloss: color.go
 *
 * @since 0.3.0
 */
public final class ANSIColors {

    /**
     * ANSI 16-color and 256-color hex palette.
     */
    public static final String[] ANSI_HEX = com.williamcallahan.tui4j.compat.lipgloss.color.ANSIColors.ANSI_HEX;

    /**
     * Prevents instantiation of the deprecated shim.
     */
    private ANSIColors() {
    }
}
