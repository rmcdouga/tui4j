package com.williamcallahan.tui4j.compat.bubbles.spinner;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

import java.time.LocalDateTime;

/**
 * Port of Bubbles tick message.
 * Bubble Tea: bubbletea/examples/spinner/main.go
 * <p>
 * Bubbles: spinner/spinner.go.
 */
public class TickMessage implements Message {
    private final LocalDateTime time;
    private final int tag;
    private final int id;

    /**
     * Creates TickMessage to keep this component ready for use.
     *
     * @param time time
     * @param tag tag
     * @param id id
     */
    public TickMessage(
            LocalDateTime time,
            int tag,
            int id) {
        this.time = time;
        this.tag = tag;
        this.id = id;
    }

    /**
     * Handles time for this component.
     *
     * @return result
     */
    public LocalDateTime time() {
        return time;
    }

    /**
     * Handles tag for this component.
     *
     * @return result
     */
    public int tag() {
        return tag;
    }

    /**
     * Handles id for this component.
     *
     * @return result
     */
    public int id() {
        return id;
    }

}
