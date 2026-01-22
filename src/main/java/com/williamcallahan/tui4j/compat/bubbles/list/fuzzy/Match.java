package com.williamcallahan.tui4j.compat.bubbles.list.fuzzy;

import java.util.List;

/**
 * Port of Bubbles match.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 * <p>
 * Bubbles: list/list.go.
 */
public class Match {
    private String str;
    private int index;
    private List<Integer> matchedIndexes;
    private int score;

    /**
     * Creates a new match.
     *
     * @param str matching string
     * @param index item index
     * @param matchedIndexes matched indexes
     * @param score match score
     */
    public Match(String str, int index, List<Integer> matchedIndexes, int score) {
        this.str = str;
        this.index = index;
        this.matchedIndexes = matchedIndexes;
        this.score = score;
    }

    /**
     * Returns the matching string.
     *
     * @return matched string
     */
    public String getStr() {
        return str;
    }

    /**
     * Returns the item index.
     *
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the list of matched indexes in the string.
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
