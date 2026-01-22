package com.williamcallahan.tui4j.compat.bubbletea.bubbles.stopwatch;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link com.williamcallahan.tui4j.compat.bubbles.stopwatch.ResetMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 */
@Deprecated(since = "0.3.0")
public class ResetMsg extends com.williamcallahan.tui4j.compat.bubbles.stopwatch.ResetMessage {
    /**
     * Creates ResetMsg to keep this component ready for use.
     *
     * @param id id
     */
    public ResetMsg(int id) {
        super(id);
    }
}
