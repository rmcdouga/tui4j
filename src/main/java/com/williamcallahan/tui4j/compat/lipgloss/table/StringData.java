package com.williamcallahan.tui4j.compat.lipgloss.table;

import java.util.ArrayList;
import java.util.List;

/**
 * String-backed table data storage.
 * <p>
 * Port of github.com/charmbracelet/lipgloss/table/rows.go (StringData).
 */
public class StringData implements Data {

    private List<List<String>> rows = new ArrayList<>();
    private int columns = 0;

    /**
     * Creates an empty string data store.
     */
    public StringData() {
    }

    /**
     * Creates a string data store from nested lists.
     *
     * @param rows row data
     */
    public StringData(List<List<String>> rows) {
        for (List<String> row : rows) {
            append(row.toArray(new String[0]));
        }
    }

    /**
     * Creates a string data store from arrays.
     *
     * @param rows row data
     */
    public StringData(String[]... rows) {
        for (String[] row : rows) {
            append(row);
        }
    }

    /**
     * Appends a row to this data store.
     *
     * @param row row cells
     * @return this data store
     */
    public StringData append(String... row) {
        this.columns = Math.max(this.columns, row.length);
        List<String> rowList = new ArrayList<>();
        for (String cell : row) {
            rowList.add(cell);
        }
        this.rows.add(rowList);
        return this;
    }

    /**
     * Alias for {@link #append(String...)}.
     *
     * @param row row cells
     * @return this data store
     */
    public StringData item(String... row) {
        return append(row);
    }

    /**
     * Clears all rows from this data store.
     *
     * @return this data store
     */
    public StringData clear() {
        rows.clear();
        columns = 0;
        return this;
    }

    @Override
    public String at(int row, int cell) {
        if (row >= rows.size() || cell >= rows.get(row).size()) {
            return "";
        }
        return rows.get(row).get(cell);
    }

    @Override
    public int rows() {
        return rows.size();
    }

    @Override
    public int columns() {
        return columns;
    }
}
