package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Represents the current filtering state of a list component.
 * <p>
 * Port of charmbracelet/bubbles list/list.go FilterState type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/list/list.go">bubbles/list/list.go</a>
 * <p>
 * Bubbles: list/list.go.
 */
public enum FilterState {
    /** No filter is currently set. */
    Unfiltered("unfiltered"),
    /** User is actively typing a filter term. */
    Filtering("filtering"),
    /** A filter has been applied and results are shown. */
    FilterApplied("filter applied");

    private final String stateName;

    /**
     * Creates FilterState to keep this component ready for use.
     *
     * @param stateName state name
     */
    FilterState(String stateName) {
        this.stateName = stateName;
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return stateName;
    }
}
