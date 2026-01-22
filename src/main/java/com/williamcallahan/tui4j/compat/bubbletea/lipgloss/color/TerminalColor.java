package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * Terminal color application contract for the Bubble Tea-compatible API surface.
 * <p>
 * Lipgloss: color.go.
 *
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor}.
 * This transitional shim preserves the legacy Bubble Tea method signatures and will be removed
 * in a future release.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public interface TerminalColor {
    /**
     * Applies this color as a background to the given style.
     *
     * @param style style to update
     * @param renderer renderer context
     * @return updated style
     */
    AttributedStyle applyAsBackground(AttributedStyle style, Renderer renderer);

    /**
     * Applies this color as a foreground to the given style.
     *
     * @param style style to update
     * @param renderer renderer context
     * @return updated style
     */
    AttributedStyle applyAsForeground(AttributedStyle style, Renderer renderer);
}
