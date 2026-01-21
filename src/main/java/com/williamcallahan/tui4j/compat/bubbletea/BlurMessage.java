package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link BlurMsg}.
 * Bubble Tea: bubbletea/focus.go
 */
public class BlurMessage extends BlurMsg implements MessageShim {

    /**
     * Creates a blur message.
     */
    public BlurMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
