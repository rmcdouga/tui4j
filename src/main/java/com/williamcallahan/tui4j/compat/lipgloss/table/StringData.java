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

    public StringData() {
    }

    public StringData(List<List<String>> rows) {
        for (List<String> row : rows) {
            append(row.toArray(new String[0]));
        }
    }

    public StringData(String[]... rows) {
        for (String[] row : rows) {
            append(row);
        }
    }

    public StringData append(String... row) {
        this.columns = Math.max(this.columns, row.length);
        List<String> rowList = new ArrayList<>();
        for (String cell : row) {
            rowList.add(cell);
        }
        this.rows.add(rowList);
        return this;
    }

    public StringData item(String... row) {
        return append(row);
    }

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
