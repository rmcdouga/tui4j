package com.williamcallahan.tui4j.compat.lipgloss.color;

import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * Port of Lip Gloss ansi color.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: color.go.
 */
public final class ANSIColor implements TerminalColor, RGBSupplier {

    private final ColorApplyStrategy applyStrategy;
    private final int colorCode;

    /**
     * Creates an ANSI 16-color entry from an ANSI color code.
     *
     * @param colorCode ANSI 16-color code
     */
    public ANSIColor(int colorCode) {
        this.applyStrategy = new ColorCodeApplyStrategy(colorCode);
        this.colorCode = colorCode;
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
        return applyStrategy.applyForBackground(style);
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
        return applyStrategy.applyForForeground(style);
    }

    /**
     * Handles rgb for this component.
     *
     * @return result
     */
    @Override
    public RGB rgb() {
        return RGB.fromHexString(ANSIColors.ANSI_HEX[colorCode]);
    }

    /**
     * Returns the ANSI 16-color code.
     *
     * @return color code
     */
    public int value() {
        return colorCode;
    }
}
