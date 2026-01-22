package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * @deprecated Compatibility shim for relocated type; use
 *             {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter} instead.
 *             This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lipgloss: tree/indenter.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
@FunctionalInterface
public interface TreeIndenter
    extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter {

    /**
     * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter.DefaultIndenter} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    class DefaultIndenter extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter.DefaultIndenter {
    }
}
