package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Compatibility shim for {@link ResetMsg}.
 */
public class ResetMessage implements MessageShim {
    private final int id;

    public ResetMessage(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }

    @Override
    public Message toMessage() {
        return new ResetMsg(id);
    }
}
