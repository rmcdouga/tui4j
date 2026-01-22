package com.williamcallahan.tui4j.compat.lipgloss.table;

import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.ansi.Truncate;
import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import com.williamcallahan.tui4j.compat.lipgloss.Size;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.TextLines;
import com.williamcallahan.tui4j.compat.lipgloss.border.Border;

import java.util.ArrayList;
import java.util.List;

/**
 * Data table component.
 * <p>
 * Port of github.com/charmbracelet/lipgloss/table/table.go.
 * Renders structured data in a grid with customizable borders, headers, and cell styling.
 * <p>
 * Lipgloss: table/table.go.
 */
public class Table {

    public static final int HEADER_ROW = -1;

    private static final StyleFunc DEFAULT_STYLES = (row, col) -> Style.newStyle();

    private StyleFunc styleFunc = DEFAULT_STYLES;
    private Border border;

    private boolean borderTop = true;
    private boolean borderBottom = true;
    private boolean borderLeft = true;
    private boolean borderRight = true;
    private boolean borderHeader = true;
    private boolean borderColumn = true;
    private boolean borderRow = false;

    private Style borderStyle;
    private List<String> headers = new ArrayList<>();
    private Data data;

    private int width = 0;
    private int height = 0;
    private boolean useManualHeight = false;
    private int offset = 0;
    private boolean wrap = true;

    private int[] widths;
    private int[] heights;

    /**
     * Creates Table to keep this component ready for use.
     *
     * @param renderer renderer
     */
    public Table(Renderer renderer) {
        this.border = createDefaultBorder();
        this.borderStyle = Style.newStyle();
        this.data = new StringData();
    }

    /**
     * Creates default border for this component.
     *
     * @return result
     */
    private Border createDefaultBorder() {
        return new Border(
                " ", " ", " ", " ",
                " ", " ", " ", " ",
                " ", " ", " ", " ", " "
        );
    }

    /**
     * Creates a value for this component.
     *
     * @return result
     */
    public static Table create() {
        return new Table(Renderer.defaultRenderer());
    }

    /**
     * Handles style func for this component.
     *
     * @param styleFunc style func
     * @return result
     */
    public Table styleFunc(StyleFunc styleFunc) {
        this.styleFunc = styleFunc;
        return this;
    }

    /**
     * Handles style for this component.
     *
     * @param row row
     * @param col col
     * @return result
     */
    Style style(int row, int col) {
        if (styleFunc == null) {
            return Style.newStyle();
        }
        return styleFunc.apply(row, col);
    }

