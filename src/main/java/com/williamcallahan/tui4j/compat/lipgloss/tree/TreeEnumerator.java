package com.williamcallahan.tui4j.compat.lipgloss.tree;

/**
 * Port of the Lip Gloss tree enumerator.
 * Upstream: github.com/charmbracelet/lipgloss/tree (Enumerator)
 * <p>
 * Lipgloss: tree/enumerator.go.
 */
@FunctionalInterface
public interface TreeEnumerator {

    /**
     * Compatibility port of DefaultEnumerator to preserve upstream behavior.
     * <p>
     * Lipgloss: tree/enumerator.go.
     */
    class DefaultEnumerator implements TreeEnumerator {

        /**
         * Handles enumerate for this component.
         *
         * @param children children
         * @param index index
         * @return result
         */
        @Override
        public String enumerate(Children children, int index) {
            if (children.length() - 1 == index) {
                return "└──";
            }
            return "├──";
        }
    }

    /**
     * Compatibility port of RounderEnumerator to preserve upstream behavior.
     * <p>
     * Lipgloss: tree/enumerator.go.
     */
    class RounderEnumerator implements TreeEnumerator {

        /**
         * Handles enumerate for this component.
         *
         * @param children children
         * @param index index
         * @return result
         */
        @Override
        public String enumerate(Children children, int index) {
            if (children.length() - 1 == index) {
                return "╰──";
            }
            return "├──";
        }
    }

    /**
     * Handles enumerate for this component.
     *
     * @param children children
     * @param index index
     * @return result
     */
    String enumerate(Children children, int index);
}
