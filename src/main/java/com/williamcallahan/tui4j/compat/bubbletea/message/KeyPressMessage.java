package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea key.go KeyMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage} instead.
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class KeyPressMessage extends com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage {

    /**
     * Creates a key press message.
     *
     * @param key the pressed key
     */
    public KeyPressMessage(Key key) {
        super(key);
    }
}
