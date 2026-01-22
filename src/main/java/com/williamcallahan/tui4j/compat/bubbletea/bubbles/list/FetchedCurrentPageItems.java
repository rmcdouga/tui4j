package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class FetchedCurrentPageItems implements Message {
    private final com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems delegate;

    /**
     * Creates FetchedCurrentPageItems.
     *
     * @param fetchedItems fetched page items
     * @param postFetch callbacks to run after fetching
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public FetchedCurrentPageItems(FetchedItems fetchedItems, Runnable... postFetch) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems(
                fetchedItems.toCanonical(), postFetch);
    }

    /**
     * Creates FetchedCurrentPageItems from canonical types.
     *
     * @param fetchedItems canonical fetched items
     * @param postFetch callbacks to run after fetching
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public FetchedCurrentPageItems(com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems fetchedItems,
                                    Runnable... postFetch) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems(
                fetchedItems, postFetch);
    }

    /**
     * Internal constructor wrapping a canonical delegate.
     */
    private FetchedCurrentPageItems(com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the fetched items.
     *
     * @return fetched items
     */
    public com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems fetchedItems() {
        return delegate.fetchedItems();
    }

    /**
     * Returns the post-fetch callbacks.
     *
     * @return callbacks
     */
    public Runnable[] postFetch() {
        return delegate.postFetch();
    }

    /**
     * Returns the canonical delegate.
     *
     * @return canonical FetchedCurrentPageItems
     */
    public com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems toCanonical() {
        return delegate;
    }

    /**
     * Creates a deprecated shim from the canonical type.
     *
     * @param canonical canonical fetched current page items
     * @return deprecated fetched current page items
     */
    public static FetchedCurrentPageItems fromCanonical(
            com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems canonical) {
        return new FetchedCurrentPageItems(canonical);
    }
}
