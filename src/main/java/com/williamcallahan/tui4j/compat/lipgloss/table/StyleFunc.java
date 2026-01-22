package com.williamcallahan.tui4j.compat.lipgloss.table;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Port of the Lip Gloss table style callback.
 * Upstream: github.com/charmbracelet/lipgloss/table (StyleFunc)
 * <p>
 * Lipgloss: table/table.go.
 */
@FunctionalInterface
public interface StyleFunc {

    /**
     * Handles apply for this component.
     *
     * @param row row
     * @param col col
     * @return result
     */
    Style apply(int row, int col);
}
