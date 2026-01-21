package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Function for filtering list items by a search term.
 * <p>
 * Port of charmbracelet/bubbles list/list.go FilterFunc type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/list/list.go">bubbles/list/list.go</a>
 */
@FunctionalInterface
public interface FilterFunction {

    /**
     * Applies the filter to the given targets.
     *
     * @param term the search term
     * @param targets the strings to filter against
     * @return ranked results for matching items
     */
    Rank[] apply(String term, String[] targets);
}
