package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link ResetMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ResetMsg extends ResetMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link ResetMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ResetMsg(int id) {
        super(id);
    }
}
