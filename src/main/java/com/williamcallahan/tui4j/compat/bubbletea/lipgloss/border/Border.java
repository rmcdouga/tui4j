package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.border;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.border.Border}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: borders.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record Border(
        String top,
        String bottom,
        String left,
        String right,
        String topLeft,
        String topRight,
        String bottomLeft,
        String bottomRight,
        String middleLeft,
        String middleRight,
        String middle,
        String middleTop,
        String middleBottom
) {
    /**
     * Handles to new for this component.
     *
     * @return result
     */
    public com.williamcallahan.tui4j.compat.lipgloss.border.Border toNew() {
        return new com.williamcallahan.tui4j.compat.lipgloss.border.Border(
                top, bottom, left, right, topLeft, topRight, bottomLeft, bottomRight,
                middleLeft, middleRight, middle, middleTop, middleBottom
        );
    }

    /**
     * Handles from new for this component.
     *
     * @param b b
     * @return result
     */
    public static Border fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.Border b) {
        if (b == null) return null;
        return new Border(
                b.top(), b.bottom(), b.left(), b.right(), b.topLeft(), b.topRight(), b.bottomLeft(), b.bottomRight(),
                b.middleLeft(), b.middleRight(), b.middle(), b.middleTop(), b.middleBottom()
        );
    }

    /**
     * Returns the top size.
     *
     * @return result
     */
    public int getTopSize() { return toNew().getTopSize(); }
    /**
     * Returns the right size.
     *
     * @return result
     */
    public int getRightSize() { return toNew().getRightSize(); }
    /**
     * Returns the bottom size.
     *
     * @return result
     */
    public int getBottomSize() { return toNew().getBottomSize(); }
    /**
     * Returns the left size.
     *
     * @return result
     */
    public int getLeftSize() { return toNew().getLeftSize(); }

    /**
     * Handles apply borders for this component.
     *
     * @param string string
     * @param hasTop has top
     * @param hasRight has right
     * @param hasBottom has bottom
     * @param hasLeft has left
     * @param borderTopForeground border top foreground
     * @param borderRightForeground border right foreground
     * @param borderBottomForeground border bottom foreground
     * @param borderLeftForeground border left foreground
     * @param borderTopBackground border top background
     * @param borderRightBackground border right background
     * @param borderBottomBackground border bottom background
     * @param borderLeftBackground border left background
     * @param renderer renderer
     * @return result
     */
    public String applyBorders(
        String string,
        boolean hasTop,
        boolean hasRight,
        boolean hasBottom,
        boolean hasLeft,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor borderTopForeground,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor borderRightForeground,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor borderBottomForeground,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor borderLeftForeground,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor borderTopBackground,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor borderRightBackground,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor borderBottomBackground,
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor borderLeftBackground,
        Renderer renderer
    ) {
        return toNew().applyBorders(string, hasTop, hasRight, hasBottom, hasLeft,
                toNew(borderTopForeground),
                toNew(borderRightForeground),
                toNew(borderBottomForeground),
                toNew(borderLeftForeground),
                toNew(borderTopBackground),
                toNew(borderRightBackground),
                toNew(borderBottomBackground),
                toNew(borderLeftBackground),
                renderer == null ? null : renderer.toCanonical());
    }

    /**
     * Adapts a Bubble Tea terminal color to the canonical lipgloss terminal color interface.
     *
     * @param color bubbletea terminal color
     * @return canonical terminal color
     */
    private static com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor toNew(
        com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color
    ) {
        if (color == null) {
            return null;
        }
        return new TerminalColorAdapter(color);
    }

    /**
     * Bridges legacy terminal colors to the canonical lipgloss color interface.
     */
    private static final class TerminalColorAdapter
        implements com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor {
        private final com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor legacy;

        /**
         * Creates an adapter for the legacy terminal color.
         *
         * @param legacy legacy terminal color
         */
        private TerminalColorAdapter(
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor legacy
        ) {
            this.legacy = legacy;
        }

        /**
         * Applies the legacy color as a background style.
         *
         * @param style base style
         * @param renderer renderer instance
         * @return updated style
         */
        @Override
        public org.jline.utils.AttributedStyle applyAsBackground(
            org.jline.utils.AttributedStyle style,
            com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
        ) {
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer legacyRenderer =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer.fromCanonical(renderer);
            return legacy.applyAsBackground(style, legacyRenderer);
        }

        /**
         * Applies the legacy color as a foreground style.
         *
         * @param style base style
         * @param renderer renderer instance
         * @return updated style
         */
        @Override
        public org.jline.utils.AttributedStyle applyAsForeground(
            org.jline.utils.AttributedStyle style,
            com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
        ) {
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer legacyRenderer =
                com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer.fromCanonical(renderer);
            return legacy.applyAsForeground(style, legacyRenderer);
        }
    }
}
