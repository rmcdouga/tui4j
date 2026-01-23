package com.williamcallahan.tui4j.compat.lipgloss.table;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Port of the Lip Gloss table style callback.
 * Upstream: github.com/charmbracelet/lipgloss/table (StyleFunc)
 */
@FunctionalInterface
public interface StyleFunc {

    /**
     * Returns the style for a cell at the given position.
     *
     * @param row row index
     * @param col column index
     * @return style for the cell
     */
    Style apply(int row, int col);
}
