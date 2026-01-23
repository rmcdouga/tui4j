package com.williamcallahan.tui4j.compat.bubbles.paginator;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles key map.
 * Bubble Tea: bubbletea/examples/paginator/main.go
 */
public class KeyMap {

    /**
     * Returns the default paginator key map.
     *
     * @return default key map
     */
    public static KeyMap defaultKeyMap() {
        return new KeyMap(
                new Binding(Binding.withKeys("pgup", "left", "h")),
                new Binding(Binding.withKeys("pgdown", "right", "l"))
        );
    }

    private Binding prevPage;
    private Binding nextPage;

    /**
     * Creates an empty key map.
     */
    public KeyMap() {
    }

    /**
     * Creates a key map with explicit bindings.
     *
     * @param prevPage previous-page binding
     * @param nextPage next-page binding
     */
    public KeyMap(Binding prevPage, Binding nextPage) {
        this.prevPage = prevPage;
        this.nextPage = nextPage;
    }

    /**
     * Returns the binding for the next page.
     *
     * @return next-page binding
     */
    public Binding nextPage() {
        return nextPage;
    }

    /**
     * Returns the binding for the previous page.
     *
     * @return previous-page binding
     */
    public Binding prevPage() {
        return prevPage;
    }
}
