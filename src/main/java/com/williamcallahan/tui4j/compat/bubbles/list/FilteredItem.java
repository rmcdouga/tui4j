package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Port of Bubbles filtered item.
 * Upstream: github.com/charmbracelet/bubbles/list/list.go
 */
public class FilteredItem {
    private int rankIndex;
    private Item item;
    private int[] matches;

    /**
     * Creates a filtered item with match metadata.
     *
     * @param rankIndex rank index for sorting
     * @param item backing item
     * @param matches matched rune indices
     */
    public FilteredItem(int rankIndex, Item item, int[] matches) {
        this.rankIndex = rankIndex;
        this.item = item;
        this.matches = matches;
    }

    /**
     * Creates a filtered item with no matches.
     *
     * @param item backing item
     */
    public FilteredItem(Item item) {
        this.item = item;
        this.matches = new int[0];
    }

    /**
     * Returns the backing item.
     *
     * @return backing item
     */
    public Item item() {
        return item;
    }

    /**
     * Returns the matched rune indices.
     *
     * @return matched indices
     */
    public int[] matches() {
        return matches;
    }

    /**
     * Returns the ranking index used for sorting.
     *
     * @return rank index
     */
    public int rankIndex() {
        return rankIndex;
    }
}
