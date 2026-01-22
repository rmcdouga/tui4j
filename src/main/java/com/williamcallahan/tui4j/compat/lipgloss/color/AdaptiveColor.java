package com.williamcallahan.tui4j.compat.lipgloss.color;

import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * Port of Lip Gloss adaptive color.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: color.go.
 */
public class AdaptiveColor implements TerminalColor {

    private final Color light;
    private final Color dark;

    /**
     * Creates an adaptive color with light and dark variants.
     *
     * @param light light background color value
     * @param dark dark background color value
     */
    public AdaptiveColor(String light, String dark) {

        this.light = Color.color(light);
        this.dark = Color.color(dark);
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
        if (renderer.hasDarkBackground()) {
            return dark.applyAsBackground(style, renderer);
        }
        return light.applyAsBackground(style, renderer);
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
        if (renderer.hasDarkBackground()) {
            return dark.applyAsForeground(style, renderer);
        }
        return light.applyAsForeground(style, renderer);
    }
}
