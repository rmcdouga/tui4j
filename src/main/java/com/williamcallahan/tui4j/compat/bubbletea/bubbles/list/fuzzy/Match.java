package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.fuzzy;

import java.util.Collections;

/**
 * Fuzzy-match result for Bubble Tea-compatible list filtering.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/fuzzy/Match.java}.
 * <p>
 * Bubbles: list/list.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.Match}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * @since 0.3.0
 */
@Deprecated(since = "0.3.0")
public class Match extends com.williamcallahan.tui4j.compat.bubbles.list.fuzzy.Match {
    private final int index;
    private final int patternIndex;

    /**
     * Creates Match to keep this component ready for use.
     *
     * @param index index
     * @param patternIndex pattern index
     */
    public Match(int index, int patternIndex) {
        super(null, index, Collections.emptyList(), 0);
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
