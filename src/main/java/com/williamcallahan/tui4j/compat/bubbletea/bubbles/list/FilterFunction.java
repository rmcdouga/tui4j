package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.FilterFunction}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FilterFunction.java}.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.FilterFunction}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
@FunctionalInterface
public interface FilterFunction extends com.williamcallahan.tui4j.compat.bubbles.list.FilterFunction {

    /**
     * Applies the filter function.
     *
     * @param term filter term
     * @param targets target values
     * @return ranked matches
     */
    @Override
    Rank[] apply(String term, String[] targets);
}
