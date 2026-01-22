package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Row} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Row extends com.williamcallahan.tui4j.compat.bubbles.table.Row {

    @Deprecated(since = "0.3.0")
    public Row(String... cells) {
        super(cells);
    }

    @Deprecated(since = "0.3.0")
    public Row(List<String> cells) {
        super(cells);
    }

}
