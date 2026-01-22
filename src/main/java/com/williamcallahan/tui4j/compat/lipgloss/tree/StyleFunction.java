package com.williamcallahan.tui4j.compat.lipgloss.tree;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Port of the Lip Gloss tree style callback.
 * Upstream: github.com/charmbracelet/lipgloss/tree (StyleFunc)
 */
@FunctionalInterface
public interface StyleFunction {

    /**
     * Returns the style for a node at the given index.
     *
     * @param children children collection
     * @param index node index
     * @return style for the node
     */
    Style apply(Children children, int index);
}
