package com.williamcallahan.tui4j.compat.lipgloss.color;

import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * RGBColor is a hex-encoded color, e.g. "#ff0000"
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: color.go.
 */
public final class RGBColor implements TerminalColor, RGBSupplier {

    private final ColorApplyStrategy colorApplyStrategy;
    private final RGB rgb;

    /**
     * Creates RGBColor to keep this component ready for use.
     *
     * @param hexValue hex value
     */
    public RGBColor(String hexValue) {
        this.colorApplyStrategy = new HexColorApplyStrategy(hexValue);
        this.rgb = RGB.fromHexString(hexValue);
    }

    /**
     * Creates RGBColor to keep this component ready for use.
     *
     * @param r r
     * @param g g
     * @param b b
     */
    public RGBColor(int r, int g, int b) {
        this.rgb = new RGB(r, g, b);
        this.colorApplyStrategy = rgb().asColorApplyStrategy();
    }

    /**
     * Handles apply as background for this component.
     *
     * @param style style
     * @param renderer renderer
     * @return result
     */
    @Override
    public AttributedStyle applyAsBackground(AttributedStyle style, Renderer renderer) {
        return colorApplyStrategy.applyForBackground(style);
    }

    /**
     * Handles apply as foreground for this component.
     *
     * @param style style
     * @param renderer renderer
     * @return result
     */
    @Override
    public AttributedStyle applyAsForeground(AttributedStyle style, Renderer renderer) {
        return colorApplyStrategy.applyForForeground(style);
    }

    /**
     * Handles rgb for this component.
     *
     * @return result
     */
    @Override
    public RGB rgb() {
        return rgb;
    }

    /**
     * Handles to ansi256 color for this component.
     *
     * @return result
     */
    public ANSI256Color toANSI256Color() {
        return rgb.toANSI256Color();
    }
}
