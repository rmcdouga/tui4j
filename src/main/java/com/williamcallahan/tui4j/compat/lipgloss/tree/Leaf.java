package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * Port of Lip Gloss leaf nodes.
 * Upstream: lipgloss/tree/tree.go
 */
public class Leaf implements Node {

    private String value;
    private boolean hidden;
    private Node nodeValue;

    /**
     * Creates a leaf with a string value.
     *
     * @param value leaf value
     */
    public Leaf(String value) {
        this.value = value;
    }

    /**
     * Creates a leaf with a value and visibility.
     *
     * @param value leaf value
     * @param hidden whether the leaf is hidden
     */
    public Leaf(Object value, boolean hidden) {
        setValue(value);
        setHidden(hidden);
    }

    /**
     * Creates an empty leaf.
     */
    public Leaf() {
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public Children children() {
        if (nodeValue != null) {
            return nodeValue.children();
        }
        return new NodeChildren();
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Sets whether this leaf is hidden.
     *
     * @param hidden hidden state
     * @return this leaf for chaining
     */
    public Leaf setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Sets the leaf value, accepting nested nodes.
     *
     * @param value leaf value or child node
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

    @Override
    public String toString() {
        return value;
    }
}
