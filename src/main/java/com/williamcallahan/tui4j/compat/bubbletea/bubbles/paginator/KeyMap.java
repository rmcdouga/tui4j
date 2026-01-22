package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.paginator.KeyMap} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: paginator/paginator.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class KeyMap extends com.williamcallahan.tui4j.compat.bubbles.paginator.KeyMap {
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
