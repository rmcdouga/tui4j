package com.williamcallahan.tui4j.compat.lipgloss;

import java.util.HashSet;
import java.util.Set;

/**
 * Rune styling utilities for lipgloss.
 * <p>
 * Port of github.com/charmbracelet/lipgloss/runes.go.
 */
public class Runes {

    /**
     * Handles style runes for this component.
     *
     * @param input input
     * @param indices indices
     * @param matched matched
     * @param unmatched unmatched
     * @return result
     */
    public static String styleRunes(String input, int[] indices, Style matched, Style unmatched) {
        // Convert indices to a Set for faster lookups
        Set<Integer> indexSet = new HashSet<>();
        for (int index : indices) {
            indexSet.add(index);
        }

        StringBuilder out = new StringBuilder();
        StringBuilder group = new StringBuilder();
        Style style;

        char[] runes = input.toCharArray();

        for (int i = 0; i < runes.length; i++) {
            group.append(runes[i]);

            boolean matches = indexSet.contains(i);
            boolean nextMatches = indexSet.contains(i + 1);

            if (matches != nextMatches || i == runes.length - 1) {
                style = matches ? matched : unmatched;
                out.append(style.render(group.toString()));
                group.setLength(0); // Reset the group
            }
        }
        return out.toString();
    }

}
