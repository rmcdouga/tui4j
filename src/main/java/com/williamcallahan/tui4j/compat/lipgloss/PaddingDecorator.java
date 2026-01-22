package com.williamcallahan.tui4j.compat.lipgloss;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

/**
 * Port of Lip Gloss padding decorator.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: style.go.
 */
public class PaddingDecorator {

    /**
     * Handles apply padding for this component.
     *
     * @param input input
     * @param topPadding top padding
     * @param rightPadding right padding
     * @param bottomPadding bottom padding
     * @param leftPadding left padding
     * @param attributedStyle attributed style
     * @param renderer renderer
     * @return result
     */
    public static String applyPadding(String input,
                                      int topPadding,
                                      int rightPadding,
                                      int bottomPadding,
                                      int leftPadding,
                                      AttributedStyle attributedStyle,
                                      Renderer renderer) {
        String padded = input;
        if (leftPadding > 0) {
            padded = padLeft(padded, leftPadding, attributedStyle, renderer);
        }
        if (rightPadding > 0) {
            padded = padRight(padded, rightPadding, attributedStyle, renderer);
        }
        if (topPadding > 0) {
            padded = "\n".repeat(topPadding) + padded;
        }
        if (bottomPadding > 0) {
            padded += "\n".repeat(bottomPadding);
        }
        return padded;
    }

    /**
     * Handles pad left for this component.
     *
     * @param input input
     * @param leftPadding left padding
     * @param attributedStyle attributed style
     * @param renderer renderer
     * @return result
     */
    public static String padLeft(String input, int leftPadding, AttributedStyle attributedStyle, Renderer renderer) {
        return pad(input, -leftPadding, attributedStyle, renderer);
    }

    /**
     * Handles pad right for this component.
     *
     * @param input input
     * @param rightPadding right padding
     * @param attributedStyle attributed style
     * @param renderer renderer
     * @return result
     */
    public static String padRight(String input, int rightPadding, AttributedStyle attributedStyle, Renderer renderer) {
        return pad(input, rightPadding, attributedStyle, renderer);
    }

    /**
     * Handles pad for this component.
     *
     * @param str str
     * @param n n
     * @param attributedStyle attributed style
     * @param renderer renderer
     * @return result
     */
    public static String pad(String str, int n, AttributedStyle attributedStyle, Renderer renderer) {
        if (n == 0) {
            return str;
        }
        String padding = " ".repeat(Math.abs(n));

        if (attributedStyle != null) {
            padding = new AttributedString(padding, attributedStyle).toAnsi();
        }

        StringBuilder b = new StringBuilder();
        String[] lines = str.split("\n");

        for (int i = 0; i < lines.length; i++) {
            // pad right
            if (n > 0) {
                b.append(lines[i]);
                b.append(padding);
            }
            // pad left
            else {
                b.append(padding);
                b.append(lines[i]);
            }

            if (i != lines.length - 1) {
                b.append('\n');
            }
        }
        return b.toString();
    }
}
