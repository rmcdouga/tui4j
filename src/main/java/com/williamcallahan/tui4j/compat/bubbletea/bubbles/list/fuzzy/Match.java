package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.fuzzy;

import java.util.List;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.Match} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Match extends com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.Match {

    /**
     * Creates a deprecated compatibility match wrapper.
     *
     * @param str matched string
     * @param index original item index
     * @param matchedIndexes matched rune indexes
     * @param score match score
     * @deprecated Deprecated in tui4j as of 0.3.0; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.Match} instead.
     */
    @Deprecated(since = "0.3.0")
    public Match(String str, int index, List<Integer> matchedIndexes, int score) {
        super(str, index, matchedIndexes, score);
    }

}
