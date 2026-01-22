package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.list.Rank} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0")
public class Rank extends com.williamcallahan.tui4j.compat.bubbles.list.Rank {
    
    /**
     * Creates Rank to keep this component ready for use.
     *
     * @param index index
     * @param matchedIndexes matched indexes
     */
    public Rank(int index, int[] matchedIndexes) {
        super(index, matchedIndexes);
    }
}
