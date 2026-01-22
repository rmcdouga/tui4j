package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FilteredItem.java}.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class FilteredItem extends com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem {
    /**
     * Creates FilteredItem to keep this component ready for use.
     *
     * @param rankIndex rank index
     * @param item item
     * @param matches matches
     */
    public FilteredItem(int rankIndex, Item item, int[] matches) {
        super(rankIndex, item, matches);
    }

    /**
     * Creates FilteredItem to keep this component ready for use.
     *
     * @param item item
     */
    public FilteredItem(Item item) {
        super(item);
    }
}
