package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;

/**
 * Compatibility shim for {@link KeyMsg}.
 */
public class KeyPressMessage extends KeyMsg implements MessageShim {

    public KeyPressMessage(Key key) {
        super(key);
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
