package com.williamcallahan.tui4j.compat.x.ansi;

/**
 * Method for calculating display width of cells.
 * Port of github.com/charmbracelet/x/ansi (method.go)
 */
public enum Method {
    /** Use wcwidth for width calculation (wide characters and runes). */
 */
    WC_WIDTH,
    /** Use grapheme clustering for width calculation (handles emojis and ZWJ sequences). */
 */
    GRAPHEME_WIDTH;

    /**
     * Returns the width of a string in cells.
     *
     * @param s the input string
     * @return the cell width
     */
    public int stringWidth(String s) {
        return StringWidth.stringWidth(this, s);
    }

    /**
     * Truncates a string to a given length, adding a tail if truncated.
     *
     * @param s the input string
     * @param length the maximum cell width
     * @param tail the tail to append if truncated
     * @return the truncated string
     */
    public String truncate(String s, int length, String tail) {
        return Truncate.truncate(this, s, length, tail);
    }

    /**
     * Truncates a string from the left side.
     *
     * @param s the input string
     * @param n the number of cells to remove from the left
     * @param prefix the prefix to prepend after truncation
     * @return the truncated string
     */
    public String truncateLeft(String s, int n, String prefix) {
        return Truncate.truncateLeft(this, s, n, prefix);
    }

    /**
     * Cuts the string to display a portion from left to right positions.
     *
     * @param s the input string
     * @param left start position (inclusive)
     * @param right end position (exclusive)
     * @return the cut string
     */
    public String cut(String s, int left, int right) {
        return Cut.cut(this, s, left, right);
    }
}
