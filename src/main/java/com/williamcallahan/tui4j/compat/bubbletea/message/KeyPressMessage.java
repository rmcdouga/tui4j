package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.KeyType;

/**
 * Key press input message.
 * Bubble Tea: bubbletea/key.go
 */
public class KeyPressMessage implements Message {

    private final Key key;

    /**
     * Creates a key press message for the provided key.
     *
     * @param key key input
     */
    public KeyPressMessage(Key key) {
        this.key = key;
    }

    /**
     * Returns the key name representation.
     *
     * @return key name
     */
    public String key() {
        return key.toString();
    }

    /**
     * Returns the runes for the key input.
     *
     * @return rune characters
     */
    public char[] runes() {
        return key.runes();
    }

    /**
     * Returns the key type.
     *
     * @return key type
     */
    public KeyType type() {
        return key.type();
    }

    /**
     * Returns whether the Alt modifier is pressed.
     *
     * @return true when Alt is pressed
     */
    public boolean alt() {
        return key.alt();
    }
}
