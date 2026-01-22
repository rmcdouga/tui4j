package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.fuzzy;

import com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.Rank;


/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/fuzzy/FuzzyFilter.java}.
 * <p>
 * Bubbles: list/list.go.
 *
 */
public final class FuzzyFilter {

    /**
     * Prevents instantiation of the deprecated shim.
     */
    private FuzzyFilter() {}

    /**
     * @deprecated Compatibility: Use
     * {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter#defaultFilter(String, String[])}.
     * @param term search term
     * @param targets targets to rank
     * @return ranked matches
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static Rank[] defaultFilter(String term, String[] targets) {
        return toLegacy(com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter.defaultFilter(term, targets));
    }

    /**
     * @deprecated Compatibility: Use
     * {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter#unsortedFilter(String, String[])}.
     * @param term search term
     * @param targets targets to rank
     * @return ranked matches
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static Rank[] unsortedFilter(String term, String[] targets) {
        return toLegacy(com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter.unsortedFilter(term, targets));
    }

    /**
     * Converts canonical ranks to legacy ranks.
     *
     * @param canonical canonical ranks
     * @return legacy ranks
     */
    private static Rank[] toLegacy(com.williamcallahan.tui4j.compat.bubbles.list.Rank[] canonical) {
        Rank[] legacy = new Rank[canonical.length];
        for (int i = 0; i < canonical.length; i++) {
            com.williamcallahan.tui4j.compat.bubbles.list.Rank rank = canonical[i];
            legacy[i] = new Rank(rank.getIndex(), rank.getMatchedIndexes());
        }
        return legacy;
    }
}
