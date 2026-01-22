package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Port of Bubbles filter state.
 * Upstream: github.com/charmbracelet/bubbles/list/list.go
 */
public enum FilterState {
    /**
     * No filter is active.
     */
    Unfiltered("unfiltered"),
    /**
     * The user is currently entering a filter.
     */
    Filtering("filtering"),
    /**
     * A filter has been applied.
     */
    FilterApplied("filter applied");

    private final String stateName;

    /**
     * Creates a filter state label.
     *
     * @param stateName string value for display
     */
    FilterState(String stateName) {
        this.stateName = stateName;
    }

    /**
     * Returns the display name for the filter state.
     *
     * @return display name
     */
    @Override
    public String toString() {
        return stateName;
    }
}
