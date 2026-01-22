package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.table;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.table.StyleFunc}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: table/table.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
@FunctionalInterface
public interface StyleFunc extends com.williamcallahan.tui4j.compat.lipgloss.table.StyleFunc {

    /**
     * Chooses the style for a table cell.
     *
     * @param row row index
     * @param col column index
     * @return style for the cell
     */
    @Override
    Style apply(int row, int col);
}
