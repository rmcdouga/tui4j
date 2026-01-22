package com.williamcallahan.tui4j.compat.bubbletea.bubbles.stopwatch;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link com.williamcallahan.tui4j.compat.bubbles.stopwatch.StartStopMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class StartStopMsg extends com.williamcallahan.tui4j.compat.bubbles.stopwatch.StartStopMessage {
    /**
     * Creates StartStopMsg to keep this component ready for use.
     *
     * @param id id
     * @param running running
     */
    public StartStopMsg(int id, boolean running) {
        super(id, running);
    }
}
