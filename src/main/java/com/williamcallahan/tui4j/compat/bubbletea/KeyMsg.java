package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link KeyPressMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0")
public class KeyMsg extends KeyPressMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link KeyPressMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param key key input payload
     */
    @Deprecated(since = "0.3.0")
    public KeyMsg(Key key) {
        super(key);
    }
}
