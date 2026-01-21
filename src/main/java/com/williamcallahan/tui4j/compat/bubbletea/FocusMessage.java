package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link FocusMsg}.
 */
public class FocusMessage extends FocusMsg implements MessageShim {

    public FocusMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
