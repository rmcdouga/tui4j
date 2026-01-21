package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.join.HorizontalJoinDecorator;
import com.williamcallahan.tui4j.compat.lipgloss.join.VerticalJoinDecorator;

/**
 * Port of Lip Gloss join helpers.
 */
public final class Join {

    private Join() {
    }

    public static String joinHorizontal(Position position, String... strings) {
        return HorizontalJoinDecorator.joinHorizontal(position, strings);
    }

    public static String joinVertical(Position position, String... strings) {
        return VerticalJoinDecorator.joinVertical(position, strings);
    }
}
