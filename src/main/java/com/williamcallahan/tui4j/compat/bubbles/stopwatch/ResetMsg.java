package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link ResetMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 */
@Deprecated(since = "0.3.0")
public class ResetMsg extends ResetMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link ResetMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param id stopwatch identifier
     */
    @Deprecated(since = "0.3.0")
    public ResetMsg(int id) {
        super(id);
    }
}
