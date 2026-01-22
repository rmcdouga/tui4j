package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: tree/enumerator.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
@FunctionalInterface
public interface TreeEnumerator
    extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator {

    /**
     * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.DefaultEnumerator} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    class DefaultEnumerator extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.DefaultEnumerator {
    }

    /**
     * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.RounderEnumerator} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    class RounderEnumerator extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.RounderEnumerator {
    }
}
