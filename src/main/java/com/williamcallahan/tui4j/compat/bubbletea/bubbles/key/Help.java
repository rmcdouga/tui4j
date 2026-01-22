package com.williamcallahan.tui4j.compat.bubbletea.bubbles.key;

/**
 * Describes a key binding and its help text.
 *
 * @param key key binding string
 * @param desc help description
 * <p>
 * Bubbles: key/key.go.
 */
public record Help(String key, String desc) {
    /**
     * Creates Help to keep this component ready for use.
     */
    public Help() {
        this("", "");
    }
}
