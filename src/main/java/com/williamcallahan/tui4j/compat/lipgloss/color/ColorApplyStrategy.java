package com.williamcallahan.tui4j.compat.lipgloss.color;

import org.jline.utils.AttributedStyle;

/**
 * Port of Lip Gloss color apply strategy.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: color.go.
 */
public interface ColorApplyStrategy {
    /**
     * Applies a foreground color to the style.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    AttributedStyle applyForForeground(AttributedStyle attributedStyle);

    /**
     * Applies a background color to the style.
     *
     * @param attributedStyle style to update
     * @return updated style
     */
    AttributedStyle applyForBackground(AttributedStyle attributedStyle);
}

/**
 * Compatibility port of ColorCodeApplyStrategy to preserve upstream behavior.
 * <p>
 * Lipgloss: color.go.
 */
class ColorCodeApplyStrategy implements ColorApplyStrategy {

    private final int colorCode;

    /**
     * Creates ColorCodeApplyStrategy to keep this component ready for use.
     *
     * @param colorCode color code
     */
    ColorCodeApplyStrategy(int colorCode) {
        this.colorCode = colorCode;
    }

    /**
     * Handles apply for foreground for this component.
     *
     * @param attributedStyle attributed style
     * @return result
     */
    @Override
    public AttributedStyle applyForForeground(AttributedStyle attributedStyle) {
        return attributedStyle.foreground(colorCode);
    }

    /**
     * Handles apply for background for this component.
     *
     * @param attributedStyle attributed style
     * @return result
     */
    @Override
    public AttributedStyle applyForBackground(AttributedStyle attributedStyle) {
        return attributedStyle.background(colorCode);
    }
}

/**
 * Compatibility port of RGBAApplyStrategy to preserve upstream behavior.
 * <p>
 * Lipgloss: color.go.
 */
class RGBAApplyStrategy implements ColorApplyStrategy {

    private final int r;
    private final int g;
    private final int b;

    /**
     * Creates RGBAApplyStrategy to keep this component ready for use.
     *
     * @param r r
     * @param g g
     * @param b b
     */
    public RGBAApplyStrategy(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Creates RGBAApplyStrategy to keep this component ready for use.
     *
     * @param rgb rgb
     */
    public RGBAApplyStrategy(RGB rgb) {
        this.r = (int) (rgb.r() * 255);
        this.g = (int) (rgb.g() * 255);
        this.b = (int) (rgb.b() * 255);
    }

    /**
     * Handles apply for foreground for this component.
     *
     * @param attributedStyle attributed style
     * @return result
     */
    @Override
    public AttributedStyle applyForForeground(AttributedStyle attributedStyle) {
        return attributedStyle.foreground(r, g, b);
    }

    /**
     * Handles apply for background for this component.
     *
     * @param attributedStyle attributed style
     * @return result
     */
    @Override
    public AttributedStyle applyForBackground(AttributedStyle attributedStyle) {
        return attributedStyle.background(r, g, b);
    }
}

/**
 * Compatibility port of HexColorApplyStrategy to preserve upstream behavior.
 * <p>
 * Lipgloss: color.go.
 */
class HexColorApplyStrategy implements ColorApplyStrategy {

    private final ColorApplyStrategy rgbaApplyStrategy;

    /**
     * Creates HexColorApplyStrategy to keep this component ready for use.
     *
     * @param hexValue hex value
     */
    public HexColorApplyStrategy(String hexValue) {
        this.rgbaApplyStrategy = RGB.fromHexString(hexValue).asColorApplyStrategy();
    }

    /**
     * Handles apply for foreground for this component.
     *
     * @param attributedStyle attributed style
     * @return result
     */
    @Override
    public AttributedStyle applyForForeground(AttributedStyle attributedStyle) {
        return rgbaApplyStrategy.applyForForeground(attributedStyle);
    }

    /**
     * Handles apply for background for this component.
     *
     * @param attributedStyle attributed style
     * @return result
     */
    @Override
    public AttributedStyle applyForBackground(AttributedStyle attributedStyle) {
        return rgbaApplyStrategy.applyForBackground(attributedStyle);
    }
}
