package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Port of Bubbles default item contract.
 * Bubbles: list/defaultitem.go.
 * <p>
 * Bubbles: filepicker/hidden_windows.go.
 */
public interface DefaultItem extends Item {

    /**
     * Returns the item title.
     *
     * @return title text
     */
    String title();

    /**
     * Returns the item description.
     *
     * @return description text
     */
    String description();
}
