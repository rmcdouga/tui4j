package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.join;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Position;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.join.VerticalJoinDecorator}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: join.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class VerticalJoinDecorator extends com.williamcallahan.tui4j.compat.lipgloss.join.VerticalJoinDecorator {

    /**
     * Prevents instantiation of the shim utility.
     */
    private VerticalJoinDecorator() {
    }

    /**
     * Joins blocks vertically using the legacy position type.
     *
     * @param position position to align within the widest block
     * @param blocks   blocks to join
     * @return joined block string
     */
    public static String joinVertical(Position position, String... blocks) {
        return com.williamcallahan.tui4j.compat.lipgloss.join.VerticalJoinDecorator
            .joinVertical(position.toNew(), blocks);
    }
}
