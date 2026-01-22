package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * Leaf node in a tree structure.
 * <p>
 * Lipgloss: tree/tree.go
 *
 * @deprecated <b>tui4j compat refactor:</b> Moved to
 *             {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Leaf}.
 *             This transitional shim preserves backward compatibility and will be removed
 *             in a future release. Migrate to the canonical location.
 * @since 0.3.0
 * @see com.williamcallahan.tui4j.compat.lipgloss.tree.Leaf
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Leaf extends com.williamcallahan.tui4j.compat.lipgloss.tree.Leaf {

    /**
     * Creates a Leaf with the given string value.
     *
     * @param value the leaf value
     */
    public Leaf(String value) {
        super(value);
    }
}
