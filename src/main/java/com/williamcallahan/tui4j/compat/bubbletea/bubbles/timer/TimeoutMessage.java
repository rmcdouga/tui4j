package com.williamcallahan.tui4j.compat.bubbletea.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.timer.TimeoutMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: timer/timer.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class TimeoutMessage extends com.williamcallahan.tui4j.compat.bubbles.timer.TimeoutMessage {
    /**
     * Creates TimeoutMessage to keep this component ready for use.
     *
     * @param id id
     */
    public TimeoutMessage(int id) {
        super(id);
    }

    /**
     * Handles id for this component.
     *
     * @return result
     */
    @Override
    public int id() {
        return super.id();
    }
}
