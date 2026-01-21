package com.williamcallahan.tui4j.compat.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Port of Bubbles default data source.
 * Bubbles: bubbles/list/list.go
 */
public class DefaultDataSource implements ListDataSource {

    private final List list;
    private FilterFunction filterFunction;
    private java.util.List<Item> items;

    /**
     * Creates a data source backed by the provided list and items.
     *
     * @param list list model
     * @param items initial items
     */
    public DefaultDataSource(List list, Item... items) {
        this.list = list;
        this.items = new ArrayList<>(Arrays.asList(items));
        this.filterFunction = FuzzyFilter::defaultFilter;
    }

    /**
     * Replaces an item at the given index.
     *
     * @param index item index
     * @param item new item
     * @return refresh command
     */
    public Command setItem(int index, Item item) {
        this.items.set(index, item);
        return list.refresh();
    }

    /**
     * Inserts an item at the given index.
     *
     * @param index item index
     * @param item new item
     * @return refresh command
     */
    public Command insertItem(int index, Item item) {
        this.items.add(index, item);
        return list.refresh();
    }

    /**
     * Removes an item at the given index.
     *
     * @param index item index
     * @param postRemove optional callbacks
     * @return refresh command
     */
    public Command removeItem(int index, Runnable... postRemove) {
        this.items.remove(index);
        return list.refresh(postRemove);
    }

    /**
     * Replaces all items.
     *
     * @param items new items
     * @return refresh command
     */
    public Command setItems(Item... items) {
        this.items = new ArrayList<>(Arrays.asList(items));
        return list.refresh();
    }

    /**
     * Returns whether there are no items.
     *
     * @return true when empty
     */
    public boolean isEmpty() {
        return items == null || items.isEmpty();
    }

    @Override
    public FetchedItems fetchItems(int page, int perPage, String filterValue) {
        java.util.List<FilteredItem> filteredItems;

        if (filterValue == null || filterValue.isEmpty()) {
            filteredItems = allItemsAsFilteredItems();
        } else {
            String[] targets = new String[items.size()];
            for (int i = 0; i < items.size(); i++) {
                targets[i] = items.get(i).filterValue();
            }

            java.util.List<FilteredItem> filterMatches = new LinkedList<>();
            Rank[] ranks = filterFunction.apply(filterValue, targets);
            for (Rank rank : ranks) {
                filterMatches.add(new FilteredItem(
                        rank.getIndex(),
                        items.get(rank.getIndex()),
                        rank.getMatchedIndexes()
                ));
            }

            filteredItems = filterMatches;
        }

        int offset = page * perPage;
        long matchedItems = filteredItems.size();
        long totalItems = items.size();
        int totalPages = (int) Math.ceil((double) matchedItems / perPage);

        if (matchedItems == 0) {
            return new FetchedItems(java.util.List.of(), 0, totalItems, 0);
        }

        if (offset >= matchedItems && offset - perPage >= 0) {
            offset = offset - perPage;
        }
        if (offset < 0) {
            offset = 0;
        }

        int toIndex = Math.min(offset + perPage, filteredItems.size());
        return new FetchedItems(filteredItems.subList(offset, toIndex), matchedItems, totalItems, totalPages);
    }

    private java.util.List<FilteredItem> allItemsAsFilteredItems() {
        return items.stream().map(FilteredItem::new).toList();
    }

    /**
     * Returns the index of the given default item.
     *
     * @param defaultItem item to locate
     * @return index of the item or -1 when not found
     */
    public int indexOf(DefaultItem defaultItem) {
        return items.indexOf(defaultItem);
    }
}
