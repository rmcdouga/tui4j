package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * A filtered view over tree children that shows only nodes matching a predicate.
 * <p>
 * Port of charmbracelet/lipgloss tree/children.go Filter type.
 *
 * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/tree/children.go">lipgloss/tree/children.go</a>
 * <p>
 * Lipgloss: tree/children.go.
 */
public class Filter implements Children {

    /**
     * Predicate function for filtering tree nodes by index.
     * <p>
     * Lipgloss: tree/children.go.
     */
    public interface FilterFunction {
        /**
         * Returns true if the node at the given index should be included.
         *
         * @param index the node index
         * @return true to include, false to exclude
         */
        boolean filter(int index);
    }

    private final Children data;
    private FilterFunction filterFunction = index -> true;

    /**
     * Creates a filter over the given children.
     *
     * @param data the underlying children
     */
    public Filter(Children data) {
        this.data = data;
    }

    /**
     * Handles at for this component.
     *
     * @param index index
     * @return result
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
     * Sets the predicate for filtering children.
     *
     * @param filterFunction a predicate that returns true for nodes to include
     * @return this filter for chaining
     */
    public Filter filter(FilterFunction filterFunction) {
        this.filterFunction = filterFunction;
        return this;
    }

    /**
     * Handles remove for this component.
     *
     * @param index index
     * @return result
     */
    @Override
    public Children remove(int index) {
        throw new UnsupportedOperationException("Filter is a read-only view");
    }

    /**
     * Handles append for this component.
     *
     * @param child child
     * @return result
     */
    @Override
    public Children append(Node child) {
        throw new UnsupportedOperationException("Filter is a read-only view");
    }

    /**
     * Handles length for this component.
     *
     * @return result
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
