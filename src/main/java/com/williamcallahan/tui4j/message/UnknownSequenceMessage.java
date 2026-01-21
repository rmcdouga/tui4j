package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMsg;

/**
 * Reports an unrecognized input sequence.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/UnknownSequenceMessage.java
 */
@SuppressWarnings("deprecation")
public class UnknownSequenceMessage extends UnknownSequenceMsg {

    public UnknownSequenceMessage(String sequence) {
        super(sequence);
    }
}
