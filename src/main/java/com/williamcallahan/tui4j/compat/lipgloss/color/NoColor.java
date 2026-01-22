package com.williamcallahan.tui4j.compat.lipgloss.color;

import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * Port of Lip Gloss no color.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: color.go.
 */
public class NoColor implements TerminalColor{

    /**
     * Handles apply as background for this component.
     *
     * @param style style
     * @param renderer renderer
     * @return result
     */
    @Override
    public AttributedStyle applyAsBackground(AttributedStyle style, Renderer renderer) {
        return style;
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
        return style;
    }
}
