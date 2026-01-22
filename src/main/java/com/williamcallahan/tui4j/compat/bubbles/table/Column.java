package com.williamcallahan.tui4j.compat.bubbles.table;

import java.util.Objects;

/**
 * Port of Bubbles table Column.
 * Bubble Tea: bubbles/table/table.go
 * <p>
 * Bubbles: table/table.go.
 */
public class Column {
    private final String title;
    private final int width;

    /**
     * Creates a column with a default width of zero.
     *
     * @param title column title
     */
    public Column(String title) {
        this(title, 0);
    }

    /**
     * Normalizes negative widths to zero.
     *
     * @param title column title
     * @param width column width
     */
    public Column(String title, int width) {
        this.title = title;
        this.width = Math.max(0, width);
    }

    /**
     * Handles title for this component.
     *
     * @return result
     */
    public String title() {
        return title;
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
     * Handles equals for this component.
     *
     * @param o o
     * @return whether uals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return width == column.width && Objects.equals(title, column.title);
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, width);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "Column[title=" + title + ", width=" + width + "]";
    }
}
