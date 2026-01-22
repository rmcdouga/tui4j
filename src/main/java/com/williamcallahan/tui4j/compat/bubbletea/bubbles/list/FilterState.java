package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * Port of Bubbles filter state.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 */
@Deprecated(since = "0.3.0")
public enum FilterState {
    /** No filter is set. */
    Unfiltered("unfiltered"),
    /** User is actively setting a filter. */
    Filtering("filtering"),
    /** A filter has been applied. */
    FilterApplied("filter applied");

    private final String stateName;

    /**
     * Creates a filter state with a display name.
     *
     * @param stateName display name
     */
    FilterState(String stateName) {
        this.stateName = stateName;
    }

    /**
     * Returns the display name for this state.
     *
     * @return display name
     */
    @Override
    public String toString() {
        return stateName;
    }
}
