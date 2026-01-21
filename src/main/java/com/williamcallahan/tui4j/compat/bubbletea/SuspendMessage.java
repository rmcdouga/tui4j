package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link SuspendMsg}.
 */
public class SuspendMessage implements MessageShim {

    @Override
    public Message toMessage() {
        return new SuspendMsg();
    }
}
