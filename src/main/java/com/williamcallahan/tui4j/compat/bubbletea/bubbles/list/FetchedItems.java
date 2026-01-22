package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class FetchedItems {
    private final com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems delegate;

    /**
     * Creates FetchedItems.
     *
     * @param items filtered items
     * @param matchedItems matched item count
     * @param totalItems total item count
     * @param totalPages total page count
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public FetchedItems(List<FilteredItem> items, long matchedItems, long totalItems, int totalPages) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems(
                toCanonicalItems(items), matchedItems, totalItems, totalPages);
    }

    /**
     * Creates an empty fetched items result.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public FetchedItems() {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems();
    }

    /**
     * Internal constructor wrapping a canonical delegate.
     */
    private FetchedItems(com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the filtered items.
     *
     * @return filtered items
     */
    public List<com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem> items() {
        return delegate.items();
    }

    /**
     * Returns the matched item count.
     *
     * @return matched item count
     */
    public long matchedItems() {
        return delegate.matchedItems();
    }

    /**
     * Returns the total item count.
     *
     * @return total item count
     */
    public long totalItems() {
        return delegate.totalItems();
    }

    /**
     * Returns the total page count.
     *
     * @return total page count
     */
    public int totalPages() {
        return delegate.totalPages();
    }

    /**
     * Returns the canonical delegate.
     *
     * @return canonical FetchedItems
     */
    public com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems toCanonical() {
        return delegate;
    }

    /**
     * Creates a deprecated shim from the canonical type.
     *
     * @param canonical canonical fetched items
     * @return deprecated fetched items
     */
    public static FetchedItems fromCanonical(com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems canonical) {
        return new FetchedItems(canonical);
    }

    /**
     * Converts legacy filtered items to canonical list.
     */
    private static List<com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem> toCanonicalItems(
            List<FilteredItem> items) {
        List<com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem> canonicalItems = new ArrayList<>(items.size());
        canonicalItems.addAll(items);
        return canonicalItems;
    }
}
