package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea key.go KeyMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 */
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
