package com.williamcallahan.tui4j.compat.bubbles.list.fuzzy;

import org.apache.commons.text.similarity.FuzzyScore;
import com.williamcallahan.tui4j.compat.bubbles.list.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Fuzzy matching filter for list items.
 * <p>
 * Port of charmbracelet/bubbles list/list.go DefaultFilter function.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/list/list.go">bubbles/list/list.go</a>
 * <p>
 * Bubbles: list/list.go.
 */
public class FuzzyFilter {

    /**
     * Creates FuzzyFilter to keep this component ready for use.
     * <p>
     * Protected to allow legacy compatibility shims.
     */
    protected FuzzyFilter() {}

    /**
     * Filters and ranks targets by fuzzy matching against a search term.
     * Results are sorted by match quality.
     *
     * @param term the search term
     * @param targets the strings to match against
     * @return ranked results for matching items
     */
    public static Rank[] defaultFilter(String term, String[] targets) {
        return filter(term, targets, true);
    }

    /**
     * Filters targets by fuzzy matching without sorting.
     *
     * @param term the search term
     * @param targets the strings to match against
     * @return ranked results in original order
     */
    public static Rank[] unsortedFilter(String term, String[] targets) {
        return filter(term, targets, false);
    }

    /**
     * Handles filter for this component.
     *
     * @param term term
     * @param targets targets
     * @param sort sort
     * @return result
     */
    private static Rank[] filter(String term, String[] targets, boolean sort) {
        FuzzyScore fuzzyScore = new FuzzyScore(Locale.ENGLISH);

        List<Rank> ranks = new ArrayList<>();
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int score = fuzzyScore.fuzzyScore(target, term);

            // Only consider matches if all characters in the term are found in order
            if (score > 0 && isValidMatch(term, target)) {
                int[] matchedIndexes = findMatchedIndexes(term, target);
                ranks.add(new Rank(i, matchedIndexes));
            }
        }

        if (sort) {
            ranks.sort((r1, r2) -> {
                int score1 = fuzzyScore.fuzzyScore(targets[r1.getIndex()], term);
                int score2 = fuzzyScore.fuzzyScore(targets[r2.getIndex()], term);
                if (score1 != score2) return Integer.compare(score2, score1);
                return Integer.compare(r1.getIndex(), r2.getIndex());
            });
        }

        return ranks.toArray(new Rank[0]);
    }

    /**
     * Reports whether valid match.
     *
     * @param term term
     * @param target target
     * @return whether valid match
     */
    private static boolean isValidMatch(String term, String target) {
        int termIndex = 0;
        for (int i = 0; i < target.length() && termIndex < term.length(); i++) {
            if (Character.toLowerCase(target.charAt(i)) == Character.toLowerCase(term.charAt(termIndex))) {
                termIndex++;
            }
        }
        // A match is valid only if the entire term is matched
        return termIndex == term.length();
    }

    /**
     * Handles find matched indexes for this component.
     *
     * @param term term
     * @param target target
     * @return result
     */
    private static int[] findMatchedIndexes(String term, String target) {
        List<Integer> matchedIndexes = new ArrayList<>();
        int termIndex = 0;

        for (int i = 0; i < target.length() && termIndex < term.length(); i++) {
            if (Character.toLowerCase(target.charAt(i)) == Character.toLowerCase(term.charAt(termIndex))) {
                matchedIndexes.add(i);
                termIndex++;
            }
        }

        return matchedIndexes.stream().mapToInt(Integer::intValue).toArray();
    }
}
