package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * A list item with filter match information.
 * <p>
 * Port of charmbracelet/bubbles list/list.go filteredItem type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/list/list.go">bubbles/list/list.go</a>
 * <p>
 * Bubbles: list/list.go.
 */
public class FilteredItem {
    private int rankIndex;
    private Item item;
    private int[] matches;

    /**
     * Creates a filtered item with match details.
     *
     * @param rankIndex the item's rank in the filtered results
     * @param item the underlying list item
     * @param matches indices of matching characters
     */
    public FilteredItem(int rankIndex, Item item, int[] matches) {
        this.rankIndex = rankIndex;
        this.item = item;
        this.matches = matches;
    }

    /**
     * Creates a filtered item without match details.
     *
     * @param item the underlying list item
     */
    public FilteredItem(Item item) {
        this.item = item;
        this.matches = new int[0];
    }

    /**
     * Returns the underlying list item.
     *
     * @return the item
     */
    public Item item() {
        return item;
    }

    /**
     * Returns the indices of matching characters for highlighting.
     *
     * @return array of match indices
     */
    public int[] matches() {
        return matches;
    }

    /**
     * Returns the item's rank index in filtered results.
     *
     * @return the rank index
     */
    public int rankIndex() {
        return rankIndex;
    }
}
