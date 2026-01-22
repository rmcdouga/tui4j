package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Filter} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: tree/children.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Filter extends com.williamcallahan.tui4j.compat.lipgloss.tree.Filter {

    /**
 */
    public interface FilterFunction
        extends com.williamcallahan.tui4j.compat.lipgloss.tree.Filter.FilterFunction {}

    /**
     * Creates Filter to keep this component ready for use.
     *
     * @param data data
     */
    public Filter(Children data) {
        super(data);
    }

    /**
     * Handles at for this component.
     *
     * @param index index
     * @return result
     */
    @Override
    public Node at(int index) {
        return (Node) super.at(index);
    }

    /**
     * Handles filter for this component.
     *
     * @param filterFunction filter function
     * @return result
     */
    public Filter filter(FilterFunction filterFunction) {
        super.filter(filterFunction);
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
        return (Children) super.remove(index);
    }

    /**
     * Handles append for this component.
     *
     * @param child child
     * @return result
     */
    public Children append(Node child) {
        return (Children) super.append(child);
    }
}
