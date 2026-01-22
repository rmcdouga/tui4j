package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.join.HorizontalJoinDecorator;
import com.williamcallahan.tui4j.compat.lipgloss.join.VerticalJoinDecorator;

/**
 * Utility for joining strings horizontally or vertically with alignment.
 * <p>
 * Port of charmbracelet/lipgloss join.go.
 *
 * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/join.go">lipgloss/join.go</a>
 * <p>
 * Lipgloss: join.go.
 */
public final class Join {

    /**
     * Creates Join to keep this component ready for use.
     */
    private Join() {
    }

    /**
     * Joins strings horizontally with the specified vertical alignment.
     *
     * @param position the vertical alignment (Top, Center, or Bottom)
     * @param strings the strings to join
     * @return the joined string
     */
    public static String joinHorizontal(Position position, String... strings) {
        return HorizontalJoinDecorator.joinHorizontal(position, strings);
    }

    /**
     * Joins strings vertically with the specified horizontal alignment.
     *
     * @param position the horizontal alignment (Left, Center, or Right)
     * @param strings the strings to join
     * @return the joined string
     */
    public static String joinVertical(Position position, String... strings) {
        return VerticalJoinDecorator.joinVertical(position, strings);
    }
}
