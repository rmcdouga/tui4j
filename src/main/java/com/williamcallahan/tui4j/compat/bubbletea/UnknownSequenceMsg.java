package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Reports an unrecognized input sequence.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/UnknownSequenceMsg.java
 */
public class UnknownSequenceMsg implements Message {
    private final String sequence;

    public UnknownSequenceMsg(String sequence) {
        this.sequence = sequence;
    }

    public String sequence() { return sequence; }
}
