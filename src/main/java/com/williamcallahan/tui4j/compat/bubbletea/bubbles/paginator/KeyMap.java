package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.paginator.KeyMap} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: paginator/paginator.go.
 */
@Deprecated(since = "0.3.0")
public class KeyMap extends com.williamcallahan.tui4j.compat.bubbles.paginator.KeyMap {

    /**
     * Creates a paginator key map shim.
     */
    public KeyMap() {
        super();
    }
    /**
     * Handles prev page for this component.
     *
     * @return result
     */
    @Override
    public Binding prevPage() {
        return super.prevPage();
    }

    /**
     * Handles next page for this component.
     *
     * @return result
     */
    @Override
    public Binding nextPage() {
        return super.nextPage();
    }
}
