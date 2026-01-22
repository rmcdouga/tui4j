package com.williamcallahan.tui4j.compat.bubbles.list;

import java.util.Arrays;
import java.util.Objects;

/**
 * Port of Bubbles rank.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 */
public class Rank {
    private final int index;
    private final int[] matchedIndexes;

    /**
     * Creates a rank entry for a matched item.
     *
     * @param index matched item index
     * @param matchedIndexes matched rune indexes
     */
    public Rank(int index, int[] matchedIndexes) {
        this.index = index;
        this.matchedIndexes = matchedIndexes;
    }

    /**
     * Returns the matched item index.
     *
     * @return item index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the matched rune indexes.
     *
     * @return matched indexes
     */
    public int[] getMatchedIndexes() {
        return matchedIndexes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rank rank = (Rank) obj;
        return index == rank.index && Arrays.equals(matchedIndexes, rank.matchedIndexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index) + Arrays.hashCode(matchedIndexes);
    }

    @Override
    public String toString() {
        return "Rank{" +
                "index=" + index +
                ", matchedIndexes=" + Arrays.toString(matchedIndexes) +
                '}';
    }
}
