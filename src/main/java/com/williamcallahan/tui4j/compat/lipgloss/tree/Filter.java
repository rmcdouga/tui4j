package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * Port of the Lip Gloss tree filter wrapper.
 * Upstream: github.com/charmbracelet/lipgloss/tree/children.go (Filter)
 */
public class Filter implements Children {

    /**
     * Port of the tree filter predicate.
     * Upstream: github.com/charmbracelet/lipgloss/tree/children.go (FilterFunc)
     */
    public interface FilterFunction {
        /**
         * Returns true when the child at the index should be included.
         *
         * @param index child index
         * @return true when the child should be included
         */
        boolean filter(int index);
    }

    private final Children data;
    private FilterFunction filterFunction = index -> true;

    /**
     * Creates a filtered view over child nodes.
     *
     * @param data child collection
     */
    public Filter(Children data) {
        this.data = data;
    }

    /**
     * Returns the node at the filtered index.
     *
     * @param index filtered index
     * @return node or {@code null} when missing
     */
    @Override
    public Node at(int index) {
        int j = 0;
        for (int i = 0; i < data.length(); i++) {
            if (filterFunction.filter(i)) {
                if (j == index) {
                    return data.at(i);
                }
                j++;
            }
        }

        return null;
    }

    /**
     * Sets the filter function used to include children.
     *
     * @param filterFunction filter predicate
     * @return this filter for chaining
     */
    public Filter filter(FilterFunction filterFunction) {
        this.filterFunction = filterFunction;
        return this;
    }

    /**
     * This view is read-only and does not support removal.
     *
     * @param index index to remove
     * @return never returns normally
     */
    @Override
    public Children remove(int index) {
        throw new UnsupportedOperationException("Filter is a read-only view");
    }

    /**
     * This view is read-only and does not support append.
     *
     * @param child node to append
     * @return never returns normally
     */
    @Override
    public Children append(Node child) {
        throw new UnsupportedOperationException("Filter is a read-only view");
    }

    /**
     * Returns the number of children that match the predicate.
     *
     * @return filtered child count
     */
    @Override
    public int length() {
        int j = 0;
        for (int i = 0; i < data.length(); i++) {
            if (filterFunction.filter(i)) {
                j++;
            }
        }
        return j;
    }
}
