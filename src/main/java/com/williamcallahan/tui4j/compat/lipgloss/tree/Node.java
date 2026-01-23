package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * Port of Lip Gloss tree nodes.
 * Upstream: lipgloss/tree/tree.go
 */
public interface Node {

    /**
     * Returns the display value for this node.
     *
     * @return node value
     */
    String value();

    /**
     * Returns this node's children.
     *
     * @return child nodes
     */
    Children children();

    /**
     * Reports whether this node is hidden.
     *
     * @return {@code true} when hidden
     */
    boolean isHidden();
}
