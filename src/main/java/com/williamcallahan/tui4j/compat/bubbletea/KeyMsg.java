package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
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

    private final Key key;

    /**
     * Creates a key message.
     *
     * @param key the key that was pressed
     * @deprecated Use {@link KeyPressMessage} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public KeyMsg(Key key) {
        this.key = key;
    }

    /**
     * Returns the key.
     *
     * @return the key
     * @deprecated Use {@link KeyPressMessage} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Key getKey() {
        return key;
    }

    /**
     * Returns the key string representation.
     *
     * @return the key string
     * @deprecated Use {@link KeyPressMessage} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String key() {
        return key.toString();
    }

    /**
     * Returns the key runes.
     *
     * @return the runes
     * @deprecated Use {@link KeyPressMessage} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public char[] runes() {
        return key.runes();
    }

    /**
     * Returns the key type.
     *
     * @return the key type
     * @deprecated Use {@link KeyPressMessage} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public KeyType type() {
        return key.type();
    }

    /**
     * Returns whether alt was pressed.
     *
     * @return true if alt was pressed
     * @deprecated Use {@link KeyPressMessage} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean alt() {
        return key.alt();
    }
}
