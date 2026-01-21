package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Message sent to reset the stopwatch.
 * <p>
 * Bubbles: bubbles/stopwatch/stopwatch.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
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
