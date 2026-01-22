package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FetchedCurrentPageItems.java}.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0")
@SuppressWarnings("removal")
public class FetchedCurrentPageItems extends com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems
        implements Message {

    /**
     * Creates FetchedCurrentPageItems to keep this component ready for use.
     *
     * @param fetchedItems fetched page items
     * @param postFetch callbacks to run after fetching
     */
    public FetchedCurrentPageItems(FetchedItems fetchedItems, Runnable... postFetch) {
        super(fetchedItems, postFetch);
    }

    /**
     * Converts this instance to the canonical type.
     *
     * @return canonical fetched current page items
     */
    public com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems toCanonical() {
        return this;
    }

    /**
     * Creates a deprecated shim from the canonical type.
     *
     * @param canonical canonical fetched current page items
     * @return deprecated fetched current page items
     */
    public static FetchedCurrentPageItems fromCanonical(
            com.williamcallahan.tui4j.compat.bubbles.list.FetchedCurrentPageItems canonical) {
        if (canonical instanceof FetchedCurrentPageItems legacy) {
            return legacy;
        }
        return new FetchedCurrentPageItems(FetchedItems.fromCanonical(canonical.fetchedItems()),
                canonical.postFetch());
    }
}
