package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link ExitAltScreenMsg}.
 */
public class ExitAltScreen implements MessageShim {

    @Override
    public Message toMessage() {
        return new ExitAltScreenMsg();
    }
}
