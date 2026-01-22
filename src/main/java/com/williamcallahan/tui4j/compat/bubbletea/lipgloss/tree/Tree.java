package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * Tree component for rendering hierarchical data.
 * <p>
 * Lipgloss: tree/tree.go
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because of a compat refactor; use
 *             {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Tree}.
 *             This transitional shim preserves backward compatibility and will be removed
 *             in a future release. Migrate to the canonical location.
 * @since 0.3.0
 * @see com.williamcallahan.tui4j.compat.lipgloss.tree.Tree
 */
@Deprecated(since = "0.3.0")
public class Tree extends com.williamcallahan.tui4j.compat.lipgloss.tree.Tree {

    /**
     * Creates an empty Tree.
     */
    public Tree() {
        super();
    }
}
