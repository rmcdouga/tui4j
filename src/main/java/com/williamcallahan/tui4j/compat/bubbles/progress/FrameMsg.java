package com.williamcallahan.tui4j.compat.bubbles.progress;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link FrameMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: progress/progress.go.
 */
@Deprecated(since = "0.3.0")
public class FrameMsg extends FrameMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link FrameMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param id progress identifier
     * @param tag frame tag
     */
    @Deprecated(since = "0.3.0")
    public FrameMsg(int id, int tag) {
        super(id, tag);
    }
}
