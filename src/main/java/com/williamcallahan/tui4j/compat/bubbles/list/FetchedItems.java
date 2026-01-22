package com.williamcallahan.tui4j.compat.bubbles.list;

import java.util.List;

/**
 * Port of Bubbles fetched items.
 * Upstream: github.com/charmbracelet/bubbles/list/list.go
 *
 * @param items fetched items
 * @param matchedItems matched item count
 * @param totalItems total item count
 * @param totalPages total page count
 */
public record FetchedItems(List<FilteredItem> items, long matchedItems, long totalItems, int totalPages) {

    /**
     * Creates an empty fetched-items result.
     */
    public FetchedItems() {
        this(List.of(), 0, 0, 0);
    }
}
