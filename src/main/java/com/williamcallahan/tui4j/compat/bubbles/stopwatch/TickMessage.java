package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Compatibility shim for {@link TickMsg}.
 */
public class TickMessage implements MessageShim {
    private final int id;
    private final int tag;

    public TickMessage(int id, int tag) {
        this.id = id;
        this.tag = tag;
    }

    public int id() {
        return id;
    }

    public int tag() {
        return tag;
    }

    @Override
    public Message toMessage() {
        return new TickMsg(id, tag);
    }
}
