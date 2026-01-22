package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Renderer} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: tree/renderer.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Renderer extends com.williamcallahan.tui4j.compat.lipgloss.tree.Renderer {

    private final TreeStyle styleShim;

    /**
     * Creates Renderer to keep this component ready for use.
     */
    public Renderer() {
        super();
        this.styleShim = new TreeStyle(super.style());
    }

    /**
     * Handles render for this component.
     *
     * @param node node
     * @param root root
     * @param prefix prefix
     * @return result
     */
    public String render(Node node, boolean root, String prefix) {
        return super.render(node, root, prefix);
    }

    /**
     * Handles style for this component.
     *
     * @return result
     */
    @Override
    public TreeStyle style() {
        return styleShim;
    }

    /**
     * Updates the enumerator.
     *
     * @param enumerator enumerator
     */
    public void setEnumerator(TreeEnumerator enumerator) {
        super.setEnumerator(enumerator);
    }

    /**
     * Updates the indenter.
     *
     * @param indenter indenter
     */
    public void setIndenter(TreeIndenter indenter) {
        super.setIndenter(indenter);
    }

    /**
     * Updates the enumerator.
     *
     * @param enumerator enumerator
     */
    @Override
    public void setEnumerator(com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator enumerator) {
        super.setEnumerator(enumerator);
    }

    /**
     * Updates the indenter.
     *
     * @param indenter indenter
     */
    @Override
    public void setIndenter(com.williamcallahan.tui4j.compat.lipgloss.tree.TreeIndenter indenter) {
        super.setIndenter(indenter);
    }
}
