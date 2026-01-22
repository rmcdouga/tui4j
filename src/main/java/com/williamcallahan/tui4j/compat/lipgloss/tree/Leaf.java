package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * Port of github.com/charmbracelet/lipgloss/tree/tree.go (Leaf).
 */
public class Leaf implements Node {

    private String value;
    private boolean hidden;
    private Node nodeValue;

    public Leaf(String value) {
        this.value = value;
    }

    public Leaf(Object value, boolean hidden) {
        setValue(value);
        setHidden(hidden);
    }

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

    public Leaf setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

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
