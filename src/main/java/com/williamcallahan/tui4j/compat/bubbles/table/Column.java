package com.williamcallahan.tui4j.compat.bubbles.table;

/**
 * Port of Bubbles table Column.
 * Bubble Tea: bubbles/table/table.go
 */
public class Column {

    private final String title;
    private final int width;

    /**
     * Creates a column with the given title and width.
     *
     * @param title column title
     * @param width column width (negative values normalized to zero)
     */
    public Column(String title, int width) {
        this.title = title;
        this.width = width < 0 ? 0 : width;
    }

    /**
     * Creates a column with a default width of zero.
     *
     * @param title column title
     */
    public Column(String title) {
        this(title, 0);
    }

    /**
     * Returns the column title.
     *
     * @return column title
     */
    public String title() {
        return title;
    }

    /**
     * Returns the column width.
     *
     * @return column width
     */
    public int width() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Column column)) return false;
        return width == column.width && java.util.Objects.equals(title, column.title);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, width);
    }

    @Override
    public String toString() {
        return "Column[title=" + title + ", width=" + width + "]";
    }
}
