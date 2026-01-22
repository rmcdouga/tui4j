package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.fuzzy;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/fuzzy/FuzzyFilter.java}.
 * <p>
 * Bubbles: list/list.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @since 0.3.0
 */
@Deprecated(since = "0.3.0")
public final class FuzzyFilter
    extends com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter {

    /**
     * Prevents instantiation of the deprecated shim.
     */
    private FuzzyFilter() {}

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility alias was replaced; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter#defaultFilter(String, String[])}.
     * @param term search term
     * @param targets targets to rank
     * @return ranked matches
     */
    @Deprecated(since = "0.3.0")
    public static com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.Rank[] defaultFilter(
        String term,
        String[] targets
    ) {
        return toLegacy(com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter.defaultFilter(term, targets));
    }

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility alias was replaced; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter#unsortedFilter(String, String[])}.
     * @param term search term
     * @param targets targets to rank
     * @return ranked matches
     */
    @Deprecated(since = "0.3.0")
    public static com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.Rank[] unsortedFilter(
        String term,
        String[] targets
    ) {
        return toLegacy(com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.FuzzyFilter.unsortedFilter(term, targets));
    }

    /**
     * Converts canonical ranks to legacy ranks.
     *
     * @param canonical canonical ranks
     * @return legacy ranks
     */
    private static com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.Rank[] toLegacy(
        com.williamcallahan.tui4j.compat.bubbles.list.Rank[] canonical
    ) {
        com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.Rank[] legacy =
            new com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.Rank[canonical.length];
        for (int i = 0; i < canonical.length; i++) {
            com.williamcallahan.tui4j.compat.bubbles.list.Rank rank = canonical[i];
            legacy[i] = new com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.Rank(
                rank.getIndex(),
                rank.getMatchedIndexes()
            );
        }
        return legacy;
    }
}
