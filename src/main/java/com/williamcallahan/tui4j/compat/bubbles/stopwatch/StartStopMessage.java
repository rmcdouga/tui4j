package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Compatibility shim for {@link StartStopMsg}.
 */
public class StartStopMessage implements MessageShim {
    private final int id;
    private final boolean running;

    public StartStopMessage(int id, boolean running) {
        this.id = id;
        this.running = running;
    }

    public int id() {
        return id;
    }

    public boolean running() {
        return running;
    }

    @Override
    public Message toMessage() {
        return new StartStopMsg(id, running);
    }
}
