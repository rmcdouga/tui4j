package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import org.jline.utils.AttributedStyle;

/**
 * No-op color implementation for Bubble Tea-compatible rendering.
 * <p>
 * Lipgloss: color.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.lipgloss.color.NoColor}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @since 0.3.0
 */
@Deprecated(since = "0.3.0")
public final class NoColor extends com.williamcallahan.tui4j.compat.lipgloss.color.NoColor implements TerminalColor {

    /**
     * Creates NoColor to keep this component ready for use.
     */
    public NoColor() {
        super();
    }

    /**
     * Applies this no-op color as a background.
     *
     * @param style style to update
     * @param renderer renderer context
     * @return unchanged style
     */
    @Override
    public AttributedStyle applyAsBackground(
        AttributedStyle style,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer renderer
    ) {
        return super.applyAsBackground(style, renderer.toCanonical());
    }

    /**
     * Applies this no-op color as a foreground.
     *
     * @param style style to update
     * @param renderer renderer context
     * @return unchanged style
     */
    @Override
    public AttributedStyle applyAsForeground(
        AttributedStyle style,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer renderer
    ) {
        return super.applyAsForeground(style, renderer.toCanonical());
    }
}
