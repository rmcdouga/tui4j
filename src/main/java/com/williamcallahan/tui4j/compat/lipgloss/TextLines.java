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
     * Creates text lines from a string.
     *
     * @param text text to split into lines
     * @return text lines instance
     */
    public static TextLines fromText(String text) {
        return new TextLines(text);
    }

    private TextLines(String text) {
        readTextLines(text);
    }

    private void readTextLines(String text) {
        // Normalize CRLF to LF to prevent stray carriage returns in terminal output
        this.lines = text.replace("\r\n", "\n").replace("\r", "\n").split("\n", -1);

        for (String line : lines) {
            int width = TextWidth.measureCellWidth(line);
            if (widestLineLength < width) {
                widestLineLength = width;
            }
        }
    }

    /**
     * Returns the width of the widest line in cells.
     *
     * @return widest line width
     */
    public int widestLineLength() {
        return widestLineLength;
    }

    /**
     * Returns the lines as an array.
     *
     * @return array of lines
     */
    public String[] lines() {
        return lines;
    }
}
