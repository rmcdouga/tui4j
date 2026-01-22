package com.williamcallahan.tui4j.compat.bubbletea.bubbles.stopwatch;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.stopwatch.TickMsg}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class TickMsg extends com.williamcallahan.tui4j.compat.bubbles.stopwatch.TickMsg {

    /**
     * @deprecated Compatibility shim for relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.stopwatch.TickMsg} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     * @param id tick identifier
     * @param tag tick tag
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public TickMsg(int id, int tag) {
        super(id, tag);
    }
}
