package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link UnknownInputByteMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0")
public class UnknownInputByteMsg extends UnknownInputByteMessage {

    /**
     * Creates a legacy unknown input byte message.
     *
     * @param b input byte
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link UnknownInputByteMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    public UnknownInputByteMsg(byte b) {
        super(b);
    }
}
