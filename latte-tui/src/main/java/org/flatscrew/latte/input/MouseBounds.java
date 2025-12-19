package org.flatscrew.latte.input;

/**
 * Rectangular bounds in screen coordinates (columns/rows).
 * Latte extension; no Bubble Tea equivalent.
 *
 * @param left left column (0-based)
 * @param top top row (0-based)
 * @param width width in columns
 * @param height height in rows
 */
public record MouseBounds(int left, int top, int width, int height) {
    public boolean contains(int column, int row) {
        return column >= left
                && row >= top
                && column < left + width
                && row < top + height;
    }
}
