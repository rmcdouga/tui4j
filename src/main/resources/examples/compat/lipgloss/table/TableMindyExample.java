package com.williamcallahan.tui4j.examples.compat.lipgloss.table;

import com.williamcallahan.tui4j.compat.lipgloss.Table;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Example program demonstrating lipgloss table with color swatches.
 * <p>
 * Creates a large table showing color swatches organized by rows with alternating
 * label/swatch layout.
 *
 * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/examples/table/mindy/main.go">lipgloss/examples/table</a>
 */
public class TableMindyExample {

    private static final int ROW_LENGTH = 12;

    /**
     * Builds a row of label/swatch pairs for a contiguous color range.
     *
     * @param start first color code to include
     * @param end last color code to include
     * @return row data for the table
     */
    private static List<String[]> makeRow(int start, int end) {
        List<String[]> row = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            row.add(String.valueOf(i));
            row.add("");
        }
        for (int i = row.size(); i < ROW_LENGTH; i++) {
            row.add("");
        }
        return row;
    }

    /**
     * Creates an empty spacer row to separate color groups.
     *
     * @return spacer row data
     */
    private static List<String[]> makeEmptyRow() {
        return makeRow(0, -1);
    }

    /**
     * Runs the example to render a palette grid with labeled color swatches.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Style labelStyle = Style.newStyle().width(3).alignHorizontal(Style.Align.RIGHT);
        Style swatchStyle = Style.newStyle().width(6);

        List<String[]> data = new ArrayList<>();

        for (int i = 0; i < 13; i += 8) {
            data.addAll(makeRow(i, i + 5));
        }
        data.add(makeEmptyRow());

        for (int i = 6; i < 15; i += 8) {
            data.addAll(makeRow(i, i + 1));
        }
        data.add(makeEmptyRow());

        for (int i = 16; i < 231; i += 6) {
            data.addAll(makeRow(i, i + 5));
        }
        data.add(makeEmptyRow());

        for (int i = 232; i < 256; i += 6) {
            data.addAll(makeRow(i, i + 5));
        }

        Table t = new Table()
                .border(Table.Border.HIDDEN)
                .rows(data)
                .styleFunc((row, col) -> {
                    String colorCode = data.get(row)[col - (col % 2)];

                    if (col % 2 == 0) {
                        return labelStyle.foreground(Color.color(colorCode));
                    } else {
                        return swatchStyle.background(Color.color(colorCode));
                    }
                });

        System.out.println(t);
    }
}
