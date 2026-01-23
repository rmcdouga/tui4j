package com.williamcallahan.tui4j.compat.bubbles.table;

import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.ansi.Truncate;
import com.williamcallahan.tui4j.compat.bubbles.help.KeyMap;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Port of Bubbles table.
 * Bubble Tea: bubbles/table/table.go
 */
public class Table implements Model, KeyMap {

    private Keys keys;
    private Styles styles;
    private boolean focused;

    private List<Column> columns = new ArrayList<>();
    private List<Row> rows = new ArrayList<>();
    private int cursor = 0;

    private int width = 80;
    private int height = 20;
    private int start = 0;
    private int end = 0;

    /**
     * Creates a new table with default configuration.
     */
    public Table() {
        this.keys = Keys.defaultKeys();
        this.styles = Styles.defaultStyles();
        this.focused = false;
        updateViewport();
    }

    /**
     * Factory method to create a new table.
     *
     * @return new table instance
     */
    public static Table create() {
        return new Table();
    }

    /**
     * Sets the columns from a list.
     *
     * @param columns column definitions
     * @return this table
     */
    public Table columns(List<Column> columns) {
        this.columns = columns;
        updateViewport();
        return this;
    }

    /**
     * Sets the columns from varargs.
     *
     * @param columns column definitions
     * @return this table
     */
    public Table columns(Column... columns) {
        this.columns = List.of(columns);
        updateViewport();
        return this;
    }

    /**
     * Sets the rows from a list.
     *
     * @param rows row data
     * @return this table
     */
    public Table rows(List<Row> rows) {
        this.rows = rows;
        if (cursor > rows.size() - 1) {
            cursor = Math.max(0, rows.size() - 1);
        }
        updateViewport();
        return this;
    }

    /**
     * Sets the rows from varargs.
     *
     * @param rows row data
     * @return this table
     */
    public Table rows(Row... rows) {
        return rows(List.of(rows));
    }

    /**
     * Sets the table height.
     *
     * @param height height in lines
     * @return this table
     */
    public Table height(int height) {
        this.height = height;
        updateViewport();
        return this;
    }

    /**
     * Sets the table width.
     *
     * @param width width in cells
     * @return this table
     */
    public Table width(int width) {
        this.width = width;
        updateViewport();
        return this;
    }

    /**
     * Sets whether the table is focused.
     *
     * @param focused true if focused
     * @return this table
     */
    public Table focused(boolean focused) {
        this.focused = focused;
        updateViewport();
        return this;
    }

    /**
     * Sets the table styles.
     *
     * @param styles styles to set
     * @return this table
     */
    public Table styles(Styles styles) {
        this.styles = styles;
        updateViewport();
        return this;
    }

    /**
     * Sets the key bindings.
     *
     * @param keys key bindings to set
     * @return this table
     */
    public Table keyMap(Keys keys) {
        this.keys = keys;
        return this;
    }

    @Override
    public Command init() {
        return null;
    }

    @Override
    public UpdateResult<? extends Model> update(Message msg) {
        if (!focused) {
            return UpdateResult.from(this);
        }

        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (Binding.matches(keyPressMessage, keys.lineUp())) {
                moveUp(1);
            } else if (Binding.matches(keyPressMessage, keys.lineDown())) {
                moveDown(1);
            } else if (Binding.matches(keyPressMessage, keys.pageUp())) {
                moveUp(end - start);
            } else if (Binding.matches(keyPressMessage, keys.pageDown())) {
                moveDown(end - start);
            } else if (Binding.matches(keyPressMessage, keys.halfPageUp())) {
                moveUp((end - start) / 2);
            } else if (Binding.matches(keyPressMessage, keys.halfPageDown())) {
                moveDown((end - start) / 2);
            } else if (Binding.matches(keyPressMessage, keys.gotoTop())) {
                gotoTop();
            } else if (Binding.matches(keyPressMessage, keys.gotoBottom())) {
                gotoBottom();
            }
        }

