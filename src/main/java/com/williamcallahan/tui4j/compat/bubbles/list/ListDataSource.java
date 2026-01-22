package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Port of Bubbles list item sourcing hooks.
 * Bubbles: list/list.go.
 * <p>
 * Bubbles: filepicker/hidden_windows.go.
 */
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
}
