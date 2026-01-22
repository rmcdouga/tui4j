package com.williamcallahan.tui4j.compat.bubbletea.bubbles.key;

/**
 * Port of Bubbles help.
 * Bubble Tea: bubbletea/examples/help/main.go
 *
 * @param key key binding label
 * @param desc key binding description
 */
@Deprecated(since = "0.3.0")
public record Help(String key, String desc) {

    /**
     * Creates an empty help entry.
     */
    public Help() {
        this("", "");
    }
}
