package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link ResumeMsg}.
 */
public class ResumeMessage implements MessageShim {

    @Override
    public Message toMessage() {
        return new ResumeMsg();
    }
}
