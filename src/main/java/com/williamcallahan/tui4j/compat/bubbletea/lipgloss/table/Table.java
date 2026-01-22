package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.table;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer;

/**
 * Table component for rendering tabular data.
 * <p>
 * Lipgloss: table/table.go
 *
 * @deprecated <b>tui4j compat refactor:</b> Moved to
 * {@link com.williamcallahan.tui4j.compat.lipgloss.table.Table}.
 * This transitional shim preserves backward compatibility and will be removed
 * in a future release. Migrate to the canonical location.
 * @since 0.3.0
 * @see com.williamcallahan.tui4j.compat.lipgloss.table.Table
 * Lip Gloss: table/table.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Table extends com.williamcallahan.tui4j.compat.lipgloss.table.Table {

    /**
     * Creates a Table with the given renderer.
     *
     * @param renderer the renderer
     */
    public Table(Renderer renderer) {
        super(renderer.toCanonical());
    }

    /**
     * Creates a Table with the default renderer.
     *
     * @return the new Table
     */
    public static Table create() {
        return new Table(Renderer.defaultRenderer());
    }
}
