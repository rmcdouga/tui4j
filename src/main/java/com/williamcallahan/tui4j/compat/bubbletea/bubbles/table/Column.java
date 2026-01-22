package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Column} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Column extends com.williamcallahan.tui4j.compat.bubbles.table.Column {

    @Deprecated(since = "0.3.0")
    public Column(String title) {
        super(title);
    }

    @Deprecated(since = "0.3.0")
    public Column(String title, Style style) {
        super(title, style);
    }

    @Deprecated(since = "0.3.0")
    public Column(String title, int width) {
        super(title, width);
    }

    @Deprecated(since = "0.3.0")
    public Column(String title, int width, Style style) {
        super(title, width, style);
    }

}
