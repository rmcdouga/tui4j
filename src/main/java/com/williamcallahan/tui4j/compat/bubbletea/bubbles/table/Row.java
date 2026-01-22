package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Row} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: table/table.go.
 */
@Deprecated(since = "0.3.0")
public class Row extends com.williamcallahan.tui4j.compat.bubbles.table.Row {
    
    /**
     * Creates Row to keep this component ready for use.
     *
     * @param cells cells
     */
    public Row(String... cells) {
        super(cells);
    }

    /**
     * Creates Row to keep this component ready for use.
     *
     * @param cells cells
     */
    public Row(List<String> cells) {
        super(cells);
    }

    // Legacy method shim

    /**
     * Handles data for this component.
     *
     * @return result
     */
    public String[] data() {
        return cells().toArray(new String[0]);
    }

    // Legacy method shim
    /**
     * Handles get for this component.
     *
     * @param index index
     * @return result
     */
    public String get(int index) {
        return at(index);
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
     * Handles from strings for this component.
     *
     * @param strings strings
     * @return result
     */
    public static List<Row> fromStrings(String[][] strings) {
        List<Row> rows = new ArrayList<>();
        for (String[] stringArray : strings) {
            rows.add(new Row(stringArray));
        }
        return rows;
    }
}
