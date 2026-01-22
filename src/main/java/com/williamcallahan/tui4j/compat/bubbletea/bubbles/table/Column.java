package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Column} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: table/table.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Column {
    private final com.williamcallahan.tui4j.compat.bubbles.table.Column delegate;
    private final Style style;

    /**
     * Creates Column with title.
     *
     * @param title column title
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Column(String title) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Column(title);
        this.style = null;
    }

    /**
     * Creates Column with title and style.
     *
     * @param title column title
     * @param style column style (not supported in canonical, retained for compatibility)
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Column(String title, Style style) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Column(title);
        this.style = style;
    }

    /**
     * Creates Column with title and width.
     *
     * @param title column title
     * @param width column width
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Column(String title, int width) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Column(title, width);
        this.style = null;
    }

    /**
     * Creates Column with title, width, and style.
     *
     * @param title column title
     * @param width column width
     * @param style column style (not supported in canonical, retained for compatibility)
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Column(String title, int width, Style style) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Column(title, width);
        this.style = style;
    }

    /**
     * Returns the column title.
     *
     * @return column title
     */
    public String title() {
        return delegate.title();
    }

    /**
     * Returns the column width.
     *
     * @return column width
     */
    public int width() {
        return delegate.width();
    }

    /**
     * Returns the column style.
     *
     * @return column style (may be null)
     */
    public Style style() {
        return style;
    }

    /**
     * Returns the canonical delegate.
     *
     * @return canonical Column
     */
    public com.williamcallahan.tui4j.compat.bubbles.table.Column toCanonical() {
        return delegate;
    }
}
