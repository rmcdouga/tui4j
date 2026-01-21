package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Message sent to start or stop the stopwatch.
 * <p>
 * Bubbles: bubbles/stopwatch/stopwatch.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
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
