package com.williamcallahan.tui4j.compat.lipgloss.tree;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Port of the Lip Gloss tree style callback.
 * Upstream: github.com/charmbracelet/lipgloss/tree (StyleFunc)
 * <p>
 * Lipgloss: tree/renderer.go.
 */
@FunctionalInterface
public interface StyleFunction {

    /**
     * Handles apply for this component.
     *
     * @param children children
     * @param index index
     * @return result
     */
    Style apply(Children children, int index);
}
