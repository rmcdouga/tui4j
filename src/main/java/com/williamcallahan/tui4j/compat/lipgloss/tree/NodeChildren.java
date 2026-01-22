package com.williamcallahan.tui4j.compat.lipgloss.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Port of Lip Gloss node children.
 * Upstream: lipgloss/tree/children.go
 */
public class NodeChildren implements Children {

    private List<Node> children = new ArrayList<>();

    /**
     * Creates node children with an initial list.
     *
     * @param children initial children
     */
    public NodeChildren(List<Node> children) {
        this.children = children;
    }

    /**
     * Creates an empty node children container.
     */
    public NodeChildren() {
    }

    @Override
    public Node at(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        return null;
    }

    @Override
    public Children remove(int index) {
        children.remove(index);
        return this;
    }

    @Override
    public int length() {
        return children.size();
    }

    /**
     * Appends a child node.
     *
     * @param child child to add
     * @return this children container
     */
    public Children append(Node child) {
        children.add(child);
        return this;
    }
}
