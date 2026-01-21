package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent to reset the stopwatch.
 * <p>
 * Bubbles: bubbles/stopwatch/stopwatch.go
 *
 * @deprecated Use {@link ResetMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ResetMsg implements Message {

    private final ResetMessage message;

    /**
     * Creates a reset message.
     *
     * @param id the stopwatch id
     * @deprecated Use {@link ResetMessage#ResetMessage(int)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ResetMsg(int id) {
        this.message = new ResetMessage(id);
    }

    /**
     * Returns the stopwatch id.
     *
     * @return the id
     * @deprecated Use {@link ResetMessage#id()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int id() {
        return message.id();
    }
}
