package com.williamcallahan.tui4j.message;

/**
 * Reports an unrecognized input sequence.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage}
 * for convenient access from the tui4j.message package.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public class UnknownSequenceMessage extends com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage {

    /**
     * Creates an unknown sequence message.
     *
     * @param sequence the unrecognized escape sequence
     */
    public UnknownSequenceMessage(String sequence) {
        super(sequence);
    }
}
