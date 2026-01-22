package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link KeyPressMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class KeyMsg extends KeyPressMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link KeyPressMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param key key input payload
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public KeyMsg(Key key) {
        super(key);
    }
}
