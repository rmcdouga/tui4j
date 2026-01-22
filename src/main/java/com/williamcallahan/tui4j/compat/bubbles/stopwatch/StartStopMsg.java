package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link StartStopMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class StartStopMsg extends StartStopMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link StartStopMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public StartStopMsg(int id, boolean running) {
        super(id, running);
    }
}
