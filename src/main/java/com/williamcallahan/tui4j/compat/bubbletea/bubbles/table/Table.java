package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbles.help.KeyMap;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Table} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Table extends com.williamcallahan.tui4j.compat.bubbles.table.Table {

    @Deprecated(since = "0.3.0")
    public Table() {
        super();
    }

    @Deprecated(since = "0.3.0")
    public Table(Row[] rows) {
        super(rows);
    }

    @Deprecated(since = "0.3.0")
    public Table(Row[] rows, Column[] columns) {
        super(rows, columns);
    }

    @Deprecated(since = "0.3.0")
    public Table(Row[] rows, Column[] columns, Styles styles) {
        super(rows, columns, styles);
    }

}
