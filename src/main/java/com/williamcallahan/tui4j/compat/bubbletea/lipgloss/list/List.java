package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.list;

import com.williamcallahan.tui4j.compat.lipgloss.ListEnumerator;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved; use {@link com.williamcallahan.tui4j.compat.lipgloss.List}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: list/list.go.
 */
@Deprecated(since = "0.3.0")
public class List extends com.williamcallahan.tui4j.compat.lipgloss.List {
    /**
     * Creates List to keep this component ready for use.
     *
     * @param items items
     */
    public List(String... items) {
        super((Object[]) items);
    }

    /**
     * Creates List to keep this component ready for use.
     *
     * @param items items
     */
    public List(Object... items) {
        super(items);
    }

    /**
     * Creates a list with an indent string and items.
     *
     * @param indent indent to apply
     * @param items  list items
     */
    public List(String indent, String... items) {
        super((Object[]) items);
    }
    
    /**
     * Creates a list with a custom enumerator and items.
     *
     * @param enumerator enumerator to use
     * @param items      list items
     */
    public List(ListEnumerator enumerator, String... items) {
         super((Object[]) items);
    }
    
    /**
     * Creates a list with indent, enumerator, and items.
     *
     * @param indent     indent to apply
     * @param enumerator enumerator to use
     * @param items      list items
     */
    public List(String indent, ListEnumerator enumerator, String... items) {
        super((Object[]) items);
    }
}
