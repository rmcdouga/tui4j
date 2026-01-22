package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import org.jline.utils.AttributedStyle;

/**
 * Adaptive color that switches between light and dark variants.
 * <p>
 * Lipgloss: color.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.lipgloss.color.AdaptiveColor}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @since 0.3.0
 */
@Deprecated(since = "0.3.0")
public final class AdaptiveColor extends com.williamcallahan.tui4j.compat.lipgloss.color.AdaptiveColor implements TerminalColor {

    /**
     * Creates an adaptive color with light and dark values.
     *
     * @param light light color string
     * @param dark dark color string
     */
    public AdaptiveColor(String light, String dark) {
        super(light, dark);
    }

    /**
     * Applies this adaptive color as a background.
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
     * Applies this adaptive color as a foreground.
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
