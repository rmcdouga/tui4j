package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Column} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: table/table.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Column extends com.williamcallahan.tui4j.compat.bubbles.table.Column {
    
    /**
     * Creates Column to keep this component ready for use.
     *
     * @param title title
     */
    public Column(String title) {
        super(title);
    }

    /**
     * Creates Column to keep this component ready for use.
     *
     * @param title title
     * @param style style
     */
    public Column(String title, Style style) {
        // New Column doesn't seem to store style in the constructor I saw?
        // Let's check NewColumn content again.
        // It has title and width. No style field in the snippet I read.
        // If NewColumn lost style support, we ignore it or store it locally?
        // Storing locally in Shim doesn't help rendering in NewTable.
        // We will just call super(title).
        super(title);
    }

    /**
     * Creates Column to keep this component ready for use.
     *
     * @param title title
     * @param width width
     */
    public Column(String title, int width) {
        super(title, width);
    }

    /**
     * Creates Column to keep this component ready for use.
     *
     * @param title title
     * @param width width
     * @param style style
     */
    public Column(String title, int width, Style style) {
        super(title, width);
    }

    // If 'style' method was removed from NewColumn, we add it here as deprecated no-op or storage
    /**
     * Handles style for this component.
     *
     * @return result
     */
    public Style style() {
        return null;
    }
}
