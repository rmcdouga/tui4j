package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class FilteredItem extends com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem {

    /**
     * Creates a filtered item with ranking metadata.
     *
     * @param rankIndex rank index
     * @param item item instance
     * @param matches match positions
     */
    @Deprecated(since = "0.3.0")
    public FilteredItem(int rankIndex, Item item, int[] matches) {
        super(rankIndex, item, matches);
    }

    /**
     * Creates a filtered item wrapper for the provided item.
     *
     * @param item item instance
     */
    @Deprecated(since = "0.3.0")
    public FilteredItem(Item item) {
        super(item);
    }

}
