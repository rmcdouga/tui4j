package com.williamcallahan.tui4j.compat.bubbles.list;

import java.util.List;

/**
 * Result of fetching items from a list data source.
 * <p>
 * Port of charmbracelet/bubbles list/list.go internal fetching logic.
 *
 * @param items the fetched and filtered items
 * @param matchedItems count of items matching the current filter
 * @param totalItems total count of items in the data source
 * @param totalPages total number of pages available
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/list/list.go">bubbles/list/list.go</a>
 */
public record FetchedItems(List<FilteredItem> items, long matchedItems, long totalItems, int totalPages) {

    /** Creates an empty fetched items result. */
    public FetchedItems() {
        this(List.of(), 0, 0, 0);
    }
}
