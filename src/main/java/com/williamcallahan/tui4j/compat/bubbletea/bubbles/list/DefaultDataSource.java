package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.DefaultDataSource}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/DefaultDataSource.java}.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.DefaultDataSource}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class DefaultDataSource extends com.williamcallahan.tui4j.compat.bubbles.list.DefaultDataSource {
    
    /**
     * Creates DefaultDataSource to keep this component ready for use.
     *
     * @param list list
     * @param items items
     */
    public DefaultDataSource(List list, Item... items) {
        super(list, items);
    }
}
