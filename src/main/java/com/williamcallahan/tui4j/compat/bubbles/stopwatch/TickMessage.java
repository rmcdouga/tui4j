package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent on each tick of the stopwatch.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 */
public class TickMessage implements Message {
    private final int id;
    private final int tag;

    /**
     * Creates a tick message.
     *
     * @param id the stopwatch id
     * @param tag the stopwatch tag
     */
    public TickMessage(int id, int tag) {
        this.id = id;
        this.tag = tag;
    }

    /**
     * Returns the stopwatch id.
     *
     * @return the id
     */
    public int id() {
        return id;
    }

    /**
     * Returns the stopwatch tag.
     *
     * @return the tag
     */
    public int tag() {
        return tag;
    }
}
