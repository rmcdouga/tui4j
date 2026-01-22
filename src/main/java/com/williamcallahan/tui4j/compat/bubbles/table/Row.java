package com.williamcallahan.tui4j.compat.bubbles.table;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Port of Bubbles table Row.
 * Bubble Tea: bubbles/table/table.go
 * <p>
 * Bubbles: table/table.go.
 */
public class Row {
    private final List<String> cells;

    /**
     * Creates Row to keep this component ready for use.
     *
     * @param cells cells
     */
    public Row(List<String> cells) {
        this.cells = cells;
    }

    /**
     * Creates Row to keep this component ready for use.
     *
     * @param cells cells
     */
    public Row(String... cells) {
        this(Arrays.asList(cells));
    }

    /**
     * Handles cells for this component.
     *
     * @return result
     */
    public List<String> cells() {
        return cells;
    }

    /**
     * Handles at for this component.
     *
     * @param index index
     * @return result
     */
    public String at(int index) {
        if (index < 0 || index >= cells.size()) {
            return "";
        }
        return cells.get(index);
    }

    /**
     * Handles size for this component.
     *
     * @return result
     */
    public int size() {
        return cells.size();
    }

    /**
     * Handles from strings for this component.
     *
     * @param strings strings
     * @return result
     */
    public static Row fromStrings(String[] strings) {
        return new Row(strings);
    }

    /**
     * Handles equals for this component.
     *
     * @param o o
     * @return whether uals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(cells, row.cells);
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(cells);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "Row[cells=" + cells + "]";
    }
}
