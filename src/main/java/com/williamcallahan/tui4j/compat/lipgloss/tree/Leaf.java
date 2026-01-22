package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * Port of github.com/charmbracelet/lipgloss/tree/tree.go (Leaf).
 * <p>
 * Lipgloss: tree/tree.go.
 */
public class Leaf implements Node {

    private String value;
    private boolean hidden;
    private Node nodeValue;

    /**
     * Creates a new leaf with the given value.
     *
     * @param value the value
     */
    public Leaf(String value) {
        this.value = value;
    }

    /**
     * Creates a new leaf with the given value and hidden state.
     *
     * @param value the value
     * @param hidden true if hidden
     */
    public Leaf(Object value, boolean hidden) {
        setValue(value);
        setHidden(hidden);
    }

    /**
     * Creates a new empty leaf.
     */
    public Leaf() {
    }

    /**
     * Handles value for this component.
     *
     * @return result
     */
    @Override
    public String value() {
        return value;
    }

    /**
     * Handles children for this component.
     *
     * @return result
     */
    @Override
    public Children children() {
        if (nodeValue != null) {
            return nodeValue.children();
        }
        return new NodeChildren();
    }

    /**
     * Reports whether hidden.
     *
     * @return whether hidden
     */
    @Override
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Sets whether the leaf is hidden.
     *
     * @param hidden true if hidden
     * @return this leaf for chaining
     */
    public Leaf setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Sets the value of the leaf.
     *
     * @param value the value
     * @return this leaf for chaining
     */
    public Leaf setValue(Object value) {
        if (value instanceof Node node) {
            this.nodeValue = node;
            this.value = String.valueOf(node.value());
        } else {
            this.nodeValue = null;
            this.value = String.valueOf(value);
        }
        return this;
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return value;
    }
}
