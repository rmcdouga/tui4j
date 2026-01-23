package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Port of the list filter function contract.
 * Upstream: github.com/charmbracelet/bubbles/list/list.go (FilterFunc)
 */
@FunctionalInterface
public interface FilterFunction {

    /**
     * Applies filtering to the provided targets.
     *
     * @param term filter term
     * @param targets candidate strings
     * @return ranked matches
     */
    Rank[] apply(String term, String[] targets);
}
