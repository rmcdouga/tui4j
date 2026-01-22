package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

/**
 * ANSI 16/256 color lookup table for the Bubble Tea-compatible API surface.
 * <p>
 * Lipgloss: color.go
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.color.ANSIColors}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @since 0.3.0
 */
@Deprecated(since = "0.3.0", forRemoval = true)
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
