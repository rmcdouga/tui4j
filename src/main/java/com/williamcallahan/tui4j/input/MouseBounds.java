package com.williamcallahan.tui4j.input;

/**
 * Bounds for mouse selection.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/input/MouseBounds.java
 *
 * @param left left column (0-based)
 * @param top top row (0-based)
 * @param width width in columns
 * @param height height in rows
 */
public record MouseBounds(int left, int top, int width, int height) {
    /**
     * Returns whether the given position lies within these bounds.
     *
     * @param column column to test
     * @param row row to test
     * @return {@code true} when inside the bounds
     */
    public boolean contains(int column, int row) {
        return column >= left
                && row >= top
                && column < left + width
                && row < top + height;
    }
}
