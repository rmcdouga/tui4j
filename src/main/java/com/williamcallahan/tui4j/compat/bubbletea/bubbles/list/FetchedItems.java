package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Bubble Tea-compatible alias for {@link com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FetchedItems.java}.
 * <p>
 * Bubbles: list/list.go.
 */
@SuppressWarnings("removal")
public class FetchedItems extends com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems {

    /**
     * Creates FetchedItems to keep this component ready for use.
     *
     * @param items items
     * @param matchedItems matched item count
     * @param totalItems total item count
     * @param totalPages total page count
     */
    public FetchedItems(List<FilteredItem> items, long matchedItems, long totalItems, int totalPages) {
        super(toCanonicalItems(items), matchedItems, totalItems, totalPages);
    }

    /**
     * Creates an empty fetched items result.
     */
    public FetchedItems() {
        super();
    }

    /**
     * Converts this instance to the canonical type.
     *
     * @return canonical fetched items
     */
    public com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems toCanonical() {
        return this;
    }

    /**
     * Creates a deprecated shim from the canonical type.
     *
     * @param canonical canonical fetched items
     * @return deprecated fetched items
     */
    public static FetchedItems fromCanonical(com.williamcallahan.tui4j.compat.bubbles.list.FetchedItems canonical) {
        if (canonical instanceof FetchedItems legacy) {
            return legacy;
        }
        return new FetchedItems(toLegacyItems(canonical.items()), canonical.matchedItems(),
                canonical.totalItems(), canonical.totalPages());
    }

    /**
     * Converts legacy filtered items to the canonical filtered item list.
     *
     * @param items legacy filtered items
     * @return canonical filtered items
     */
    private static List<com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem> toCanonicalItems(
            List<FilteredItem> items) {
        List<com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem> canonicalItems = new ArrayList<>(items.size());
        canonicalItems.addAll(items);
        return canonicalItems;
    }

    /**
     * Converts canonical filtered items to legacy filtered item wrappers.
     *
     * @param items canonical filtered items
     * @return legacy filtered items
     */
    private static List<FilteredItem> toLegacyItems(
            List<com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem> items) {
        List<FilteredItem> legacyItems = new ArrayList<>(items.size());
        for (com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem item : items) {
            if (item instanceof FilteredItem legacyItem) {
                legacyItems.add(legacyItem);
                continue;
            }
            legacyItems.add(new FilteredItem(item.rankIndex(), toLegacyItem(item.item()), item.matches()));
        }
        return legacyItems;
    }

    /**
     * Converts a canonical item to the legacy item wrapper.
     *
     * @param item canonical item
     * @return legacy item
     */
    private static Item toLegacyItem(com.williamcallahan.tui4j.compat.bubbles.list.Item item) {
        if (item instanceof Item legacyItem) {
            return legacyItem;
        }
        return item::filterValue;
    }
}
