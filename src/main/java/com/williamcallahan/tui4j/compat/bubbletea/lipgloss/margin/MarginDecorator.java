package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.margin;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * Margin utilities for Bubble Tea-compatible layouts.
 * <p>
 * Lipgloss: style.go.
 *
 * @since 0.3.0
 */
public final class MarginDecorator {

    /**
     * Prevents instantiation of the deprecated shim.
     */
    private MarginDecorator() {
    }

    /**
     * Applies margins to all sides.
     *
     * @param input           input string
     * @param topMargin       top margin
     * @param rightMargin     right margin
     * @param bottomMargin    bottom margin
     * @param leftMargin      left margin
     * @param attributedStyle style to preserve for margins
     * @param renderer        renderer to use
     * @return margined string
     */
    public static String applyMargins(
        String input,
        int topMargin,
        int rightMargin,
        int bottomMargin,
        int leftMargin,
        AttributedStyle attributedStyle,
        Renderer renderer
    ) {
        return com.williamcallahan.tui4j.compat.lipgloss.MarginDecorator.applyMargins(
            input,
            topMargin,
            rightMargin,
            bottomMargin,
            leftMargin,
            attributedStyle,
            renderer == null ? null : renderer.toCanonical()
        );
    }
}
