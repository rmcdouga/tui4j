package com.williamcallahan.tui4j.compat.lipgloss.align;

import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.compat.lipgloss.Position;
import com.williamcallahan.tui4j.compat.lipgloss.TextLines;
import org.jline.utils.AttributedCharSequence.ForceMode;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

import static com.williamcallahan.tui4j.compat.lipgloss.Position.Bottom;
import static com.williamcallahan.tui4j.compat.lipgloss.Position.Center;
import static com.williamcallahan.tui4j.compat.lipgloss.Position.Right;
import static com.williamcallahan.tui4j.compat.lipgloss.Position.Top;

/**
 * Port of Lip Gloss alignment decorator.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 */
public class AlignmentDecorator {

    /**
     * Utility class for text alignment.
     */
    private AlignmentDecorator() {
    }

    /**
     * Aligns text vertically within a fixed height.
     *
     * @param input text to align
     * @param position vertical alignment
     * @param height target height
     * @return vertically aligned text
     */
    public static String alignTextVertical(String input, Position position, int height) {

        int strHeight = (int) input.chars().filter(ch -> ch == '\n').count() + 1;
        if (height < strHeight) {
            return input;
        }

        if (position.equals(Top)) {
            return input + "\n".repeat(height - strHeight);
        } else if (position.equals(Center)) {
            int topPadding = (height - strHeight) / 2;
            int bottomPadding = (height - strHeight) / 2;

            if (strHeight + topPadding + bottomPadding > height) {
                topPadding--;
            } else if (strHeight + topPadding + bottomPadding < height) {
                bottomPadding++;
            }
            return "\n".repeat(topPadding) + input + "\n".repeat(bottomPadding);
        } else if (position.equals(Bottom)) {
            return "\n".repeat(height - strHeight) + input;
        }
        return input;
    }

    /**
     * Aligns text horizontally within a fixed width.
     *
     * @param input text to align
     * @param position horizontal alignment
     * @param width target width
     * @param attributedStyle style used for padding
     * @return horizontally aligned text
     */
    public static String alignTextHorizontal(String input, Position position, int width, AttributedStyle attributedStyle) {
        return alignTextHorizontal(input, position, width, attributedStyle, 0);
    }

    /**
     * Aligns text horizontally within a fixed width with color support.
     *
     * @param input text to align
     * @param position horizontal alignment
     * @param width target width
     * @param attributedStyle style used for padding
     * @param colorCount number of colors for ANSI output (0 for default)
     * @return horizontally aligned text
     */
    public static String alignTextHorizontal(String input, Position position, int width, AttributedStyle attributedStyle, int colorCount) {
        TextLines textLines = TextLines.fromText(input);
        int widestLine = textLines.widestLineLength();

        StringBuilder b = new StringBuilder();
        String[] lines = textLines.lines();
        for (int i = 0; i < lines.length; i++) {
            String l = lines[i];
            int lineWidth = TextWidth.measureCellWidth(l);

            // difference from the widest line
            int shortAmount = widestLine - lineWidth;
            // difference from the total width, if set
            shortAmount += Math.max(0, width - (shortAmount + lineWidth));

            if (shortAmount > 0) {
                if (position.equals(Right)) {
                    String s = " ".repeat(shortAmount);
                    if (attributedStyle != null) {
                        s = new AttributedString(s, attributedStyle).toAnsi(colorCount, ForceMode.None);
                    }
                    l = s + l;
                } else if (position.equals(Center)) {
                    // Note: remainder goes on the right
                    int left = shortAmount / 2;
                    int right = left + shortAmount % 2;

                    String leftSpaces = " ".repeat(left);
                    String rightSpaces = " ".repeat(right);

                    if (attributedStyle != null) {
                        leftSpaces = new AttributedString(leftSpaces, attributedStyle).toAnsi(colorCount, ForceMode.None);
                        rightSpaces = new AttributedString(rightSpaces, attributedStyle).toAnsi(colorCount, ForceMode.None);
                    }
                    l = leftSpaces + l + rightSpaces;
                } else {
                    // Left alignment (default)
                    String s = " ".repeat(shortAmount);
                    if (attributedStyle != null) {
                        s = new AttributedString(s, attributedStyle).toAnsi(colorCount, ForceMode.None);
                    }
                    l += s;
                }
            }

            b.append(l);
            if (i < lines.length - 1) {
                b.append('\n');
            }
        }

        return b.toString();
    }
}
