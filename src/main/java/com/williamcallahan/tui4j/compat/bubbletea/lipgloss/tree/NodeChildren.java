package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.NodeChildren} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: tree/children.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class NodeChildren extends com.williamcallahan.tui4j.compat.lipgloss.tree.NodeChildren implements Children {
    /**
     * Creates NodeChildren to keep this component ready for use.
     *
     * @param children children
     */
    public NodeChildren(List<Node> children) {
        super(toNewList(children));
    }

    /**
     * Creates NodeChildren to keep this component ready for use.
     */
    public NodeChildren() {
        super();
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

    /**
     * Handles to new list for this component.
     *
     * @param children children
     * @return result
     */
    private static List<com.williamcallahan.tui4j.compat.lipgloss.tree.Node> toNewList(List<Node> children) {
        List<com.williamcallahan.tui4j.compat.lipgloss.tree.Node> list = new ArrayList<>(children.size());
        for (Node child : children) {
            list.add(child);
        }
        return list;
    }
}
