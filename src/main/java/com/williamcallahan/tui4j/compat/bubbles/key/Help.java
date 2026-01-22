package com.williamcallahan.tui4j.compat.bubbles.key;

/**
 * Help text for a key binding, consisting of a key label and description.
 * <p>
 * Port of charmbracelet/bubbles key/key.go Help type.
 *
 * @param key the key binding label (e.g., "ctrl+c")
 * @param desc the help description (e.g., "quit")
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/key/key.go">bubbles/key/key.go</a>
 * <p>
 * Bubbles: key/key.go.
 */
public record Help(String key, String desc) {

    /** Creates an empty help record. */
    public Help() {
        this("", "");
    }
}
