package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
 *             {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter} instead.
 *             This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lipgloss: tree/indenter.go.
 */
@Deprecated(since = "0.3.0")
@FunctionalInterface
public interface TreeIndenter
    extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter.DefaultIndenter} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    class DefaultIndenter extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter.DefaultIndenter {

        /**
         * Creates a legacy default indenter.
         *
         * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
         * {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter.DefaultIndenter} instead.
         */
        @Deprecated(since = "0.3.0")
        public DefaultIndenter() {
        }
    }
}
