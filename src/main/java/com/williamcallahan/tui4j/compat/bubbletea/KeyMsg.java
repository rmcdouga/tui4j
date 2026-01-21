package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;

/**
 * Message sent when a key is pressed.
 * <p>
 * Bubble Tea: bubbletea/key.go
 *
 * @deprecated Use {@link KeyPressMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class KeyMsg extends KeyPressMessage {

    /**
     * Creates a key message.
     *
     * @param key the key that was pressed
     * @deprecated Use {@link KeyPressMessage#KeyPressMessage(Key)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public KeyMsg(Key key) {
        super(key);
    }
}
