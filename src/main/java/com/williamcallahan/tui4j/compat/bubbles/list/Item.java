package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Interface for list items that can be filtered and displayed.
 * <p>
 * Port of charmbracelet/bubbles list/list.go Item interface.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/list/list.go">bubbles/list/list.go</a>
 * <p>
 * Bubbles: list/list.go.
 */
public interface Item {

    /**
     * Returns the value used for filtering this item.
     *
     * @return the filter value
     */
    String filterValue();
}
