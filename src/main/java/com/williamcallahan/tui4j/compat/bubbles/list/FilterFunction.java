package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Port of the list filter function contract.
 * Upstream: github.com/charmbracelet/bubbles/list (FilterFunc)
 * <p>
 * Bubbles: list/list.go.
 */
@FunctionalInterface
public interface FilterFunction {

    /**
     * Handles apply for this component.
     *
     * @param term term
     * @param targets targets
     * @return result
     */
    Rank[] apply(String term, String[] targets);
}
