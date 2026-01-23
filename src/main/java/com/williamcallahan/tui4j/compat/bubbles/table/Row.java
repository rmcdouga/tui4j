package com.williamcallahan.tui4j.compat.bubbles.table;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Port of Bubbles table Row.
 * Bubble Tea: bubbles/table/table.go
 */
public class Row {

    private final List<String> cells;

    /**
     * Creates a row from a list of cell values.
     *
     * @param cells row cell values
     */
    public Row(List<String> cells) {
        this.cells = cells != null ? List.copyOf(cells) : Collections.emptyList();
    }

    /**
     * Creates a row from varargs cell values.
     *
     * @param cells row cell values
     */
    public Row(String... cells) {
        this(Arrays.asList(cells));
    }

    /**
     * Returns the cell values.
     *
     * @return cell values
     */
    public List<String> cells() {
        return cells;
    }

    /**
     * Returns the cell value at the given index.
     *
     * @param index cell index
     * @return cell value or empty string if out of bounds
     */
    public String at(int index) {
        if (index < 0 || index >= cells.size()) {
            return "";
        }
        return cells.get(index);
    }

    /**
     * Returns the number of cells.
     *
     * @return cell count
     */
    public int size() {
        return cells.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Row row)) return false;
        return java.util.Objects.equals(cells, row.cells);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(cells);
    }

    @Override
    public String toString() {
        return "Row[cells=" + cells + "]";
    }
}
