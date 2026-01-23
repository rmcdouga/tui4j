package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Reports an unrecognized input sequence.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/UnknownSequenceMessage.java
 */
public class UnknownSequenceMessage implements Message {
    private final String sequence;

    /**
     * Creates a message for an unknown sequence.
     *
     * @param sequence the unrecognized sequence
     */
    public UnknownSequenceMessage(String sequence) {
        this.sequence = sequence;
    }

    /**
     * Returns the unrecognized sequence.
     *
     * @return sequence string
     */
    public String sequence() { return sequence; }
}
