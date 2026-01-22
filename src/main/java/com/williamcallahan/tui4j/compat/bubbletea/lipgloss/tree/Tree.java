package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * Tree component for rendering hierarchical data.
 * <p>
 * Lipgloss: tree/tree.go
 *
 * @deprecated <b>tui4j compat refactor:</b> Moved to
 *             {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Tree}.
 *             This transitional shim preserves backward compatibility and will be removed
 *             in a future release. Migrate to the canonical location.
 * @since 0.3.0
 * @see com.williamcallahan.tui4j.compat.lipgloss.tree.Tree
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Tree extends com.williamcallahan.tui4j.compat.lipgloss.tree.Tree {

    /**
     * Creates an empty Tree.
     */
    public Tree() {
        super();
    }
}