    /**
     * Handles data for this component.
     *
     * @param data data
     * @return result
     */
    public Table data(Data data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }
        this.data = data;
        return this;
    }

    /**
     * Handles rows for this component.
     *
     * @param rows rows
     * @return result
     */
    public Table rows(String[]... rows) {
        if (data instanceof StringData stringData) {
            for (String[] row : rows) {
                stringData.append(row);
            }
        }
        return this;
    }

    /**
     * Handles row for this component.
     *
     * @param row row
     * @return result
     */
    public Table row(String... row) {
        if (data instanceof StringData stringData) {
            stringData.append(row);
        }
        return this;
    }

    /**
     * Handles clear rows for this component.
     *
     * @return result
     */
    public Table clearRows() {
        if (data instanceof StringData stringData) {
            stringData.clear();
        } else {
            data = new StringData();
        }
        return this;
    }

    /**
     * Handles headers for this component.
     *
     * @param headers headers
     * @return result
     */
    public Table headers(String... headers) {
        for (String header : headers) {
            this.headers.add(header);
        }
        return this;
    }

    /**
     * Handles border for this component.
     *
     * @param border border
     * @return result
     */
    public Table border(Border border) {
        this.border = border;
        return this;
    }

    /**
     * Handles border top for this component.
     *
     * @param borderTop border top
     * @return result
     */
    public Table borderTop(boolean borderTop) {
        this.borderTop = borderTop;
        return this;
    }

    /**
     * Handles border bottom for this component.
     *
     * @param borderBottom border bottom
     * @return result
     */
    public Table borderBottom(boolean borderBottom) {
        this.borderBottom = borderBottom;
        return this;
    }

    /**
     * Handles border left for this component.
     *
     * @param borderLeft border left
     * @return result
     */
    public Table borderLeft(boolean borderLeft) {
        this.borderLeft = borderLeft;
        return this;
    }

    /**
     * Handles border right for this component.
     *
     * @param borderRight border right
     * @return result
     */
    public Table borderRight(boolean borderRight) {
        this.borderRight = borderRight;
        return this;
    }

    /**
     * Handles border header for this component.
     *
     * @param borderHeader border header
     * @return result
     */
    public Table borderHeader(boolean borderHeader) {
        this.borderHeader = borderHeader;
        return this;
    }

    /**
     * Handles border column for this component.
     *
     * @param borderColumn border column
     * @return result
     */
    public Table borderColumn(boolean borderColumn) {
        this.borderColumn = borderColumn;
        return this;
    }

    /**
     * Handles border row for this component.
     *
     * @param borderRow border row
     * @return result
     */
    public Table borderRow(boolean borderRow) {
        this.borderRow = borderRow;
        return this;
    }

    /**
     * Handles border style for this component.
     *
     * @param borderStyle border style
     * @return result
     */
    public Table borderStyle(Style borderStyle) {
        this.borderStyle = borderStyle;
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
        this.useManualHeight = true;
        return this;
    }

    /**
     * Handles offset for this component.
     *
     * @param offset offset
     * @return result
     */
    public Table offset(int offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Handles wrap for this component.
     *
     * @param wrap wrap
     * @return result
     */
    public Table wrap(boolean wrap) {
        this.wrap = wrap;
        return this;
    }

    /**
     * Renders the table to a string.
     * Computes dimensions, applies borders, and renders headers and rows.
     */
    public String render() {
        boolean hasHeaders = !headers.isEmpty();
        boolean hasRows = data != null && data.rows() > 0;

        if (!hasHeaders && !hasRows) {
            return "";
        }

        int dataColumns = data != null ? data.columns() : 0;
        if (hasHeaders) {
            while (headers.size() < dataColumns) {
                headers.add("");
            }
        }

        resize();

        StringBuilder sb = new StringBuilder();

        if (borderTop) {
            sb.append(constructTopBorder()).append("\n");
        }

        if (hasHeaders) {
            sb.append(constructHeaders()).append("\n");
        }

        String bottom = "";
        if (borderBottom) {
            bottom = constructBottomBorder();
        }

        if (hasRows) {
            if (useManualHeight) {
                int topHeight = Size.height(sb.toString()) - 1;
                int availableLines = height - (topHeight + Size.height(bottom));

                if (availableLines > data.rows()) {
                    availableLines = data.rows();
                }
                sb.append(constructRows(availableLines));
            } else {
                for (int r = offset; r < data.rows(); r++) {
                    sb.append(constructRow(r, false));
                }
            }
        }

        sb.append(bottom);

        return Style.newStyle()
                .height(height > 0 ? height : computeHeight())
                .width(width > 0 ? width : computeWidth())
                .render(sb.toString());
    }

    /**
     * Handles compute height for this component.
     *
     * @return result
     */
    private int computeHeight() {
        boolean hasHeaders = !headers.isEmpty();
        int sumHeights = 0;
        for (int h : heights) {
            sumHeights += h;
        }
        return sumHeights - 1 + boolToInt(hasHeaders) +
                boolToInt(borderTop) + boolToInt(borderBottom) +
                boolToInt(borderHeader) + data.rows() * boolToInt(borderRow);
    }

    /**
     * Handles compute width for this component.
     *
     * @return result
     */
    private int computeWidth() {
        int totalWidth = 0;
        for (int w : widths) {
            totalWidth += w;
        }
        if (borderLeft) {
            totalWidth += border.getLeftSize();
        }
        if (borderRight) {
            totalWidth += border.getRightSize();
        }
        if (borderColumn && widths.length > 1) {
            totalWidth += (widths.length - 1) * border.getLeftSize();
        }
        return totalWidth;
    }

    /**
     * Handles bool to int for this component.
     *
     * @param b b
     * @return result
     */
    private int boolToInt(boolean b) {
        return b ? 1 : 0;
    }

    /**
     * Handles construct top border for this component.
     *
     * @return result
     */
    private String constructTopBorder() {
        StringBuilder s = new StringBuilder();
        if (borderLeft) {
            s.append(borderStyle.render(border.topLeft()));
        }
        for (int i = 0; i < widths.length; i++) {
            s.append(borderStyle.render(border.top().repeat(widths[i])));
            if (i < widths.length - 1 && borderColumn) {
                s.append(borderStyle.render(border.middleTop()));
            }
        }
        if (borderRight) {
            s.append(borderStyle.render(border.topRight()));
        }
        return s.toString();
    }

    /**
     * Handles construct bottom border for this component.
     *
     * @return result
     */
    private String constructBottomBorder() {
        StringBuilder s = new StringBuilder();
        if (borderLeft) {
            s.append(borderStyle.render(border.bottomLeft()));
        }
        for (int i = 0; i < widths.length; i++) {
            s.append(borderStyle.render(border.bottom().repeat(widths[i])));
            if (i < widths.length - 1 && borderColumn) {
                s.append(borderStyle.render(border.middleBottom()));
            }
        }
        if (borderRight) {
            s.append(borderStyle.render(border.bottomRight()));
        }
        return s.toString();
    }

    /**
     * Handles construct headers for this component.
     *
     * @return result
     */
    private String constructHeaders() {
        int headerHeight = heights[0];

        StringBuilder s = new StringBuilder();
        if (borderLeft) {
            s.append(borderStyle.render(border.left()));
        }
        for (int i = 0; i < headers.size(); i++) {
            String header = headers.get(i);
            Style cellStyle = style(HEADER_ROW, i);

            if (!wrap) {
                header = truncateCell(header, HEADER_ROW, i);
            }

            int cellWidth = widths[i] - cellStyle.getHorizontalMargins() - cellStyle.getHorizontalBorderSize();
            s.append(cellStyle
                    .height(headerHeight - cellStyle.getVerticalMargins())
                    .width(cellWidth)
                    .render(header));
            if (i < headers.size() - 1 && borderColumn) {
                s.append(borderStyle.render(border.left()));
            }
        }
        if (borderHeader) {
            if (borderRight) {
                s.append(borderStyle.render(border.right()));
            }
            s.append("\n");
            if (borderLeft) {
                s.append(borderStyle.render(border.middleLeft()));
            }
            for (int i = 0; i < headers.size(); i++) {
                s.append(borderStyle.render(border.top().repeat(widths[i])));
                if (i < headers.size() - 1 && borderColumn) {
                    s.append(borderStyle.render(border.middle()));
                }
            }
            if (borderRight) {
                s.append(borderStyle.render(border.middleRight()));
            }
        }
        if (borderRight && !borderHeader) {
            s.append(borderStyle.render(border.right()));
        }
        return s.toString();
    }

    /**
     * Handles construct rows for this component.
     *
     * @param availableLines available lines
     * @return result
     */
    private String constructRows(int availableLines) {
        StringBuilder sb = new StringBuilder();

        int offsetRowCount = data.rows() - offset;

        int rowsToRender = Math.max(availableLines, 1);

        boolean needsOverflow = rowsToRender < offsetRowCount;

        int rowIdx = offset;
        if (!needsOverflow) {
            rowIdx = Math.max(0, data.rows() - rowsToRender);
        }
        while (rowsToRender > 0 && rowIdx < data.rows()) {
            boolean isOverflow = needsOverflow && rowsToRender == 1;

            sb.append(constructRow(rowIdx, isOverflow));

            rowIdx++;
            rowsToRender--;
        }
        return sb.toString();
    }

    /**
     * Handles construct row for this component.
     *
     * @param index index
     * @param isOverflow is overflow
     * @return result
     */
    private String constructRow(int index, boolean isOverflow) {
        StringBuilder s = new StringBuilder();

        boolean hasHeaders = !headers.isEmpty();
        int rowHeight = heights[index + boolToInt(hasHeaders)];
        if (isOverflow) {
            rowHeight = 1;
        }

        List<String> cells = new ArrayList<>();
        String leftBorder = (borderStyle.render(border.left()) + "\n").repeat(rowHeight);
        if (borderLeft) {
            cells.add(leftBorder);
        }

        int numCols = data != null ? data.columns() : 0;
        for (int c = 0; c < numCols; c++) {
            String cell = isOverflow ? "…" : data.at(index, c);
            Style cellStyle = style(index, c);

            if (!wrap) {
                cell = truncateCell(cell, index, c);
            }

            int cellWidth = c < widths.length ? widths[c] : 0;
            int renderWidth = Math.max(0, cellWidth - cellStyle.getHorizontalMargins() - cellStyle.getHorizontalBorderSize());
            String renderedCell = cellStyle
                    .height(rowHeight - cellStyle.getVerticalMargins())
                    .width(renderWidth)
                    .render(cell);
            cells.add(renderedCell);

            if (c < numCols - 1 && borderColumn) {
                cells.add(leftBorder);
            }
        }

        if (borderRight) {
            String rightBorder = (borderStyle.render(border.right()) + "\n").repeat(rowHeight);
            cells.add(rightBorder);
        }

        for (int i = 0; i < cells.size(); i++) {
            cells.set(i, cells.get(i).replaceAll("\n$", ""));
        }

        s.append(joinHorizontal(cells.toArray(new String[0]))).append("\n");

        if (borderRow && data != null && index < data.rows() - 1 && !isOverflow) {
            if (borderLeft) {
                s.append(borderStyle.render(border.middleLeft()));
            }
            for (int i = 0; i < widths.length; i++) {
                s.append(borderStyle.render(border.bottom().repeat(widths[i])));
                if (i < widths.length - 1 && borderColumn) {
                    s.append(borderStyle.render(border.middle()));
                }
            }
            if (borderRight) {
                s.append(borderStyle.render(border.middleRight()));
            }
            s.append("\n");
        }

        return s.toString();
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
        StringBuilder result = new StringBuilder();
        int maxLines = 0;
        String[][] linesParts = new String[parts.length][];
        for (int i = 0; i < parts.length; i++) {
            linesParts[i] = parts[i].split("\n");
            maxLines = Math.max(maxLines, linesParts[i].length);
        }
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
                    int width = TextWidth.measureCellWidth(parts[i].split("\n")[0]);
                    result.append(" ".repeat(width));
                }
            }
        }
        return result.toString();
    }

    /**
     * Handles truncate cell for this component.
     *
     * @param cell cell
     * @param rowIndex row index
     * @param colIndex col index
     * @return result
     */
    private String truncateCell(String cell, int rowIndex, int colIndex) {
        boolean hasHeaders = !headers.isEmpty();
        int rowHeight = heights[rowIndex + boolToInt(hasHeaders)];
        int cellWidth = widths[colIndex];
        Style cellStyle = style(rowIndex, colIndex);

        int length = (cellWidth * rowHeight) - cellStyle.getHorizontalPadding() - cellStyle.getHorizontalMargins();
        return Truncate.truncate(cell, length, "…");
    }

    /**
     * Handles resize for this component.
     */
    private void resize() {
        int numCols = Math.max(headers.size(), data != null ? data.columns() : 0);
        calculateWidths(numCols);
        calculateHeights(numCols);
        adjustWidthsForConstraint(numCols);
    }

    /**
     * Handles calculate widths for this component.
     *
     * @param numCols num cols
     */
    private void calculateWidths(int numCols) {
        widths = new int[numCols];
        for (int c = 0; c < numCols; c++) {
            int maxWidth = 0;
            for (int r = 0; r < data.rows(); r++) {
                String cell = data.at(r, c);
                Style style = style(r, c);
                int effectiveWidth;
                if (style.getWidth() > 0) {
                    effectiveWidth = style.getWidth() + style.getHorizontalBorderSize();
                } else {
                    effectiveWidth = TextWidth.measureCellWidth(cell) + style.getHorizontalFrameSize();
                }
                maxWidth = Math.max(maxWidth, effectiveWidth);
            }
            if (c < headers.size()) {
                String header = headers.get(c);
                Style style = style(HEADER_ROW, c);
                int effectiveWidth;
                if (style.getWidth() > 0) {
                    effectiveWidth = style.getWidth() + style.getHorizontalBorderSize();
                } else {
                    effectiveWidth = TextWidth.measureCellWidth(header) + style.getHorizontalFrameSize();
                }
                maxWidth = Math.max(maxWidth, effectiveWidth);
            }
            widths[c] = maxWidth;
        }
    }

    /**
     * Handles calculate heights for this component.
     *
     * @param numCols num cols
     */
    private void calculateHeights(int numCols) {
        heights = new int[data.rows() + boolToInt(!headers.isEmpty())];
        for (int r = 0; r < data.rows(); r++) {
            int maxHeight = 1;
            for (int c = 0; c < numCols; c++) {
                String cell = data.at(r, c);
                int cellWidth = widths[c];
                Style style = style(r, c);
                int availableWidth = cellWidth - style.getHorizontalFrameSize();

                if (availableWidth > 0 && wrap) {
                    TextLines lines = TextLines.fromText(cell);
                    for (String line : lines.lines()) {
                        int numLines = (int) Math.ceil((double) TextWidth.measureCellWidth(line) / availableWidth);
                        maxHeight = Math.max(maxHeight, numLines);
                    }
                }
            }
            heights[r + boolToInt(!headers.isEmpty())] = maxHeight;
        }

        if (!headers.isEmpty()) {
            int headerHeight = 1;
            for (int c = 0; c < headers.size(); c++) {
                String header = headers.get(c);
                int headerWidth = widths[c];
                Style style = style(HEADER_ROW, c);
                int availableWidth = headerWidth - style.getHorizontalFrameSize();

                if (availableWidth > 0 && wrap) {
                    TextLines lines = TextLines.fromText(header);
                    for (String line : lines.lines()) {
                        int numLines = (int) Math.ceil((double) TextWidth.measureCellWidth(line) / availableWidth);
                        headerHeight = Math.max(headerHeight, numLines);
                    }
                }
            }
            heights[0] = headerHeight;
        }
    }

    /**
     * Handles adjust widths for constraint for this component.
     *
     * @param numCols num cols
     */
    private void adjustWidthsForConstraint(int numCols) {
        if (width > 0) {
            int availableWidth = width;
            if (borderLeft) {
                availableWidth -= border.getLeftSize();
            }
            if (borderRight) {
                availableWidth -= border.getRightSize();
            }
            if (borderColumn && numCols > 1) {
                availableWidth -= (numCols - 1) * border.getLeftSize();
            }

            int totalContentWidth = 0;
            for (int w : widths) {
                totalContentWidth += w;
            }

            if (totalContentWidth < availableWidth) {
                int extraWidth = availableWidth - totalContentWidth;
                int numExpandable = widths.length;
                if (numExpandable > 0) {
                    for (int i = 0; i < widths.length; i++) {
                        int add = extraWidth / numExpandable;
                        widths[i] += add;
                        extraWidth -= add;
                    }
                }
            } else if (totalContentWidth > availableWidth) {
                int overflow = totalContentWidth - availableWidth;
                for (int i = widths.length - 1; i >= 0 && overflow > 0; i--) {
                    int reduce = Math.min(widths[i] - 1, overflow);
                    widths[i] -= reduce;
                    overflow -= reduce;
                }
            }
        }
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return render();
    }
}
