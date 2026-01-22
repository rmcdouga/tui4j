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
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Table} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: table/table.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
@SuppressWarnings("removal")
public class Table implements Model, KeyMap {
    private final com.williamcallahan.tui4j.compat.bubbles.table.Table delegate;

    /**
     * Creates Table.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Table() {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Table();
    }

    /**
     * Creates Table with rows.
     *
     * @param rows table rows
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Table(Row[] rows) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Table();
        this.delegate.rows(toCanonicalRows(Arrays.asList(rows)));
    }

    /**
     * Creates Table with rows and columns.
     *
     * @param rows table rows
     * @param columns table columns
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Table(Row[] rows, Column[] columns) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Table();
        this.delegate.rows(toCanonicalRows(Arrays.asList(rows)));
        this.delegate.columns(toCanonicalColumns(Arrays.asList(columns)));
    }

    /**
     * Creates Table with rows, columns, and styles.
     *
     * @param rows table rows
     * @param columns table columns
     * @param styles table styles
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Table(Row[] rows, Column[] columns, Styles styles) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.table.Table();
        this.delegate.rows(toCanonicalRows(Arrays.asList(rows)));
        this.delegate.columns(toCanonicalColumns(Arrays.asList(columns)));
        this.delegate.styles(styles);
    }

    /**
     * Sets table rows from deprecated Row type.
     *
     * @param rows table rows
     * @return this table
     */
    public Table rows(List<Row> rows) {
        delegate.rows(toCanonicalRows(rows));
        return this;
    }

    /**
     * Sets table rows from deprecated Row array.
     *
     * @param rows table rows
     * @return this table
     */
    public Table rows(Row... rows) {
        delegate.rows(toCanonicalRows(Arrays.asList(rows)));
        return this;
    }

    /**
     * Sets table columns from deprecated Column type.
     *
     * @param columns table columns
     * @return this table
     */
    public Table columns(List<Column> columns) {
        delegate.columns(toCanonicalColumns(columns));
        return this;
    }

    /**
     * Sets table columns from deprecated Column array.
     *
     * @param columns table columns
     * @return this table
     */
    public Table columns(Column... columns) {
        delegate.columns(toCanonicalColumns(Arrays.asList(columns)));
        return this;
    }

    /**
     * Sets table height.
     *
     * @param height height
     * @return this table
     */
    public Table height(int height) {
        delegate.height(height);
        return this;
    }

    /**
     * Sets table width.
     *
     * @param width width
     * @return this table
     */
    public Table width(int width) {
        delegate.width(width);
        return this;
    }

    /**
     * Sets focus state.
     *
     * @param focused focus state
     * @return this table
     */
    public Table focused(boolean focused) {
        delegate.focused(focused);
        return this;
    }

    /**
     * Sets table styles.
     *
     * @param styles styles
     * @return this table
     */
    public Table styles(Styles styles) {
        delegate.styles(styles);
        return this;
    }

    @Override
    public Command init() {
        return delegate.init();
    }

    @Override
    public UpdateResult<? extends Model> update(Message msg) {
        return delegate.update(msg);
    }

    @Override
    public String view() {
        return delegate.view();
    }

    public boolean focused() {
        return delegate.focused();
    }

    public void focus() {
        delegate.focus();
    }

    public void blur() {
        delegate.blur();
    }

    public com.williamcallahan.tui4j.compat.bubbles.table.Row selectedRow() {
        return delegate.selectedRow();
    }

    public List<com.williamcallahan.tui4j.compat.bubbles.table.Row> getRows() {
        return delegate.getRows();
    }

    public List<com.williamcallahan.tui4j.compat.bubbles.table.Column> getColumns() {
        return delegate.getColumns();
    }

    public int height() {
        return delegate.height();
    }

    public int width() {
        return delegate.width();
    }

    public int cursor() {
        return delegate.cursor();
    }

    public void setCursor(int cursor) {
        delegate.setCursor(cursor);
    }

    public void moveUp(int n) {
        delegate.moveUp(n);
    }

    public void moveDown(int n) {
        delegate.moveDown(n);
    }

    public void gotoTop() {
        delegate.gotoTop();
    }

    public void gotoBottom() {
        delegate.gotoBottom();
    }

    public com.williamcallahan.tui4j.compat.bubbles.table.Styles styles() {
        return delegate.styles();
    }

    public com.williamcallahan.tui4j.compat.bubbles.table.Keys keyMap() {
        return delegate.keyMap();
    }

    @Override
    public Binding[] shortHelp() {
        return delegate.shortHelp();
    }

    @Override
    public Binding[][] fullHelp() {
        return delegate.fullHelp();
    }

    /**
     * Returns the canonical delegate.
     *
     * @return canonical Table
     */
    public com.williamcallahan.tui4j.compat.bubbles.table.Table toCanonical() {
        return delegate;
    }

    private static List<com.williamcallahan.tui4j.compat.bubbles.table.Row> toCanonicalRows(List<Row> rows) {
        List<com.williamcallahan.tui4j.compat.bubbles.table.Row> canonical = new ArrayList<>(rows.size());
        for (Row row : rows) {
            canonical.add(row.toCanonical());
        }
        return canonical;
    }

    private static List<com.williamcallahan.tui4j.compat.bubbles.table.Column> toCanonicalColumns(List<Column> columns) {
        List<com.williamcallahan.tui4j.compat.bubbles.table.Column> canonical = new ArrayList<>(columns.size());
        for (Column col : columns) {
            canonical.add(col.toCanonical());
        }
        return canonical;
    }
}
