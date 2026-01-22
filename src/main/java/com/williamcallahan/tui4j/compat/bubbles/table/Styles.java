package com.williamcallahan.tui4j.compat.bubbles.table;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Port of Bubbles table Styles.
 * Bubble Tea: bubbles/table/table.go
 * <p>
 * Bubbles: table/table.go.
 */
public class Styles {

    private Style header;
    private Style cell;
    private Style selected;

    /**
     * Creates Styles to keep this component ready for use.
     */
    public Styles() {
        this.header = Style.newStyle().bold(true).padding(0, 1);
        this.cell = Style.newStyle().padding(0, 1);
        this.selected = Style.newStyle().bold(true);
    }

    /**
     * Handles default styles for this component.
     *
     * @return result
     */
    public static Styles defaultStyles() {
        return new Styles();
    }

    /**
     * Handles header for this component.
     *
     * @return result
     */
    public Style header() {
        return header;
    }

    /**
     * Handles header for this component.
     *
     * @param header header
     * @return result
     */
    public Styles header(Style header) {
        this.header = header;
        return this;
    }

    /**
     * Handles cell for this component.
     *
     * @return result
     */
    public Style cell() {
        return cell;
    }

    /**
     * Handles cell for this component.
     *
     * @param cell cell
     * @return result
     */
    public Styles cell(Style cell) {
        this.cell = cell;
        return this;
    }

    /**
     * Handles selected for this component.
     *
     * @return result
     */
    public Style selected() {
        return selected;
    }

    /**
     * Handles selected for this component.
     *
     * @param selected selected
     * @return result
     */
    public Styles selected(Style selected) {
        this.selected = selected;
        return this;
    }
}
