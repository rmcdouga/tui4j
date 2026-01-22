package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link QuitMsg}.
 */
public class QuitMessage implements MessageShim {

    @Override
    public Message toMessage() {
        return new QuitMsg();
    }
}