        return UpdateResult.from(this);
    }

    @Override
    public String view() {
        String header = headersView();
        String content = contentView();

        List<String> lines = new ArrayList<>();
        String[] headerLines = header.split("\n", -1);
        for (String line : headerLines) {
            lines.add(line);
        }
        if (!content.isEmpty()) {
            String[] contentLines = content.split("\n", -1);
            for (String line : contentLines) {
                lines.add(line);
            }
        }

        int contentWidth = 0;
        for (String line : lines) {
            contentWidth = Math.max(
                contentWidth,
                TextWidth.measureCellWidth(line)
            );
        }
        int fillWidth = Math.min(width, contentWidth);

        int missingLines = height - lines.size();
        if (missingLines > 0) {
            String padding = " ".repeat(Math.max(0, fillWidth));
            for (int i = 0; i < missingLines; i++) {
                lines.add(padding);
            }
        }

        String result = String.join("\n", lines);
        if (columns.isEmpty() && rows.isEmpty()) {
            return result + "\n";
        }
        return result;
    }

    private String headersView() {
        List<String> headers = new ArrayList<>();
        for (Column col : columns) {
            if (col.width() <= 0) {
                continue;
            }
            String truncated = Truncate.truncate(col.title(), col.width(), "…");
            String rendered = Style.newStyle()
                .width(col.width())
                .inline(true)
                .render(truncated);
            headers.add(styles.header().render(rendered));
        }
        return joinHorizontal(headers.toArray(new String[0]));
    }

    private String contentView() {
        if (rows.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end && i < rows.size(); i++) {
            sb.append(renderRow(i));
            if (i < end - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private String renderRow(int rowIndex) {
        List<String> cells = new ArrayList<>();
        Row row = rows.get(rowIndex);

        for (int i = 0; i < columns.size(); i++) {
            Column col = columns.get(i);
            if (col.width() <= 0) {
                continue;
            }
            String cellValue = i < row.size() ? row.at(i) : "";
            String truncated = Truncate.truncate(cellValue, col.width(), "…");
            String rendered = Style.newStyle()
                .width(col.width())
                .inline(true)
                .render(truncated);
            cells.add(styles.cell().render(rendered));
        }

        String rowStr = joinHorizontal(cells.toArray(new String[0]));

        if (rowIndex == cursor) {
            return styles.selected().render(rowStr);
        }
        return rowStr;
    }

    private String joinHorizontal(String... parts) {
        if (parts.length == 0) {
            return "";
        }
        if (parts.length == 1) {
            return parts[0];
        }
        String[][] linesParts = new String[parts.length][];
        int maxLines = 0;
        for (int i = 0; i < parts.length; i++) {
            linesParts[i] = parts[i].split("\n", -1);
            maxLines = Math.max(maxLines, linesParts[i].length);
        }
        StringBuilder result = new StringBuilder();
        for (int line = 0; line < maxLines; line++) {
            if (line > 0) {
                result.append("\n");
            }
            for (int i = 0; i < parts.length; i++) {
                if (i > 0) {
                    result.append("");
                }
                if (line < linesParts[i].length) {
                    result.append(linesParts[i][line]);
                } else {
                    int w = TextWidth.measureCellWidth(parts[i]);
                    result.append(" ".repeat(Math.max(0, w)));
                }
            }
        }
        return result.toString();
    }

    private void updateViewport() {
        int viewportHeight = Math.max(0, height - headerHeight());

        if (cursor >= 0) {
            start = clamp(cursor - viewportHeight + 1, 0, cursor);
        } else {
            start = 0;
        }
        end = clamp(start + viewportHeight, start, rows.size());
    }

    private int clamp(int value, int low, int high) {
        return Math.max(low, Math.min(value, high));
    }

    /**
     * Returns the number of header lines rendered for the current columns and styles.
     *
     * @return header line count
     */
    private int headerHeight() {
        return Math.max(1, headersView().split("\n", -1).length);
    }

    /**
     * Returns whether the table is focused.
     *
     * @return true if focused
     */
    public boolean focused() {
        return focused;
    }

    /**
     * Focuses the table.
     */
    public void focus() {
        this.focused = true;
        updateViewport();
    }

    /**
     * Removes focus from the table.
     */
    public void blur() {
        this.focused = false;
        updateViewport();
    }

    /**
     * Returns the currently selected row.
     *
     * @return selected row, or null if no rows
     */
    public Row selectedRow() {
        if (cursor < 0 || cursor >= rows.size()) {
            return null;
        }
        return rows.get(cursor);
    }

    /**
     * Returns the row data.
     *
     * @return rows
     */
    public List<Row> getRows() {
        return rows;
    }

    /**
     * Returns the column definitions.
     *
     * @return columns
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * Sets the row data.
     *
     * @param rows rows to set
     */
    public void setRows(List<Row> rows) {
        this.rows = rows;
        if (cursor > rows.size() - 1) {
            cursor = Math.max(0, rows.size() - 1);
        }
        updateViewport();
    }

    /**
     * Sets the column definitions.
     *
     * @param columns columns to set
     */
    public void setColumns(List<Column> columns) {
        this.columns = columns;
        updateViewport();
    }

    /**
     * Sets the table width.
     *
     * @param width width in cells
     */
    public void setWidth(int width) {
        this.width = width;
        updateViewport();
    }

    /**
     * Sets the table height.
     *
     * @param height height in lines
     */
    public void setHeight(int height) {
        this.height = height;
        updateViewport();
    }

    /**
     * Returns the table height.
     *
     * @return height
     */
    public int height() {
        return height;
    }

    /**
     * Returns the table width.
     *
     * @return width
     */
    public int width() {
        return width;
    }

    /**
     * Returns the cursor position.
     *
     * @return cursor index
     */
    public int cursor() {
        return cursor;
    }

    /**
     * Sets the cursor position.
     *
     * @param cursor cursor index
     */
    public void setCursor(int cursor) {
        this.cursor = clamp(cursor, 0, Math.max(0, rows.size() - 1));
        updateViewport();
    }

    /**
     * Moves the cursor up by n rows.
     *
     * @param n number of rows to move
     */
    public void moveUp(int n) {
        cursor = clamp(cursor - n, 0, Math.max(0, rows.size() - 1));
        if (start == 0) {
            start = Math.max(0, Math.min(cursor, start));
        } else if (start < viewportHeight()) {
            start = clamp(start + n, 0, Math.min(cursor, viewportHeight()));
        } else if (start >= 1) {
            start = clamp(start + n, 1, viewportHeight());
        }
        updateViewport();
    }

    /**
     * Moves the cursor down by n rows.
     *
     * @param n number of rows to move
     */
    public void moveDown(int n) {
        cursor = clamp(cursor + n, 0, Math.max(0, rows.size() - 1));
        updateViewport();

        if (end == rows.size() && start > 0) {
            start = clamp(start - n, 1, viewportHeight());
        } else if (cursor > (end - start) / 2 && start > 0) {
            start = clamp(start - n, 1, cursor);
        } else if (start > 1) {
        } else if (cursor > start + viewportHeight() - 1) {
            start = clamp(start + 1, 0, 1);
        }
        updateViewport();
    }

    private int viewportHeight() {
        return Math.max(1, height - headerHeight());
    }

    /**
     * Moves the cursor to the first row.
     */
    public void gotoTop() {
        moveUp(cursor);
    }

    /**
     * Moves the cursor to the last row.
     */
    public void gotoBottom() {
        moveDown(rows.size());
    }

    /**
     * Populates the table from a delimited string.
     *
     * @param value text with rows separated by newlines
     * @param separator column delimiter
     */
    public void fromValues(String value, String separator) {
        List<Row> rows = new ArrayList<>();
        String[] lines = value.split("\n", -1);
        for (String line : lines) {
            String[] fields = line.split(Pattern.quote(separator), -1);
            rows.add(new Row(fields));
        }
        setRows(rows);
    }

    /**
     * Returns the table styles.
     *
     * @return styles
     */
    public Styles styles() {
        return styles;
    }

    /**
     * Returns the key bindings.
     *
     * @return key bindings
     */
    public Keys keyMap() {
        return keys;
    }

    @Override
    public Binding[] shortHelp() {
        return keys.shortHelp();
    }

    @Override
    public Binding[][] fullHelp() {
        return keys.fullHelp();
    }
}
