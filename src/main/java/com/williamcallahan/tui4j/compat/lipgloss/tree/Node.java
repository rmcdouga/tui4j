package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * Port of Lip Gloss node.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: tree/tree.go.
 */
public interface Node {

    /**
     * Returns the value of the node.
     *
     * @return the value
     */
    String value();

    /**
     * Returns the children of the node.
     *
     * @return the children
     */
    Children children();

    /**
     * Returns whether the node is hidden.
     *
     * @return true if hidden
     */
    boolean isHidden();
}
