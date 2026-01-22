package com.williamcallahan.tui4j.compat.lipgloss.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Port of Lip Gloss node children.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: tree/children.go.
 */
public class NodeChildren implements Children {

    private List<Node> children = new ArrayList<>();

    /**
     * Creates NodeChildren to keep this component ready for use.
     *
     * @param children children
     */
    public NodeChildren(List<Node> children) {
        this.children = children;
    }

    /**
     * Creates NodeChildren to keep this component ready for use.
     */
    public NodeChildren() {
    }

    /**
     * Handles at for this component.
     *
     * @param index index
     * @return result
     */
    @Override
    public Node at(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        return null;
    }

    /**
     * Handles remove for this component.
     *
     * @param index index
     * @return result
     */
    @Override
    public Children remove(int index) {
        children.remove(index);
        return this;
    }

    /**
     * Handles length for this component.
     *
     * @return result
     */
    @Override
    public int length() {
        return children.size();
    }

    /**
     * Handles append for this component.
     *
     * @param child child
     * @return result
     */
    public Children append(Node child) {
        children.add(child);
        return this;
    }
}
