package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

/**
 * @deprecated Compatibility: Moved to {@link TickMessage}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class TickMsg extends TickMessage {

    /**
     * Creates a tick message.
     *
     * @param id the stopwatch id
     * @param tag the stopwatch tag
     */
    public TickMsg(int id, int tag) {
        super(id, tag);
    }
}
