package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link EnterAltScreenMsg}.
 * Bubble Tea: bubbletea/screen.go
 */
public class EnterAltScreen implements MessageShim {

    /**
     * Creates an enter alternate screen message.
     */
    public EnterAltScreen() {
    }

    @Override
    public Message toMessage() {
        return new EnterAltScreenMsg();
    }
}
