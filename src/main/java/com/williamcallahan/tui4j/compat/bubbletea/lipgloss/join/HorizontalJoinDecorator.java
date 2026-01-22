package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.join;

import com.williamcallahan.tui4j.compat.lipgloss.Position;

/**
 * Utility for joining strings horizontally.
 * <p>
 * Lipgloss: join.go
 *
 * @since 0.3.0
 * @see com.williamcallahan.tui4j.compat.lipgloss.join.HorizontalJoinDecorator
 */
public final class HorizontalJoinDecorator {

    /**
     * Prevents instantiation of the shim utility.
     */
    private HorizontalJoinDecorator() {
    }

    /**
     * Joins blocks horizontally with the specified vertical alignment.
     *
     * @param position vertical alignment position
     * @param blocks   blocks to join
     * @return joined block string
     */
    public static String joinHorizontal(Position position, String... blocks) {
        return com.williamcallahan.tui4j.compat.lipgloss.join.HorizontalJoinDecorator
            .joinHorizontal(position, blocks);
    }
}
