package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.Whitespace.WhitespaceOption;

import static com.williamcallahan.tui4j.compat.lipgloss.Renderer.defaultRenderer;

/**
 * Port of Lip Gloss placement decorator.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: style.go.
 */
public class PlacementDecorator {

    /**
     * Handles place for this component.
     *
     * @param width width
     * @param height height
     * @param hPos h pos
     * @param vPos v pos
     * @param input input
     * @param options options
     * @return result
     */
    public static String place(int width, int height, Position hPos, Position vPos, String input, WhitespaceOption... options) {
        return defaultRenderer().place(width, height, hPos, vPos, input, options);
    }

    /**
     * Handles place horizontal for this component.
     *
     * @param width width
     * @param position position
     * @param input input
     * @param options options
     * @return result
     */
    public static String placeHorizontal(int width, Position position, String input, WhitespaceOption... options) {
        return defaultRenderer().placeHorizontal(width, position, input, options);
    }

    /**
     * Handles place vertical for this component.
     *
     * @param height height
     * @param position position
     * @param input input
     * @param options options
     * @return result
     */
    public static String placeVertical(int height, Position position, String input, WhitespaceOption... options) {
        return defaultRenderer().placeVertical(height, position, input, options);
    }
}
