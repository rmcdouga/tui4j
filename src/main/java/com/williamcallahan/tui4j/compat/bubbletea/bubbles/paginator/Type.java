package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

/**
 */
public enum Type {
    Dots,
    Arabic;

    /**
     * Handles from old for this component.
     *
     * @param oldType old type
     * @return result
     */
    public static com.williamcallahan.tui4j.compat.bubbles.paginator.Type fromOld(Type oldType) {
        return switch (oldType) {
            case Dots -> com.williamcallahan.tui4j.compat.bubbles.paginator.Type.Dots;
            case Arabic -> com.williamcallahan.tui4j.compat.bubbles.paginator.Type.Arabic;
        };
    }
}
