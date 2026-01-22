package com.williamcallahan.tui4j.compat.bubbles.progress;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link FrameMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: progress/progress.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class FrameMsg extends FrameMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link FrameMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param id progress identifier
     * @param tag frame tag
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public FrameMsg(int id, int tag) {
        super(id, tag);
    }
}
