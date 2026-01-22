package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * ANSI 256-color representation for the Bubble Tea-compatible API surface.
 * <p>
 * Lipgloss: color.go.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.color.ANSI256Color}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @since 0.3.0
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public final class ANSI256Color implements TerminalColor, RGBSupplier {

    private final com.williamcallahan.tui4j.compat.lipgloss.color.ANSI256Color delegate;

    /**
     * Creates an ANSI 256 color from a color code.
     *
     * @param colorCode ANSI 256 color code (0-255)
     */
    public ANSI256Color(int colorCode) {
        this.delegate = new com.williamcallahan.tui4j.compat.lipgloss.color.ANSI256Color(colorCode);
    }

    /**
     * Applies this ANSI 256 color as a background.
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
     * Applies this ANSI 256 color as a foreground.
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
     * Returns the RGB approximation for this ANSI 256 color.
     *
     * @return RGB value
     */
    @Override
    public RGB rgb() {
        return RGB.fromCanonical(delegate.rgb());
    }

    /**
     * Converts this 256-color entry to the closest ANSI 16-color entry.
     *
     * @return closest ANSI color
     */
    public ANSIColor toANSIColor() {
        return new ANSIColor(delegate.toANSIColor().value());
    }

    /**
     * Returns the ANSI 256-color code.
     *
     * @return color code
     */
    public int value() {
        return delegate.value();
    }
}
