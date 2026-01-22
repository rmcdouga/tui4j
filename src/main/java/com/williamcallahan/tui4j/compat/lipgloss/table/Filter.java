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

    public Filter(Data data) {
        this.data = data;
    }

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
