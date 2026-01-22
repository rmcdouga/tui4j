package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * Bubble Tea-compatible alias for {@link com.williamcallahan.tui4j.compat.bubbles.list.ListDataSource}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/ListDataSource.java}.
 * <p>
 * Bubbles: list/list.go.
 */
@SuppressWarnings("removal")
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
