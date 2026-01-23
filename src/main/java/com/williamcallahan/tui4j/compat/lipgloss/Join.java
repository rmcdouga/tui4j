package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.join.HorizontalJoinDecorator;
import com.williamcallahan.tui4j.compat.lipgloss.join.VerticalJoinDecorator;

/**
 * Port of Lip Gloss join helpers.
 * Upstream: github.com/charmbracelet/lipgloss/join.go
 */
public final class Join {

    /**
     * Prevents instantiation.
     */
    private Join() {
    }

    /**
     * Joins strings horizontally using the provided alignment.
     *
     * @param position vertical alignment within the join
     * @param strings strings to join
     * @return joined string
     */
    public static String joinHorizontal(Position position, String... strings) {
        return HorizontalJoinDecorator.joinHorizontal(position, strings);
    }

    /**
     * Joins strings vertically using the provided alignment.
     *
     * @param position horizontal alignment within the join
     * @param strings strings to join
     * @return joined string
     */
    public static String joinVertical(Position position, String... strings) {
        return VerticalJoinDecorator.joinVertical(position, strings);
    }
}
