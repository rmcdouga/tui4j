package com.williamcallahan.tui4j.compat.bubbles.list;

import java.util.List;
import java.util.Objects;

/**
 * Result of fetching items from a list data source.
 * <p>
 * Port of charmbracelet/bubbles list/list.go internal fetching logic.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/list/list.go">bubbles/list/list.go</a>
 * <p>
 * Bubbles: list/list.go.
 */
public class FetchedItems {
    private final List<FilteredItem> items;
    private final long matchedItems;
    private final long totalItems;
    private final int totalPages;

    /**
     * Creates FetchedItems to keep this component ready for use.
     *
     * @param items items
     * @param matchedItems matched items
     * @param totalItems total items
     * @param totalPages total pages
     */
    public FetchedItems(List<FilteredItem> items, long matchedItems, long totalItems, int totalPages) {
        this.items = items;
        this.matchedItems = matchedItems;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }

    /** Creates an empty fetched items result. */
    public FetchedItems() {
        this(List.of(), 0, 0, 0);
    }

    /**
     * Handles items for this component.
     *
     * @return result
     */
    public List<FilteredItem> items() {
        return items;
    }

    /**
     * Handles matched items for this component.
     *
     * @return result
     */
    public long matchedItems() {
        return matchedItems;
    }

    /**
     * Handles total items for this component.
     *
     * @return result
     */
    public long totalItems() {
        return totalItems;
    }

    /**
     * Handles total pages for this component.
     *
     * @return result
     */
    public int totalPages() {
        return totalPages;
    }

    /**
     * Handles equals for this component.
     *
     * @param o o
     * @return whether uals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FetchedItems that = (FetchedItems) o;
        return matchedItems == that.matchedItems && totalItems == that.totalItems && totalPages == that.totalPages && Objects.equals(items, that.items);
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(items, matchedItems, totalItems, totalPages);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "FetchedItems[items=" + items + ", matchedItems=" + matchedItems + ", totalItems=" + totalItems + ", totalPages=" + totalPages + "]";
    }
}
