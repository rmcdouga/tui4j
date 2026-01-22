package com.williamcallahan.tui4j.compat.lipgloss.tree;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Port of Lip Gloss tree style.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 */
public class TreeStyle {

    private StyleFunction enumeratorFunction;
    private StyleFunction itemFunction;
    private Style rootStyle;

    /**
     * Creates a tree style with default settings.
     */
    public TreeStyle() {
        this.enumeratorFunction = (children, index) -> Style.newStyle().paddingRight(1);
        this.itemFunction = (children, index) -> Style.newStyle();
        this.rootStyle = Style.newStyle();
    }

    /**
     * Returns the root style.
     *
     * @return root style
     */
    public Style rootStyle() {
        return rootStyle;
    }

    /**
     * Returns the enumerator style function.
     *
     * @return enumerator function
     */
    public StyleFunction enumeratorFunction() {
        return enumeratorFunction;
    }

    /**
     * Returns the item style function.
     *
     * @return item function
     */
    public StyleFunction itemFunction() {
        return itemFunction;
    }

    /**
     * Sets the enumerator style function.
     *
     * @param enumeratorFunction function to set
     */
    public void setEnumeratorFunction(StyleFunction enumeratorFunction) {
        this.enumeratorFunction = enumeratorFunction;
    }

    /**
     * Sets the root style.
     *
     * @param rootStyle style to set
     */
    public void setRootStyle(Style rootStyle) {
        this.rootStyle = rootStyle;
    }

    /**
     * Sets the item style function.
     *
     * @param itemFunction function to set
     */
    public void setItemFunction(StyleFunction itemFunction) {
        this.itemFunction = itemFunction;
    }
}
