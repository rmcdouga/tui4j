package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Styles} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: table/table.go.
 */
@Deprecated(since = "0.3.0")
public class Styles extends com.williamcallahan.tui4j.compat.bubbles.table.Styles {
    
    /**
     * Creates a styles container for the legacy shim.
     */
    public Styles() {
    }

    /**
     * Handles default styles for this component.
     *
     * @return result
     */
    public static Styles defaultStyles() {
        return new Styles();
    }

    // Override fluent setters to return OldStyles
    /**
     * Handles header for this component.
     *
     * @param header header
     * @return result
     */
    @Override
    public Styles header(Style header) {
        super.header(header);
        return this;
    }

    /**
     * Handles cell for this component.
     *
     * @param cell cell
     * @return result
     */
    @Override
    public Styles cell(Style cell) {
        super.cell(cell);
        return this;
    }

    /**
     * Handles selected for this component.
     *
     * @param selected selected
     * @return result
     */
    @Override
    public Styles selected(Style selected) {
        super.selected(selected);
        return this;
    }
    
    // Legacy methods if they existed
    /**
     * Handles selected row header for this component.
     *
     * @return result
     */
    public Style selectedRowHeader() { return null; }
    /**
     * Handles selected column header for this component.
     *
     * @return result
     */
    public Style selectedColumnHeader() { return null; }
    /**
     * Handles selected cell for this component.
     *
     * @return result
     */
    public Style selectedCell() { return null; }
}
