package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import java.util.Arrays;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Table} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: table/table.go.
 */
@Deprecated(since = "0.3.0")
@SuppressWarnings("removal")
public class Table extends com.williamcallahan.tui4j.compat.bubbles.table.Table {

    /**
     * Creates Table to keep this component ready for use.
     */
    public Table() {
        super();
    }

    /**
     * Creates Table to keep this component ready for use.
     *
     * @param rows rows
     */
    public Table(Row[] rows) {
        super();
        this.rows(Arrays.asList(rows));
    }

    /**
     * Creates Table to keep this component ready for use.
     *
     * @param rows rows
     * @param columns columns
     */
    public Table(Row[] rows, Column[] columns) {
        super();
        this.rows(Arrays.asList(rows));
        this.columns(Arrays.asList(columns));
    }

    /**
     * Creates Table to keep this component ready for use.
     *
     * @param rows rows
     * @param columns columns
     * @param styles styles
     */
    public Table(Row[] rows, Column[] columns, Styles styles) {
        super();
        this.rows(Arrays.asList(rows));
        this.columns(Arrays.asList(columns));
        this.styles(styles);
    }
}
