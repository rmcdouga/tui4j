package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.table;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.table.Data}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: table/rows.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Data implements com.williamcallahan.tui4j.compat.lipgloss.table.Data {
    private final String[] headers;
    private final String[][] rows;

    /**
     * Creates a data set from headers and rows.
     *
     * @param headers header labels
     * @param rows    row data
     */
    public Data(String[] headers, String[][] rows) {
        this.headers = headers;
        this.rows = rows;
    }

    /**
     * Creates a data set from array inputs.
     *
     * @param headers header labels
     * @param rows    row data
     * @return data set
     */
    public static Data fromArrays(String[] headers, String[][] rows) {
        return new Data(headers, rows);
    }

    /**
     * Creates a data set from string array rows.
     *
     * @param headers header labels
     * @param rows    row data
     * @return data set
     */
    public static Data fromStringArrays(String[] headers, List<String[]> rows) {
        return new Data(headers, rows.toArray(new String[0][]));
    }

    /**
     * Creates a data set from list rows.
     *
     * @param headers header labels
     * @param rows    row data
     * @return data set
     */
    public static Data fromLists(List<String> headers, List<List<String>> rows) {
        List<String[]> rowArrays = new ArrayList<>();
        for (List<String> row : rows) {
            rowArrays.add(row.toArray(new String[0]));
        }
        return new Data(headers.toArray(new String[0]), rowArrays.toArray(new String[0][]));
    }

    /**
     * Returns the header labels.
     *
     * @return header labels
     */
    public String[] headers() {
        return headers;
    }

    /**
     * Returns all row data.
     *
     * @return row data
     */
    public String[][] getRows() {
        return rows;
    }

    /**
     * Returns the cell content at the requested coordinates.
     *
     * @param row  row index
     * @param cell cell index
     * @return cell contents
     */
    @Override
    public String at(int row, int cell) {
        if (row < 0 || row >= rows.length || cell < 0 || cell >= rows[row].length) {
            return "";
        }
        return rows[row][cell];
    }

    /**
     * Returns the number of rows.
     *
     * @return row count
     */
    @Override
    public int rows() {
        return rows.length;
    }

    /**
     * Returns the number of columns.
     *
     * @return column count
     */
    @Override
    public int columns() {
        if (headers != null && headers.length > 0) return headers.length;
        if (rows.length > 0) return rows[0].length;
        return 0;
    }
}
