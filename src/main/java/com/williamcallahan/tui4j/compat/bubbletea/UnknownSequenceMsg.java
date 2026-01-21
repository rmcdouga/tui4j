package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when an unrecognized escape sequence is received.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @deprecated Use {@link UnknownSequenceMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class UnknownSequenceMsg implements Message {

    private final UnknownSequenceMessage message;

    /**
     * Creates an unknown sequence message.
     *
     * @param sequence the unrecognized escape sequence
     * @deprecated Use {@link UnknownSequenceMessage#UnknownSequenceMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public UnknownSequenceMsg(String sequence) {
        this.message = new UnknownSequenceMessage(sequence);
    }

    /**
     * Returns the unrecognized sequence.
     *
     * @return the sequence
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String sequence() {
        return message.sequence();
    }
}
