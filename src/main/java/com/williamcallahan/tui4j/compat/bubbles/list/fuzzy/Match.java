package com.williamcallahan.tui4j.compat.bubbles.list.fuzzy;

import java.util.List;

/**
 * Port of Bubbles match.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 */
public class Match {
    private String str;
    private int index;
    private List<Integer> matchedIndexes;
    private int score;

    /**
     * Creates a fuzzy match result.
     *
     * @param str matched string
     * @param index original item index
     * @param matchedIndexes matched rune indexes
     * @param score match score
     */
    public Match(String str, int index, List<Integer> matchedIndexes, int score) {
        this.str = str;
        this.index = index;
        this.matchedIndexes = matchedIndexes;
        this.score = score;
    }

    /**
     * Returns the matched string.
     *
     * @return matched string
     */
    public String getStr() {
        return str;
    }

    /**
     * Returns the original item index.
     *
     * @return original index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the matched rune indexes.
     *
     * @return matched indexes
     */
    public List<Integer> getMatchedIndexes() {
        return matchedIndexes;
    }

    /**
     * Returns the match score.
     *
     * @return score
     */
    public int getScore() {
        return score;
    }
}
