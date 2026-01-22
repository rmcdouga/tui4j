package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.ListDataSource}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/ListDataSource.java}.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.ListDataSource}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public interface ListDataSource extends com.williamcallahan.tui4j.compat.bubbles.list.ListDataSource {

    /**
     * Fetches a page of items, optionally filtered by the provided value.
     *
     * @param page page index
     * @param perPage items per page
     * @param filterValue filter term
     * @return fetched items
     */
    @Override
    FetchedItems fetchItems(int page, int perPage, String filterValue);
}
