package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

import com.williamcallahan.tui4j.compat.bubbletea.bubbles.key.Binding;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.paginator.KeyMap} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class KeyMap extends com.williamcallahan.tui4j.compat.bubbles.paginator.KeyMap {

    /**
     * Creates a paginator key map shim.
     */
    @Deprecated(since = "0.3.0")
    public KeyMap() {
        super();
    }

    /**
     * Creates a paginator key map with explicit bindings.
     *
     * @param prevPage previous-page binding
     * @param nextPage next-page binding
     */
    @Deprecated(since = "0.3.0")
    public KeyMap(Binding prevPage, Binding nextPage) {
        super(prevPage, nextPage);
    }

}
