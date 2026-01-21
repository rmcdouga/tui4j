package com.williamcallahan.tui4j.compat.bubbles.list;

/**
 * Represents the current filtering state of a list component.
 * <p>
 * Port of charmbracelet/bubbles list/list.go FilterState type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/list/list.go">bubbles/list/list.go</a>
 */
public enum FilterState {
    /** No filter is currently set. */
    Unfiltered("unfiltered"),
    /** User is actively typing a filter term. */
    Filtering("filtering"),
    /** A filter has been applied and results are shown. */
    FilterApplied("filter applied");

    private final String stateName;

    FilterState(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return stateName;
    }
}
