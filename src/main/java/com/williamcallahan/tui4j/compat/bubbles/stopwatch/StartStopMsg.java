package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

/**
 * Message sent to start or stop the stopwatch.
 * <p>
 * Bubbles: bubbles/stopwatch/stopwatch.go
 *
 * @deprecated Use {@link StartStopMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class StartStopMsg extends StartStopMessage {

    /**
     * Creates a start/stop message.
     *
     * @param id the stopwatch id
     * @param running whether the stopwatch should run
     * @deprecated Use {@link StartStopMessage#StartStopMessage(int, boolean)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public StartStopMsg(int id, boolean running) {
        super(id, running);
    }
}
