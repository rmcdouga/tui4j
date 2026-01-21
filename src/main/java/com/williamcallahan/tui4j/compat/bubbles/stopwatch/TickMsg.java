package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent on each tick of the stopwatch.
 * <p>
 * Bubbles: bubbles/stopwatch/stopwatch.go
 *
 * @deprecated Use {@link TickMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class TickMsg implements Message {

    private final TickMessage message;

    /**
     * Creates a tick message.
     *
     * @param id the stopwatch id
     * @param tag the stopwatch tag
     * @deprecated Use {@link TickMessage#TickMessage(int, int)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public TickMsg(int id, int tag) {
        this.message = new TickMessage(id, tag);
    }

    /**
     * Returns the stopwatch id.
     *
     * @return the id
     */
    public int id() {
        return message.id();
    }

    /**
     * Returns the stopwatch tag.
     *
     * @return the tag
     */
    public int tag() {
        return message.tag();
    }
}
