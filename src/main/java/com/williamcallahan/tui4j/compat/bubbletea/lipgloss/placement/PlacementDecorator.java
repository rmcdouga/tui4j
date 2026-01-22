package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.placement;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Position;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Whitespace.WhitespaceOption;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved; use {@link com.williamcallahan.tui4j.compat.lipgloss.PlacementDecorator}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: style.go.
 */
@Deprecated(since = "0.3.0")
public class PlacementDecorator extends com.williamcallahan.tui4j.compat.lipgloss.PlacementDecorator {

    /**
     * Creates a placement decorator instance for legacy compatibility.
     */
    public PlacementDecorator() {
    }

    /**
     * Places text within a rectangle using legacy positions.
     *
     * @param width   width in cells
     * @param height  height in rows
     * @param hPos    horizontal position
     * @param vPos    vertical position
     * @param input   input text
     * @param options whitespace options
     * @return placed text
     */
    public static String place(
        int width,
        int height,
        Position hPos,
        Position vPos,
        String input,
        WhitespaceOption... options
    ) {
        return Renderer.defaultRenderer().place(width, height, hPos, vPos, input, options);
    }

    /**
     * Places text horizontally within a width using legacy positions.
     *
     * @param width    width in cells
     * @param position horizontal position
     * @param input    input text
     * @param options  whitespace options
     * @return placed text
     */
    public static String placeHorizontal(
        int width,
        Position position,
        String input,
        WhitespaceOption... options
    ) {
        return Renderer.defaultRenderer().placeHorizontal(width, position, input, options);
    }

    /**
     * Places text vertically within a height using legacy positions.
     *
     * @param height   height in rows
     * @param position vertical position
     * @param input    input text
     * @param options  whitespace options
     * @return placed text
     */
    public static String placeVertical(
        int height,
        Position position,
        String input,
        WhitespaceOption... options
    ) {
        return Renderer.defaultRenderer().placeVertical(height, position, input, options);
    }
}
