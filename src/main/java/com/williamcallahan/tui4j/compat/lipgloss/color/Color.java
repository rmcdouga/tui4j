package com.williamcallahan.tui4j.compat.lipgloss.color;

import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * Simple hex or ANSI color.
 * <p>
 * Port of `lipgloss/color`.
 * Represents a color that can be applied to terminal output.
 * <p>
 * Lipgloss: color.go.
 */
public class Color implements TerminalColor {

    /**
     * Creates a {@link Color} from a string representation.
     *
     * @param color color string
     * @return color instance
     */
    public static Color color(String color) {
        return new Color(color);
    }

    private final String color;

    /**
     * Creates Color to keep this component ready for use.
     *
     * @param color color
     */
    protected Color(String color) {
        this.color = color;
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
        return renderer
                .colorProfile()
                .color(color)
                .applyAsBackground(style, renderer);
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
        return renderer
                .colorProfile()
                .color(color)
                .applyAsForeground(style, renderer);
    }
}
