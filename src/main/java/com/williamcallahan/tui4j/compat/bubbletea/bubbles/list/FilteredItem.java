package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class FilteredItem extends com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem {

    @Deprecated(since = "0.3.0")
    public FilteredItem(int rankIndex, Item item, int[] matches) {
        super(rankIndex, item, matches);
    }

    @Deprecated(since = "0.3.0")
    public FilteredItem(Item item) {
        super(item);
    }

}
