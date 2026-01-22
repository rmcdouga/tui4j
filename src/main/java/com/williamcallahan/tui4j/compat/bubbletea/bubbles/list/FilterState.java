package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.FilterState}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @see com.williamcallahan.tui4j.compat.bubbles.list.FilterState
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public enum FilterState {
    Unfiltered,
    Filtering,
    FilterApplied;

    /**
     * Converts this deprecated enum value to the canonical enum value.
     * @return the canonical enum value
     */
    public com.williamcallahan.tui4j.compat.bubbles.list.FilterState toCanonical() {
        return switch (this) {
            case Unfiltered -> com.williamcallahan.tui4j.compat.bubbles.list.FilterState.Unfiltered;
            case Filtering -> com.williamcallahan.tui4j.compat.bubbles.list.FilterState.Filtering;
            case FilterApplied -> com.williamcallahan.tui4j.compat.bubbles.list.FilterState.FilterApplied;
        };
    }

    /**
     * Converts a canonical enum value to this deprecated enum value.
     * @param canonical the canonical enum value
     * @return the deprecated enum value
     */
    public static FilterState fromCanonical(com.williamcallahan.tui4j.compat.bubbles.list.FilterState canonical) {
        if (canonical == null) return null;
        return switch (canonical) {
            case Unfiltered -> Unfiltered;
            case Filtering -> Filtering;
            case FilterApplied -> FilterApplied;
        };
    }
}
