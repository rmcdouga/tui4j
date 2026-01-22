package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.list.ListDataSource} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public interface ListDataSource {

    /**
     * Fetches a page of items, optionally filtered by the provided value.
     *
     * @param page page index
     * @param perPage items per page
     * @param filterValue filter term
     * @return fetched items
     */
    FetchedItems fetchItems(int page, int perPage, String filterValue);

    /**
     * Adapts this deprecated data source to the canonical interface.
     *
     * @return canonical data source adapter
     */
    default com.williamcallahan.tui4j.compat.bubbles.list.ListDataSource toCanonical() {
        ListDataSource self = this;
        return (page, perPage, filterValue) -> self.fetchItems(page, perPage, filterValue).toCanonical();
    }
}
