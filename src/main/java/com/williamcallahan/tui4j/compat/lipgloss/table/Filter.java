package com.williamcallahan.tui4j.compat.lipgloss.table;

import java.util.function.IntPredicate;

/**
 * Filtered table data view.
 * <p>
 * Port of github.com/charmbracelet/lipgloss/table/rows.go (Filter).
 */
public final class Filter implements Data {

    private final Data data;
    private IntPredicate predicate = row -> true;

    /**
     * Creates a filtered view over table data.
     *
     * @param data backing data source
     */
    public Filter(Data data) {
        this.data = data;
    }

    /**
     * Sets the predicate used to include rows.
     *
     * @param predicate row predicate; {@code null} resets to accept all rows
     * @return this filter for chaining
     */
    public Filter filter(IntPredicate predicate) {
        this.predicate = predicate == null ? row -> true : predicate;
        return this;
    }

    /**
     * Returns the value at the filtered row and column.
     *
     * @param row filtered row index
     * @param cell column index
     * @return cell value or empty string when missing
     */
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

    /**
     * Returns the number of rows that match the predicate.
     *
     * @return filtered row count
     */
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

    /**
     * Returns the number of columns in the backing data.
     *
     * @return column count
     */
    @Override
    public int columns() {
        return data.columns();
    }
}
