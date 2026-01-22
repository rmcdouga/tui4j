package com.williamcallahan.tui4j.compat.bubbletea.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbles.progress.FrameMessage;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link FrameMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: progress/progress.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class FrameMsg extends FrameMessage {
    /**
     * Creates FrameMsg to keep this component ready for use.
     *
     * @param id id
     * @param tag tag
     */
    public FrameMsg(int id, int tag) {
        super(id, tag);
    }
}
