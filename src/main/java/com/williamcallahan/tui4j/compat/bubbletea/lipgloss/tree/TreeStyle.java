package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.TreeStyle} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: tree/tree.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class TreeStyle extends com.williamcallahan.tui4j.compat.lipgloss.tree.TreeStyle {

    private final com.williamcallahan.tui4j.compat.lipgloss.tree.TreeStyle delegate;

    /**
     * Creates TreeStyle to keep this component ready for use.
     */
    public TreeStyle() {
        super();
        this.delegate = this;
        super.setEnumeratorFunction((children, index) -> Style.newStyle().paddingRight(1));
        super.setItemFunction((children, index) -> Style.newStyle());
        super.setRootStyle(Style.newStyle());
    }

    /**
     * Creates TreeStyle to keep this component ready for use.
     *
     * @param delegate delegate
     */
    TreeStyle(com.williamcallahan.tui4j.compat.lipgloss.tree.TreeStyle delegate) {
        super();
        this.delegate = delegate;
        this.delegate.setEnumeratorFunction((children, index) -> Style.newStyle().paddingRight(1));
        this.delegate.setItemFunction((children, index) -> Style.newStyle());
        this.delegate.setRootStyle(Style.newStyle());
    }

    /**
     * Handles root style for this component.
     *
     * @return result
     */
    @Override
    public Style rootStyle() {
        if (delegate == this) {
            return (Style) super.rootStyle();
        }
        return (Style) delegate.rootStyle();
    }

    /**
     * Handles enumerator function for this component.
     *
     * @return result
     */
    @Override
    public StyleFunction enumeratorFunction() {
        if (delegate == this) {
            return (StyleFunction) super.enumeratorFunction();
        }
        return (StyleFunction) delegate.enumeratorFunction();
    }

    /**
     * Handles item function for this component.
     *
     * @return result
     */
    @Override
    public StyleFunction itemFunction() {
        if (delegate == this) {
            return (StyleFunction) super.itemFunction();
        }
        return (StyleFunction) delegate.itemFunction();
    }

    /**
     * Updates the enumerator function.
     *
     * @param enumeratorFunction enumerator function
     */
    public void setEnumeratorFunction(StyleFunction enumeratorFunction) {
        if (delegate == this) {
            super.setEnumeratorFunction(enumeratorFunction);
            return;
        }
        delegate.setEnumeratorFunction(enumeratorFunction);
    }

    /**
     * Updates the enumerator function.
     *
     * @param enumeratorFunction enumerator function
     */
    @Override
    public void setEnumeratorFunction(com.williamcallahan.tui4j.compat.lipgloss.tree.StyleFunction enumeratorFunction) {
        if (delegate == this) {
            super.setEnumeratorFunction(enumeratorFunction);
            return;
        }
        delegate.setEnumeratorFunction(enumeratorFunction);
    }

    /**
     * Updates the root style.
     *
     * @param rootStyle root style
     */
    public void setRootStyle(Style rootStyle) {
        if (delegate == this) {
            super.setRootStyle(rootStyle);
            return;
        }
        delegate.setRootStyle(rootStyle);
    }

    /**
     * Updates the root style.
     *
     * @param rootStyle root style
     */
    @Override
    public void setRootStyle(com.williamcallahan.tui4j.compat.lipgloss.Style rootStyle) {
        if (delegate == this) {
            super.setRootStyle(rootStyle);
            return;
        }
        delegate.setRootStyle(rootStyle);
    }

    /**
     * Updates the item function.
     *
     * @param itemFunction item function
     */
    public void setItemFunction(StyleFunction itemFunction) {
        if (delegate == this) {
            super.setItemFunction(itemFunction);
            return;
        }
        delegate.setItemFunction(itemFunction);
    }

    /**
     * Updates the item function.
     *
     * @param itemFunction item function
     */
    @Override
    public void setItemFunction(com.williamcallahan.tui4j.compat.lipgloss.tree.StyleFunction itemFunction) {
        if (delegate == this) {
            super.setItemFunction(itemFunction);
            return;
        }
        delegate.setItemFunction(itemFunction);
    }
}
