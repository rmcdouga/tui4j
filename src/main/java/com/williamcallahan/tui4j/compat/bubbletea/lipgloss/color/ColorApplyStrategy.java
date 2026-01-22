package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import org.jline.utils.AttributedStyle;

/**
 * Applies color to styles for Bubble Tea-compatible color implementations.
 * <p>
 * Lipgloss: color.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved to the canonical TUI4J path; use {@link com.williamcallahan.tui4j.compat.lipgloss.color.ColorApplyStrategy} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public interface ColorApplyStrategy {
    /**
     * Applies this strategy for foreground styling.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    AttributedStyle applyForForeground(AttributedStyle attributedStyle);

    /**
     * Applies this strategy for background styling.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    AttributedStyle applyForBackground(AttributedStyle attributedStyle);
}

/**
 * Strategy that applies ANSI color codes.
 */
class ColorCodeApplyStrategy implements ColorApplyStrategy {

    private final int colorCode;

    /**
     * Creates a strategy for an ANSI color code.
     *
     * @param colorCode ANSI color code
     */
    ColorCodeApplyStrategy(int colorCode) {
        this.colorCode = colorCode;
    }

    /**
     * Applies the ANSI color as a foreground.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    @Override
    public AttributedStyle applyForForeground(AttributedStyle attributedStyle) {
        return attributedStyle.foreground(colorCode);
    }

    /**
     * Applies the ANSI color as a background.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    @Override
    public AttributedStyle applyForBackground(AttributedStyle attributedStyle) {
        return attributedStyle.background(colorCode);
    }
}

/**
 * Strategy that applies RGB values.
 */
class RGBAApplyStrategy implements ColorApplyStrategy {

    private final int r;
    private final int g;
    private final int b;

    /**
     * Creates a strategy for explicit RGB values.
     *
     * @param r red channel (0-255)
     * @param g green channel (0-255)
     * @param b blue channel (0-255)
     */
    public RGBAApplyStrategy(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Creates a strategy from an RGB instance.
     *
     * @param rgb rgb value
     */
    public RGBAApplyStrategy(
        com.williamcallahan.tui4j.compat.lipgloss.color.RGB rgb
    ) {
        this.r = (int) (rgb.r() * 255);
        this.g = (int) (rgb.g() * 255);
        this.b = (int) (rgb.b() * 255);
    }

    /**
     * Applies the RGB value as a foreground.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    @Override
    public AttributedStyle applyForForeground(AttributedStyle attributedStyle) {
        return attributedStyle.foreground(r, g, b);
    }

    /**
     * Applies the RGB value as a background.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    @Override
    public AttributedStyle applyForBackground(AttributedStyle attributedStyle) {
        return attributedStyle.background(r, g, b);
    }
}

/**
 * Strategy that applies a hex color value.
 */
class HexColorApplyStrategy implements ColorApplyStrategy {

    private final ColorApplyStrategy rgbaApplyStrategy;

    /**
     * Creates a strategy for a hex color.
     *
     * @param hexValue hex color value
     */
    public HexColorApplyStrategy(String hexValue) {
        com.williamcallahan.tui4j.compat.lipgloss.color.RGB rgb =
            com.williamcallahan.tui4j.compat.lipgloss.color.RGB.fromHexString(
                hexValue
            );
        this.rgbaApplyStrategy = new RGBAApplyStrategy(rgb);
    }

    /**
     * Applies the hex color as a foreground.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    @Override
    public AttributedStyle applyForForeground(AttributedStyle attributedStyle) {
        return rgbaApplyStrategy.applyForForeground(attributedStyle);
    }

    /**
     * Applies the hex color as a background.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    @Override
    public AttributedStyle applyForBackground(AttributedStyle attributedStyle) {
        return rgbaApplyStrategy.applyForBackground(attributedStyle);
    }
}
