package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link UnknownSequenceMsg}.
 */
public class UnknownSequenceMessage extends UnknownSequenceMsg implements MessageShim {

    public UnknownSequenceMessage(String sequence) {
        super(sequence);
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
