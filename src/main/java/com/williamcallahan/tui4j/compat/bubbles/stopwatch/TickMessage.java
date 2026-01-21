package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Message sent on each tick of the stopwatch.
 * <p>
 * Bubbles: bubbles/stopwatch/stopwatch.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
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
