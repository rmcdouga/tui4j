package com.williamcallahan.tui4j.compat.lipgloss.table;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Port of the Lip Gloss table style callback.
 * Upstream: github.com/charmbracelet/lipgloss/table (StyleFunc)
 */
@FunctionalInterface
public interface StyleFunc {

    Style apply(int row, int col);
}
