package com.williamcallahan.tui4j.compat.bubbles.table;

import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.ansi.Truncate;
import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbles.help.KeyMap;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Port of Bubbles table.
 * Bubble Tea: bubbles/table/table.go
 * <p>
 * Bubbles: table/table.go.
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
     * Creates Table to keep this component ready for use.
     */
    public Table() {
        this.keys = Keys.defaultKeys();
        this.styles = Styles.defaultStyles();
        this.focused = false;
        updateViewport();
    }

    /**
     * Creates a value for this component.
     *
     * @return result
     */
    public static Table create() {
        return new Table();
    }

    /**
     * Handles columns for this component.
     *
     * @param columns columns
     * @return result
     */
    public Table columns(List<Column> columns) {
        this.columns = columns;
        updateViewport();
        return this;
    }

    /**
     * Handles columns for this component.
     *
     * @param columns columns
     * @return result
     */
    public Table columns(Column... columns) {
        this.columns = List.of(columns);
        updateViewport();
        return this;
    }

    /**
     * Handles rows for this component.
     *
     * @param rows rows
     * @return result
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
     * Handles rows for this component.
     *
     * @param rows rows
     * @return result
     */
    public Table rows(Row... rows) {
        this.rows = List.of(rows);
        if (cursor > this.rows.size() - 1) {
            cursor = Math.max(0, this.rows.size() - 1);
        }
        updateViewport();
        return this;
    }

    /**
     * Handles height for this component.
     *
     * @param height height
     * @return result
     */
    public Table height(int height) {
        this.height = height;
        updateViewport();
        return this;
    }

    /**
     * Handles width for this component.
     *
     * @param width width
     * @return result
     */
    public Table width(int width) {
        this.width = width;
        updateViewport();
        return this;
    }

    /**
     * Handles focused for this component.
     *
     * @param focused focused
     * @return result
     */
    public Table focused(boolean focused) {
        this.focused = focused;
        updateViewport();
        return this;
    }

    /**
     * Handles styles for this component.
     *
     * @param styles styles
     * @return result
     */
    public Table styles(Styles styles) {
        this.styles = styles;
        updateViewport();
        return this;
    }

    /**
     * Handles key map for this component.
     *
     * @param keys keys
     * @return result
     */
    public Table keyMap(Keys keys) {
        this.keys = keys;
        return this;
    }

    /**
     * Supplies the initial command for the model.
     *
     * @return initial command
     */
    @Override
    public Command init() {
        return null;
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg msg
     * @return next model state and command
     */
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

    /**
     * Renders the model view for display.
     *
     * @return rendered view
     */
    @Override
    public String view() {
        StringBuilder sb = new StringBuilder();
        String headerLine = headersView();
        
        int headerLineCount = 0;
        if (!headerLine.isEmpty()) {
            sb.append(headerLine).append("\n");
            headerLineCount = headerLine.split("\n", -1).length;
        }
        
        String content = contentView();
        sb.append(content);
        
        int contentLines = content.isEmpty() ? 0 : content.split("\n", -1).length;
        int totalRendered = headerLineCount + contentLines;
        
        // Pad to fill exactly height lines
        int tableWidth = calculateTableWidth();
        String paddingLine = " ".repeat(Math.max(0, tableWidth));
        
        // For empty table, output just newlines to fill height
        if (headerLine.isEmpty() && content.isEmpty()) {
            sb.append("\n".repeat(height));
        } else {
            // Add padding lines to reach height total lines
            for (int i = totalRendered; i < height; i++) {
                sb.append("\n").append(paddingLine);
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Handles calculate table width for this component.
     *
     * @return result
     */
    private int calculateTableWidth() {
        // Calculate width from actual rendered header (accounts for styling)
        String header = headersView();
        if (!header.isEmpty()) {
            String[] lines = header.split("\n");
            int maxWidth = 0;
            for (String line : lines) {
                int lineWidth = TextWidth.measureCellWidth(line);
                maxWidth = Math.max(maxWidth, lineWidth);
            }
            return maxWidth;
        }
        return 0;
    }

    /**
     * Handles headers view for this component.
     *
     * @return result
     */
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

    /**
     * Handles content view for this component.
     *
     * @return result
     */
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

    /**
     * Handles render row for this component.
     *
     * @param rowIndex row index
     * @return result
     */
    private String renderRow(int rowIndex) {
        List<String> cells = new ArrayList<>();
        Row row = rows.get(rowIndex);

        for (int i = 0; i < columns.size() && i < row.size(); i++) {
            Column col = columns.get(i);
            if (col.width() <= 0) {
                continue;
            }
            String cellValue = row.at(i);
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

    /**
     * Handles join horizontal for this component.
     *
     * @param parts parts
     * @return result
     */
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
            linesParts[i] = parts[i].split("\n");
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

    /**
     * Handles update viewport for this component.
     */
    private void updateViewport() {
        int headerLineCount = headersView().split("\n").length;
        if (headersView().isEmpty()) {
            headerLineCount = 0;
        }
        int viewportHeight = Math.max(0, height - headerLineCount);

        if (cursor >= 0) {
            start = clamp(cursor - viewportHeight + 1, 0, cursor);
        } else {
            start = 0;
        }
        end = Math.min(start + viewportHeight, rows.size());
    }

    /**
     * Handles clamp for this component.
     *
     * @param value value
     * @param low low
     * @param high high
     * @return result
     */
    private int clamp(int value, int low, int high) {
        return Math.max(low, Math.min(value, high));
    }

    /**
     * Handles focused for this component.
     *
     * @return whether cused
     */
    public boolean focused() {
        return focused;
    }

    /**
     * Handles focus for this component.
     */
    public void focus() {
        this.focused = true;
        updateViewport();
    }

    /**
     * Handles blur for this component.
     */
    public void blur() {
        this.focused = false;
        updateViewport();
    }

    /**
     * Handles selected row for this component.
     *
     * @return result
     */
    public Row selectedRow() {
        if (cursor < 0 || cursor >= rows.size()) {
            return null;
        }
        return rows.get(cursor);
    }

    /**
     * Returns the rows.
     *
     * @return result
     */
    public List<Row> getRows() {
        return rows;
    }

    /**
     * Returns the columns.
     *
     * @return result
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * Updates the rows.
     *
     * @param rows rows
     */
    public void setRows(List<Row> rows) {
        this.rows = rows;
        if (cursor > rows.size() - 1) {
            cursor = Math.max(0, rows.size() - 1);
        }
        updateViewport();
    }

    /**
     * Updates the columns.
     *
     * @param columns columns
     */
    public void setColumns(List<Column> columns) {
        this.columns = columns;
        updateViewport();
    }

    /**
     * Updates the width.
     *
     * @param width width
     */
    public void setWidth(int width) {
        this.width = width;
        updateViewport();
    }

    /**
     * Updates the height.
     *
     * @param height height
     */
    public void setHeight(int height) {
        this.height = height;
        updateViewport();
    }

    /**
     * Handles height for this component.
     *
     * @return result
     */
    public int height() {
        return height;
    }

    /**
     * Handles width for this component.
     *
     * @return result
     */
    public int width() {
        return width;
    }

    /**
     * Handles cursor for this component.
     *
     * @return result
     */
    public int cursor() {
        return cursor;
    }

    /**
     * Updates the cursor.
     *
     * @param cursor cursor
     */
    public void setCursor(int cursor) {
        this.cursor = clamp(cursor, 0, Math.max(0, rows.size() - 1));
        updateViewport();
    }

    /**
     * Handles move up for this component.
     *
     * @param n n
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
     * Handles move down for this component.
     *
     * @param n n
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

    /**
     * Handles viewport height for this component.
     *
     * @return result
     */
    private int viewportHeight() {
        return Math.max(1, height - 1);
    }

    /**
     * Handles goto top for this component.
     */
    public void gotoTop() {
        moveUp(cursor);
    }

    /**
     * Handles goto bottom for this component.
     */
    public void gotoBottom() {
        moveDown(rows.size());
    }

    /**
     * Handles from values for this component.
     *
     * @param value value
     * @param separator separator
     */
    public void fromValues(String value, String separator) {
        List<Row> rows = new ArrayList<>();
        String[] lines = value.split("\n");
        for (String line : lines) {
            String[] fields = line.split(separator);
            rows.add(new Row(fields));
        }
        setRows(rows);
    }

    /**
     * Handles styles for this component.
     *
     * @return result
     */
    public Styles styles() {
        return styles;
    }

    /**
     * Handles key map for this component.
     *
     * @return result
     */
    public Keys keyMap() {
        return keys;
    }

    /**
     * Handles short help for this component.
     *
     * @return result
     */
    @Override
    public Binding[] shortHelp() {
        return keys.shortHelp();
    }

    /**
     * Handles full help for this component.
     *
     * @return result
     */
    @Override
    public Binding[][] fullHelp() {
        return keys.fullHelp();
    }
}
