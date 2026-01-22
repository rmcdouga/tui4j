package com.williamcallahan.tui4j.compat.bubbles.key;

/**
 * Port of Bubbles help.
 * Upstream: github.com/charmbracelet/bubbles/key/key.go
 *
 * @param key key binding label
 * @param desc help description
 */
public record Help(String key, String desc) {

    /**
     * Creates an empty help entry.
     */
    public Help() {
        this("", "");
    }
}
