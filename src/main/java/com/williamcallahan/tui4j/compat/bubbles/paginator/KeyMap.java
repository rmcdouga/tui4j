package com.williamcallahan.tui4j.compat.bubbles.paginator;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles key map.
 * Bubble Tea: bubbletea/examples/paginator/main.go
 */
public class KeyMap {

    /**
     * Returns the default key map.
     *
     * @return the default key map
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
     * Creates a new empty key map.
     */
    public KeyMap() {
    }

    /**
     * Creates a new key map with the given bindings.
     *
     * @param prevPage binding for previous page
     * @param nextPage binding for next page
     */
    public KeyMap(Binding prevPage, Binding nextPage) {
        this.prevPage = prevPage;
        this.nextPage = nextPage;
    }

    /**
     * @return key binding for next page
     */
    public Binding nextPage() {
        return nextPage;
    }

    /**
     * @return key binding for previous page
     */
    public Binding prevPage() {
        return prevPage;
    }
}
