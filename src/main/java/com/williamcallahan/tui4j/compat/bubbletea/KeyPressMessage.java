package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.KeyType;

/**
 * Message sent when a key is pressed.
 * <p>
 * Bubble Tea: bubbletea/key.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 */
public class KeyPressMessage implements Message {

    private final Key key;

    /**
     * Creates a key press message.
     *
     * @param key the key that was pressed
     */
    public KeyPressMessage(Key key) {
        this.key = key;
    }

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Returns the key string representation.
     *
     * @return the key string
     */
    public String key() {
        return key.toString();
    }

    /**
     * Returns the key runes.
     *
     * @return the runes
     */
    public char[] runes() {
        return key.runes();
    }

    /**
     * Returns the key type.
     *
     * @return the key type
     */
    public KeyType type() {
        return key.type();
    }

    /**
     * Returns whether alt was pressed.
     *
     * @return true if alt was pressed
     */
    public boolean alt() {
        return key.alt();
    }
}
