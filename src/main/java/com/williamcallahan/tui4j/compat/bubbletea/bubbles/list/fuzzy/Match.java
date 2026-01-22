package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.fuzzy;

/**
 */
public class Match {
    private final int index;
    private final int patternIndex;

    /**
     * Creates Match to keep this component ready for use.
     *
     * @param index index
     * @param patternIndex pattern index
     */
    public Match(int index, int patternIndex) {
        this.index = index;
        this.patternIndex = patternIndex;
    }

    /**
     * Handles index for this component.
     *
     * @return result
     */
    public int index() {
        return index;
    }

    /**
     * Handles pattern index for this component.
     *
     * @return result
     */
    public int patternIndex() {
        return patternIndex;
    }
}
