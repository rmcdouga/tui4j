package com.williamcallahan.tui4j.compat.bubbletea.bubbles.table;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.table.Keys} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: table/table.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Keys extends com.williamcallahan.tui4j.compat.bubbles.table.Keys {
    /**
     * Creates a table key map shim.
     */
    public Keys() {
        super();
    }

    // Removed @Override for methods that don't exist in parent
    /**
     * Handles column for this component.
     *
     * @return result
     */
    public Binding column() {
        return null;
    }

    /**
     * Handles row for this component.
     *
     * @return result
     */
    public Binding row() {
        return null;
    }
}
