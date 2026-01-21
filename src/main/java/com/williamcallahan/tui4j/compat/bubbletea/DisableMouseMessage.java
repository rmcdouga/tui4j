package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link DisableMouseMsg}.
 * Bubble Tea: bubbletea/screen.go
 */
public class DisableMouseMessage implements MessageShim {

    /**
     * Creates a disable mouse message.
     */
    public DisableMouseMessage() {
    }

    @Override
    public Message toMessage() {
        return new DisableMouseMsg();
    }
}
