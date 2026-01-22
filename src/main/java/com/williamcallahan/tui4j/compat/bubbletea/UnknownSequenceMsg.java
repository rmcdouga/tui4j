package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link UnknownSequenceMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0")
public class UnknownSequenceMsg extends UnknownSequenceMessage {

    /**
     * Creates a legacy unknown sequence message.
     *
     * @param sequence input sequence
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link UnknownSequenceMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    public UnknownSequenceMsg(String sequence) {
        super(sequence);
    }
}
