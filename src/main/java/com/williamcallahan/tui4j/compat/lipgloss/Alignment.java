package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.align.AlignmentDecorator;
import org.jline.utils.AttributedStyle;

/**
 * Port of Lip Gloss alignment helpers.
 * Lip Gloss: lipgloss/align.go
 */
public final class Alignment {

    /**
     * Creates Alignment to keep this component ready for use.
     */
    private Alignment() {
    }

    /**
     * Aligns text horizontally using the default attributed style.
     *
     * @param input input text
     * @param position alignment position
     * @param width target width
     * @return aligned text
     */
    public static String alignTextHorizontal(String input, Position position, int width) {
        return alignTextHorizontal(input, position, width, AttributedStyle.DEFAULT);
    }

    /**
     * Aligns text horizontally using the provided attributed style.
     *
     * @param input input text
     * @param position alignment position
     * @param width target width
     * @param attributedStyle style to apply
     * @return aligned text
     */
    public static String alignTextHorizontal(String input, Position position, int width, AttributedStyle attributedStyle) {
        return AlignmentDecorator.alignTextHorizontal(input, position, width, attributedStyle);
    }

    /**
     * Aligns text vertically.
     *
     * @param input input text
     * @param position alignment position
     * @param height target height
     * @return aligned text
     */
    public static String alignTextVertical(String input, Position position, int height) {
        return AlignmentDecorator.alignTextVertical(input, position, height);
    }
}
