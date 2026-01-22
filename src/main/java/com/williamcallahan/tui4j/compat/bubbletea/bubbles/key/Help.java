package com.williamcallahan.tui4j.compat.bubbletea.bubbles.key;

/**
 * Describes a key binding and its help text.
 *
 * @param key key binding string
 * @param desc help description
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.key.Help}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: key/key.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record Help(String key, String desc) {
    /**
     * Creates Help to keep this component ready for use.
     */
    public Help() {
        this("", "");
    }
}
