package com.williamcallahan.tui4j.compat.bubbles.list;

import java.util.Arrays;
import java.util.Objects;

/**
 * Port of Bubbles rank.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 * <p>
 * Bubbles: list/list.go.
 */
public class Rank {
    private final int index;
    private final int[] matchedIndexes;

    /**
     * Creates Rank to keep this component ready for use.
     *
     * @param index index
     * @param matchedIndexes matched indexes
     */
    public Rank(int index, int[] matchedIndexes) {
        this.index = index;
        this.matchedIndexes = matchedIndexes;
    }

    /**
     * Returns the index.
     *
     * @return result
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the matched indexes.
     *
     * @return result
     */
    public int[] getMatchedIndexes() {
        return matchedIndexes;
    }

    /**
     * Handles equals for this component.
     *
     * @param obj obj
     * @return whether uals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rank rank = (Rank) obj;
        return index == rank.index && Arrays.equals(matchedIndexes, rank.matchedIndexes);
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(index) + Arrays.hashCode(matchedIndexes);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "Rank{" +
                "index=" + index +
                ", matchedIndexes=" + Arrays.toString(matchedIndexes) +
                '}';
    }
}
