package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.tree.StyleFunction;
import com.williamcallahan.tui4j.compat.lipgloss.tree.Tree;
import com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator;
import com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter;

/**
 * List component.
 * <p>
 * Port of `lipgloss/list`.
 * Renders an ordered or unordered list of items using the underlying Tree component.
 */
public class List {

    private Tree tree;

    /**
     * Creates a new list with the given items.
     *
     * @param items the items to include in the list
     */
    public List(Object... items) {
        this.tree = new Tree();
        this.items(items).enumerator(ListEnumerator.bullet()).indenter((children, index) -> " ");
    }

    /**
     * Returns whether the list is hidden.
     *
     * @return true if hidden
     */
    public boolean isHidden() {
        return tree.isHidden();
    }

    /**
     * Sets whether the list is hidden.
     *
     * @param hide true to hide
     * @return this list for chaining
     */
    public List hide(boolean hide) {
        tree.hide(hide);
        return this;
    }

    /**
     * Sets the offset range for rendering.
     *
     * @param start start index
     * @param end end index
     * @return this list for chaining
     */
    public List offset(int start, int end) {
        tree.offset(start, end);
        return this;
    }

    /**
     * Sets the style for enumerators.
     *
     * @param style the enumerator style
     * @return this list for chaining
     */
    public List enumeratorStyle(Style style) {
        tree.enumeratorStyle(style);
        return this;
    }

    /**
     * Sets a function to compute enumerator style.
     *
     * @param function the style function
     * @return this list for chaining
     */
    public List enumeratorStyleFunc(StyleFunction function) {
        tree.enumeratorStyleFunc(function);
        return this;
    }

    /**
     * Sets a function to compute item style.
     *
     * @param function the style function
     * @return this list for chaining
     */
    public List itemStyleFunc(StyleFunction function) {
        tree.itemStyleFunc(function);
        return this;
    }

    /**
     * Sets the indenter for nested items.
     *
     * @param indenter the indenter
     * @return this list for chaining
     */
    public List indenter(TreeIndenter indenter) {
        tree.indenter(indenter);
        return this;
    }

    /**
     * Sets the enumerator for list items.
     *
     * @param enumerator the enumerator
     * @return this list for chaining
     */
    public List enumerator(TreeEnumerator enumerator) {
        tree.enumerator(enumerator);
        return this;
    }

    /**
     * Adds an item to the list.
     *
     * @param item the item to add
     * @return this list for chaining
     */
    public List item(Object item) {
        if (item instanceof List list) {
            tree.child(list.tree);
        } else {
            tree.child(item);
        }
        return this;
    }

    /**
     * Adds multiple items to the list.
     *
     * @param items the items to add
     * @return this list for chaining
     */
    public List items(Object... items) {
        for (Object item : items) {
            item(item);
        }
        return this;
    }

    /**
     * Renders the list to a string.
     *
     * @return the rendered list
     */
    public String render() {
        return tree.render();
    }

    @Override
    public String toString() {
        return render();
    }
}
