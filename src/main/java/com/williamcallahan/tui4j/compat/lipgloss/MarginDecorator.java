package com.williamcallahan.tui4j.compat.lipgloss;

import org.jline.utils.AttributedStyle;

import static com.williamcallahan.tui4j.compat.lipgloss.PaddingDecorator.padLeft;
import static com.williamcallahan.tui4j.compat.lipgloss.PaddingDecorator.padRight;

/**
 * Port of Lip Gloss margin decorator.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 */
public final class MarginDecorator {

    /**
     * Utility class.
     */
    private MarginDecorator() {
    }

    /**
     * Applies margins to the input string.
     *
     * @param input input string
     * @param topMargin top margin
     * @param rightMargin right margin
     * @param bottomMargin bottom margin
     * @param leftMargin left margin
     * @param attributedStyle attributed style
     * @param renderer renderer
     * @return string with margins applied
     */
    public static String applyMargins(String input,
                                      int topMargin,
                                      int rightMargin,
                                      int bottomMargin,
                                      int leftMargin,
                                      AttributedStyle attributedStyle,
                                      Renderer renderer) {
        String padded = input;
        if (leftMargin > 0) {
            padded = padLeft(padded, leftMargin, attributedStyle, renderer);
        }
        if (rightMargin > 0) {
            padded = padRight(padded, rightMargin, attributedStyle, renderer);
        }

        int width = TextLines.fromText(input).widestLineLength();
        String spaces = " ".repeat(width);
        if (topMargin > 0) {
            padded = (spaces + "\n").repeat(topMargin) + padded;
        }
        if (bottomMargin > 0) {
            padded += ("\n" + spaces).repeat(bottomMargin);
        }
        return padded;
    }
}