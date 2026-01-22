package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link UnknownInputByteMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class UnknownInputByteMsg extends UnknownInputByteMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link UnknownInputByteMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public UnknownInputByteMsg(byte b) {
        super(b);
    }
}
