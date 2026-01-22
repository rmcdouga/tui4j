package com.williamcallahan.tui4j.compat.bubbletea.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.timer.TickMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: timer/timer.go.
 */
@Deprecated(since = "0.3.0")
public class TickMessage extends com.williamcallahan.tui4j.compat.bubbles.timer.TickMessage {
    /**
     * Creates TickMessage to keep this component ready for use.
     *
     * @param id id
     * @param timeout timeout
     * @param tag tag
     */
    public TickMessage(int id, boolean timeout, int tag) {
        super(id, timeout, tag);
    }
}
