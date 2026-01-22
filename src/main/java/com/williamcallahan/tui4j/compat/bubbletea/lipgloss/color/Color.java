package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * Simple color wrapper for Bubble Tea-compatible rendering.
 * <p>
 * Lipgloss: color.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.lipgloss.color.Color}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @since 0.3.0
 */
@Deprecated(since = "0.3.0")
public final class Color extends com.williamcallahan.tui4j.compat.lipgloss.color.Color implements TerminalColor {

    /**
     * Creates a color from a string representation.
     *
     * @param color color string
     * @return color instance
     */
    public static Color color(String color) {
        return new Color(color);
    }

    /**
     * Creates Color to keep this component ready for use.
     *
     * @param color color string
     */
    private Color(String color) {
        super(color);
    }

    /**
     * Applies this color as a background.
     *
     * @param style style to update
     * @param renderer renderer context
     * @return updated style
     */
    @Override
    public AttributedStyle applyAsBackground(
        AttributedStyle style,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer renderer
    ) {
        return super.applyAsBackground(style, renderer.toCanonical());
    }

    /**
     * Applies this color as a foreground.
     *
     * @param style style to update
     * @param renderer renderer context
     * @return updated style
     */
    @Override
    public AttributedStyle applyAsForeground(
        AttributedStyle style,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer renderer
    ) {
        return super.applyAsForeground(style, renderer.toCanonical());
    }
}
