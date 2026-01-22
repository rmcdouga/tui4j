package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import org.jline.utils.AttributedStyle;

/**
 * RGB color defined by hex values for the Bubble Tea-compatible API surface.
 * <p>
 * Lipgloss: color.go.
 *
 * @since 0.3.0
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved to the canonical TUI4J path; use {@link com.williamcallahan.tui4j.compat.lipgloss.color.RGBColor} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public final class RGBColor implements TerminalColor, RGBSupplier {

    private final com.williamcallahan.tui4j.compat.lipgloss.color.RGBColor delegate;

    /**
     * Creates an RGB color from a hex string.
     *
     * @param hexValue hex color (e.g., "#ff0000")
     */
    public RGBColor(String hexValue) {
        this.delegate =
            new com.williamcallahan.tui4j.compat.lipgloss.color.RGBColor(
                hexValue
            );
    }

    /**
     * Creates an RGB color from 8-bit channel values.
     *
     * @param r red channel (0-255)
     * @param g green channel (0-255)
     * @param b blue channel (0-255)
     */
    public RGBColor(int r, int g, int b) {
        this.delegate =
            new com.williamcallahan.tui4j.compat.lipgloss.color.RGBColor(
                r,
                g,
                b
            );
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
        return delegate.applyAsBackground(style, renderer.toCanonical());
    }

    /**
     * Applies this color as a background using the canonical renderer.
     *
     * @param style style to update
     * @param renderer canonical renderer context
     * @return updated style
     */
    public AttributedStyle applyAsBackground(
        AttributedStyle style,
        com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
    ) {
        return delegate.applyAsBackground(style, renderer);
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
        return delegate.applyAsForeground(style, renderer.toCanonical());
    }

    /**
     * Applies this color as a foreground using the canonical renderer.
     *
     * @param style style to update
     * @param renderer canonical renderer context
     * @return updated style
     */
    public AttributedStyle applyAsForeground(
        AttributedStyle style,
        com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
    ) {
        return delegate.applyAsForeground(style, renderer);
    }

    /**
     * Returns the RGB value for this color.
     *
     * @return RGB value
     */
    @Override
    public com.williamcallahan.tui4j.compat.lipgloss.color.RGB rgb() {
        return delegate.rgb();
    }

    /**
     * Converts this color to the closest ANSI 256-color entry.
     *
     * @return ANSI 256 color
     */
    public com.williamcallahan.tui4j.compat.lipgloss.color.ANSI256Color toANSI256Color() {
        return delegate.toANSI256Color();
    }

    /**
     * Returns the canonical RGB color delegate.
     *
     * @return canonical RGB color
     */
    public com.williamcallahan.tui4j.compat.lipgloss.color.RGBColor toCanonical() {
        return delegate;
    }
}
