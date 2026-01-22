package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * Port of the Lip Gloss tree indenter.
 * Upstream: github.com/charmbracelet/lipgloss/tree (Indenter)
 * <p>
 * Lipgloss: tree/enumerator.go.
 */
@FunctionalInterface
public interface TreeIndenter {

    /**
     * Compatibility port of DefaultIndenter to preserve upstream behavior.
     * <p>
     * Lipgloss: tree/enumerator.go.
     */
    class DefaultIndenter implements TreeIndenter {

        /**
         * Creates a default indenter.
         */
        public DefaultIndenter() {
        }

        /**
         * Handles indent for this component.
         *
         * @param children children
         * @param index index
         * @return result
         */
        @Override
        public String indent(Children children, int index) {
            if (children.length() - 1 == index) {
                return "   ";
            }
            return "│  ";
        }
    }

    /**
     * Handles indent for this component.
     *
     * @param children children
     * @param index index
     * @return result
     */
    String indent(Children children, int index);
}
