package com.williamcallahan.tui4j.compat.lipgloss.table;

import java.util.function.IntPredicate;

/**
 * A filtered view over table data that shows only rows matching a predicate.
 * <p>
 * Port of charmbracelet/lipgloss table/rows.go Filter type.
 *
 * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/table/rows.go">lipgloss/table/rows.go</a>
 */
public final class Filter implements Data {

    private final Data data;
    private IntPredicate predicate = row -> true;

    /**
     * Creates a filter over the given data.
     *
     * @param data the underlying data source
     */
    public Filter(Data data) {
        this.data = data;
    }

    /**
     * Sets the predicate for filtering rows.
     *
     * @param predicate a predicate that returns true for rows to include
     * @return this filter for chaining
     */
    public Filter filter(IntPredicate predicate) {
        this.predicate = predicate == null ? row -> true : predicate;
        return this;
    }

    @Override
    public String at(int row, int cell) {
        int index = 0;
        for (int i = 0; i < data.rows(); i++) {
            if (predicate.test(i)) {
                if (index == row) {
                    return data.at(i, cell);
                }
                index++;
            }
        }
        return "";
    }

    @Override
    public int rows() {
        int count = 0;
        for (int i = 0; i < data.rows(); i++) {
            if (predicate.test(i)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int columns() {
        return data.columns();
    }
}
