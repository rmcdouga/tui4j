package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Tick message for stopwatch time updates.
 * <p>
 * Bubbles: stopwatch/stopwatch.go TickMessage type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 */
public class TickMessage implements Message {

    private final int id;
    private final int tag;

    /**
     * Creates a tick message.
     *
     * @param id stopwatch identifier
     * @param tag animation tag
     */
    public TickMessage(int id, int tag) {
        this.id = id;
        this.tag = tag;
    }

    /**
     * Returns the stopwatch identifier.
     *
     * @return stopwatch id
     */
    public int id() {
        return id;
    }

    /**
     * Returns the animation tag.
     *
     * @return animation tag
     */
    public int tag() {
        return tag;
    }
}
