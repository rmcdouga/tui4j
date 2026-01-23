package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.ansi.TextWidth;

/**
 * Port of Lip Gloss size.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: size.go.
 */
public class Size {

    /**
     * Creates a size helper instance.
     */
    public Size() {
    }

    /**
     * Handles width for this component.
     *
     * @param input input
     * @return result
     */
    public static int width(String input) {
        int currWidth = 0;
        String[] strings = input.split("\n");
        for (String string : strings) {
            int cellWidth = TextWidth.measureCellWidth(string);
            if (cellWidth > currWidth) {
                currWidth = cellWidth;
            }
        }
        return currWidth;
    }

    /**
     * Handles height for this component.
     *
     * @param input input
     * @return result
     */
    public static int height(String input) {
        return (int) (input.chars().filter(ch -> ch == '\n').count() + 1);
    }
}
