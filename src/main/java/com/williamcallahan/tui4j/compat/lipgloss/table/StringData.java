package com.williamcallahan.tui4j.compat.lipgloss.table;

import java.util.ArrayList;
import java.util.List;

/**
 * String-backed table data storage.
 * <p>
 * Port of github.com/charmbracelet/lipgloss/table/rows.go (StringData).
 * <p>
 * Lipgloss: table/table.go.
 */
public class StringData implements Data {

    private List<List<String>> rows = new ArrayList<>();
    private int columns = 0;

    /**
     * Creates StringData to keep this component ready for use.
     */
    public StringData() {
    }

    /**
     * Creates StringData to keep this component ready for use.
     *
     * @param rows rows
     */
    public StringData(List<List<String>> rows) {
        for (List<String> row : rows) {
            append(row.toArray(new String[0]));
        }
    }

    /**
     * Creates StringData to keep this component ready for use.
     *
     * @param rows rows
     */
    public StringData(String[]... rows) {
        for (String[] row : rows) {
            append(row);
        }
    }

    /**
     * Handles append for this component.
     *
     * @param row row
     * @return result
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
     * Handles item for this component.
     *
     * @param row row
     * @return result
     */
    public StringData item(String... row) {
        return append(row);
    }

    /**
     * Handles clear for this component.
     *
     * @return result
     */
    public StringData clear() {
        rows.clear();
        columns = 0;
        return this;
    }

    /**
     * Handles at for this component.
     *
     * @param row row
     * @param cell cell
     * @return result
     */
    @Override
    public String at(int row, int cell) {
        if (row >= rows.size() || cell >= rows.get(row).size()) {
            return "";
        }
        return rows.get(row).get(cell);
    }

    /**
     * Handles rows for this component.
     *
     * @return result
     */
    @Override
    public int rows() {
        return rows.size();
    }

    /**
     * Handles columns for this component.
     *
     * @return result
     */
    @Override
    public int columns() {
        return columns;
    }
}
