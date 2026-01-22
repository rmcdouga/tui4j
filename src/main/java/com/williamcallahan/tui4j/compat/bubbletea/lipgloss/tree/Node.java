package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

import java.util.List;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Node} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: tree/tree.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public interface Node extends com.williamcallahan.tui4j.compat.lipgloss.tree.Node {
    /**
     * Handles value for this component.
     *
     * @return result
     */
    @Override
    String value();

    /**
     * Handles children for this component.
     *
     * @return result
     */
    @Override
    Children children();
}
