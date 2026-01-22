package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
 *             {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator} instead.
 *             This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lipgloss: tree/enumerator.go.
 */
@Deprecated(since = "0.3.0")
@FunctionalInterface
public interface TreeEnumerator
    extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.DefaultEnumerator} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    class DefaultEnumerator extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.DefaultEnumerator {

        /**
         * Creates a legacy default enumerator.
         *
         * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
         * {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.DefaultEnumerator} instead.
         */
        @Deprecated(since = "0.3.0")
        public DefaultEnumerator() {
        }
    }

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.RounderEnumerator} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    class RounderEnumerator extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.RounderEnumerator {

        /**
         * Creates a legacy rounded enumerator.
         *
         * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
         * {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator.RounderEnumerator} instead.
         */
        @Deprecated(since = "0.3.0")
        public RounderEnumerator() {
        }
    }
}
