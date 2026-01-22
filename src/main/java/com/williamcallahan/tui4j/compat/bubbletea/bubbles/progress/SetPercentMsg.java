package com.williamcallahan.tui4j.compat.bubbletea.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbles.progress.SetPercentMessage;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link SetPercentMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: progress/progress.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class SetPercentMsg extends SetPercentMessage {
    /**
     * Creates SetPercentMsg to keep this component ready for use.
     *
     * @param percent percent
     */
    public SetPercentMsg(double percent) {
        super(percent);
    }
}
