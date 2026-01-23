package com.williamcallahan.tui4j.compat.bubbles.spinner;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

import java.time.LocalDateTime;

/**
 * Tick message for spinner animation frames.
 * <p>
 * Bubbles: spinner/spinner.go TickMessage type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/spinner/spinner.go">bubbles/spinner/spinner.go</a>
 */
public class TickMessage implements Message {

    private final LocalDateTime time;
    private final int tag;
    private final int id;

    /**
     * Creates a tick message.
     *
     * @param time tick time
     * @param tag spinner tag
     * @param id spinner id
     */
    public TickMessage(LocalDateTime time, int tag, int id) {
        this.time = time;
        this.tag = tag;
        this.id = id;
    }

    /**
     * Returns the tick time.
     *
     * @return tick time
     */
    public LocalDateTime time() {
        return time;
    }

    /**
     * Returns the spinner tag.
     *
     * @return spinner tag
     */
    public int tag() {
        return tag;
    }

    /**
     * Returns the spinner id.
     *
     * @return spinner id
     */
    public int id() {
        return id;
    }
}
