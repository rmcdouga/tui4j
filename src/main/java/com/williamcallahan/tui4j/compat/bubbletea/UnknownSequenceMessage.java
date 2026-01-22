package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when an unrecognized escape sequence is received.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 * <p>
 * Bubble Tea: key.go.
 */
public class UnknownSequenceMessage implements Message {

    private final String sequence;

    /**
     * Creates an unknown sequence message.
     *
     * @param sequence the unrecognized escape sequence
     */
    public UnknownSequenceMessage(String sequence) {
        this.sequence = sequence;
    }

    /**
     * Returns the unrecognized sequence.
     *
     * @return the sequence
     */
    public String sequence() {
        return sequence;
    }
}
