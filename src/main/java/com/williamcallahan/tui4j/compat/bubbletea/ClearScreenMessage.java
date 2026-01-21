package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link ClearScreenMsg}.
 * Bubble Tea: bubbletea/screen.go
 */
public class ClearScreenMessage extends ClearScreenMsg implements MessageShim {

    /**
     * Creates a clear screen message.
     */
    public ClearScreenMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
