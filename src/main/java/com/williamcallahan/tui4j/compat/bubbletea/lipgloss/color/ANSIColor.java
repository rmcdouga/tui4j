package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * ANSI 16-color representation for the Bubble Tea-compatible API surface.
 * <p>
 * Lipgloss: color.go.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.color.ANSIColor}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @since 0.3.0
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public final class ANSIColor implements TerminalColor, RGBSupplier {

    private final com.williamcallahan.tui4j.compat.lipgloss.color.ANSIColor delegate;

    /**
     * Creates an ANSI color from a 16-color code.
     *
     * @param colorCode ANSI color code (0-15)
     */
    public ANSIColor(int colorCode) {
        this.delegate = new com.williamcallahan.tui4j.compat.lipgloss.color.ANSIColor(colorCode);
    }

    /**
     * Applies this ANSI color as a background.
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
        return delegate.applyAsBackground(style, renderer.toCanonical());
    }

    /**
     * Applies this ANSI color as a background using the canonical renderer.
     *
     * @param style style to update
     * @param renderer canonical renderer context
     * @return updated style
     */
    @Override
    public AttributedStyle applyAsBackground(
        AttributedStyle style,
        com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
    ) {
        return delegate.applyAsBackground(style, renderer);
    }

    /**
     * Applies this ANSI color as a foreground.
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
        return delegate.applyAsForeground(style, renderer.toCanonical());
    }

    /**
     * Applies this ANSI color as a foreground using the canonical renderer.
     *
     * @param style style to update
     * @param renderer canonical renderer context
     * @return updated style
     */
    @Override
    public AttributedStyle applyAsForeground(
        AttributedStyle style,
        com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
    ) {
        return delegate.applyAsForeground(style, renderer);
    }

    /**
     * Returns the RGB approximation for this ANSI color.
     *
     * @return RGB value
     */
    @Override
    public RGB rgb() {
        return RGB.fromCanonical(delegate.rgb());
    }

    /**
     * Returns the ANSI 16-color code.
     *
     * @return color code
     */
    public int value() {
        return delegate.value();
    }
}
