package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.ansi.TextWidth;

/**
 * Port of Lip Gloss text lines.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 */
public class TextLines {

    private int widestLineLength;
    private String[] lines;

    /**
     * Handles from text for this component.
     *
     * @param text text
     * @return result
     */
    public static TextLines fromText(String text) {
        return new TextLines(text);
    }

    /**
     * Creates TextLines to keep this component ready for use.
     *
     * @param text text
     */
    private TextLines(String text) {
        readTextLines(text);
    }

    /**
     * Handles read text lines for this component.
     *
     * @param text text
     */
    private void readTextLines(String text) {
        this.lines = text.split("\n", -1);

        for (String line : lines) {
            int width = TextWidth.measureCellWidth(line);
            if (widestLineLength < width) {
                widestLineLength = width;
            }
        }
    }

    /**
     * Handles widest line length for this component.
     *
     * @return result
     */
    public int widestLineLength() {
        return widestLineLength;
    }

    /**
     * Handles lines for this component.
     *
     * @return result
     */
    public String[] lines() {
        return lines;
    }
}
