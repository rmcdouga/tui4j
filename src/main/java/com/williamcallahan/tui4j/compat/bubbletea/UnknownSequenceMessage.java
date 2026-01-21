package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when an unrecognized escape sequence is received.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
@SuppressWarnings("deprecation")
public class UnknownSequenceMessage extends UnknownSequenceMsg implements MessageShim {

    public UnknownSequenceMessage(String sequence) {
        super(sequence);
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
