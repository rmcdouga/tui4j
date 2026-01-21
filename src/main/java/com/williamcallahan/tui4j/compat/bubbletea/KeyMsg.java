package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.KeyType;

/**
 * Key press input message.
 * Bubble Tea: bubbletea/key.go
 */
public class KeyMsg implements Message {

    private final Key key;

    public KeyMsg(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public String key() {
        return key.toString();
    }

    public char[] runes() {
        return key.runes();
    }

    public KeyType type() {
        return key.type();
    }

    public boolean alt() {
        return key.alt();
    }
}
