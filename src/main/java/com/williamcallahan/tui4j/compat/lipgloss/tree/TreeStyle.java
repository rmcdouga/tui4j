package com.williamcallahan.tui4j.compat.lipgloss.tree;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Port of Lip Gloss tree style.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: tree/tree.go.
 */
public class TreeStyle {

    private StyleFunction enumeratorFunction;
    private StyleFunction itemFunction;
    private Style rootStyle;

    /**
     * Creates TreeStyle to keep this component ready for use.
     */
    public TreeStyle() {
        this.enumeratorFunction = (children, index) -> Style.newStyle().paddingRight(1);
        this.itemFunction = (children, index) -> Style.newStyle();
        this.rootStyle = Style.newStyle();
    }

    /**
     * Handles root style for this component.
     *
     * @return result
     */
    public Style rootStyle() {
        return rootStyle;
    }

    /**
     * Handles enumerator function for this component.
     *
     * @return result
     */
    public StyleFunction enumeratorFunction() {
        return enumeratorFunction;
    }

    /**
     * Handles item function for this component.
     *
     * @return result
     */
    public StyleFunction itemFunction() {
        return itemFunction;
    }

    /**
     * Updates the enumerator function.
     *
     * @param enumeratorFunction enumerator function
     */
    public void setEnumeratorFunction(StyleFunction enumeratorFunction) {
        this.enumeratorFunction = enumeratorFunction;
    }

    /**
     * Updates the root style.
     *
     * @param rootStyle root style
     */
    public void setRootStyle(Style rootStyle) {
        this.rootStyle = rootStyle;
    }

    /**
     * Updates the item function.
     *
     * @param itemFunction item function
     */
    public void setItemFunction(StyleFunction itemFunction) {
        this.itemFunction = itemFunction;
    }
}
