package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Row} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: table/table.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Row {
    private final com.williamcallahan.tui4j.compat.bubbles.table.Row delegate;

    /**
     * Creates Row with cells.
     *
     * @param cells row cell values
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Row(String... cells) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Row(cells);
    }

    /**
     * Creates Row with cells list.
     *
     * @param cells row cell values
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Row(List<String> cells) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Row(cells);
    }

    /**
     * Returns the row cells.
     *
     * @return cell values
     */
    public List<String> cells() {
        return delegate.cells();
    }

    /**
     * Returns the cell at the given index.
     *
     * @param index cell index
     * @return cell value or empty string if out of bounds
     */
    public String at(int index) {
        return delegate.at(index);
    }

    /**
     * Returns the number of cells.
     *
     * @return cell count
     */
    public int size() {
        return delegate.size();
    }

    /**
     * Returns cells as an array (legacy method).
     *
     * @return cell values array
     */
    public String[] data() {
        return cells().toArray(new String[0]);
    }

    /**
     * Returns the cell at the given index (legacy method).
     *
     * @param index cell index
     * @return cell value
     */
    public String get(int index) {
        return at(index);
    }

    /**
     * Creates a Row from string array.
     *
     * @param strings cell values
     * @return new Row
     */
    public static Row fromStrings(String[] strings) {
        return new Row(strings);
    }

    /**
     * Creates Rows from 2D string array.
     *
     * @param strings rows of cell values
     * @return list of Rows
     */
    public static List<Row> fromStrings(String[][] strings) {
        List<Row> rows = new ArrayList<>();
        for (String[] stringArray : strings) {
            rows.add(new Row(stringArray));
        }
        return rows;
    }

    /**
     * Returns the canonical delegate.
     *
     * @return canonical Row
     */
    public com.williamcallahan.tui4j.compat.bubbles.table.Row toCanonical() {
        return delegate;
    }
}
