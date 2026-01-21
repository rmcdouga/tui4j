package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.KeyType;

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
public class KeyMsg implements Message {

    private final KeyPressMessage message;

    /**
     * Creates a key message.
     *
     * @param key the key that was pressed
     * @deprecated Use {@link KeyPressMessage#KeyPressMessage(Key)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public KeyMsg(Key key) {
        this.message = new KeyPressMessage(key);
    }

    /**
     * Returns the key.
     *
     * @return the key
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Key getKey() {
        return message.getKey();
    }

    /**
     * Returns the key string representation.
     *
     * @return the key string
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String key() {
        return message.key();
    }

    /**
     * Returns the key runes.
     *
     * @return the runes
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public char[] runes() {
        return message.runes();
    }

    /**
     * Returns the key type.
     *
     * @return the key type
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public KeyType type() {
        return message.type();
    }

    /**
     * Returns whether alt was pressed.
     *
     * @return true if alt was pressed
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean alt() {
        return message.alt();
    }
}
