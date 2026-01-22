package com.williamcallahan.tui4j.compat.lipgloss.color;

import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * RGBColor is a hex-encoded color, e.g. "#ff0000"
 * Upstream: lipgloss/color.go
 */
public final class RGBColor implements TerminalColor, RGBSupplier {

    private final ColorApplyStrategy colorApplyStrategy;
    private final RGB rgb;

    /**
     * Creates an RGB color from a hex string.
     *
     * @param hexValue hex color string (e.g., "#ff0000")
     */
    public RGBColor(String hexValue) {
        this.colorApplyStrategy = new HexColorApplyStrategy(hexValue);
        this.rgb = RGB.fromHexString(hexValue);
    }

    /**
     * Creates an RGB color from component values.
     *
     * @param r red channel (0-255)
     * @param g green channel (0-255)
     * @param b blue channel (0-255)
     */
    public RGBColor(int r, int g, int b) {
        this.rgb = new RGB(r, g, b);
        this.colorApplyStrategy = rgb().asColorApplyStrategy();
    }

    @Override
    public AttributedStyle applyAsBackground(AttributedStyle style, Renderer renderer) {
        return colorApplyStrategy.applyForBackground(style);
    }

    @Override
    public AttributedStyle applyAsForeground(AttributedStyle style, Renderer renderer) {
        return colorApplyStrategy.applyForForeground(style);
    }

    @Override
    public RGB rgb() {
        return rgb;
    }

    /**
     * Converts this color to an ANSI 256 color.
     *
     * @return ANSI 256 color
     */
    public ANSI256Color toANSI256Color() {
        return rgb.toANSI256Color();
    }
}
