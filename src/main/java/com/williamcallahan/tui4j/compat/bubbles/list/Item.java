package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Port of Bubbles item.
 * Upstream: github.com/charmbracelet/bubbles/list/list.go
 */
public interface Item {

    /**
     * Returns the string used for filtering.
     *
     * @return filter value
     */
    String filterValue();
}
