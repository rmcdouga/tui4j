package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link UnknownSequenceMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class UnknownSequenceMsg extends UnknownSequenceMessage {

    /**
     * Creates a legacy unknown sequence message.
     *
     * @param sequence input sequence
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link UnknownSequenceMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public UnknownSequenceMsg(String sequence) {
        super(sequence);
    }
}
