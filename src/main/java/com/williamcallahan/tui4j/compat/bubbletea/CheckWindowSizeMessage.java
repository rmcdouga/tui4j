package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link CheckWindowSizeMsg}.
 * Bubble Tea: bubbletea/screen.go
 */
public class CheckWindowSizeMessage extends CheckWindowSizeMsg implements MessageShim {

    /**
     * Creates a check window size message.
     */
    public CheckWindowSizeMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
