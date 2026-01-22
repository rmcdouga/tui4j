package com.williamcallahan.tui4j.compat.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import java.util.Objects;
import java.util.Arrays;

/**
 * Port of Bubbles fetched current page items.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 * <p>
 * Bubbles: list/list.go.
 */
public class FetchedCurrentPageItems implements Message {
    private final FetchedItems fetchedItems;
    private final Runnable[] postFetch;

    /**
     * Creates FetchedCurrentPageItems to keep this component ready for use.
     *
     * @param fetchedItems fetched items
     * @param postFetch post fetch
     */
    public FetchedCurrentPageItems(FetchedItems fetchedItems, Runnable... postFetch) {
        this.fetchedItems = fetchedItems;
        this.postFetch = postFetch;
    }

    /**
     * Handles fetched items for this component.
     *
     * @return result
     */
    public FetchedItems fetchedItems() {
        return fetchedItems;
    }

    /**
     * Handles post fetch for this component.
     *
     * @return result
     */
    public Runnable[] postFetch() {
        return postFetch;
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
        FetchedCurrentPageItems that = (FetchedCurrentPageItems) o;
        return Objects.equals(fetchedItems, that.fetchedItems) && Arrays.equals(postFetch, that.postFetch);
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(fetchedItems);
        result = 31 * result + Arrays.hashCode(postFetch);
        return result;
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "FetchedCurrentPageItems[fetchedItems=" + fetchedItems + ", postFetch=" + Arrays.toString(postFetch) + "]";
    }
}
