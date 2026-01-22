package com.williamcallahan.tui4j.compat.bubbletea.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.timer.StartStopMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: timer/timer.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class StartStopMessage extends com.williamcallahan.tui4j.compat.bubbles.timer.StartStopMessage {
    /**
     * Creates StartStopMessage to keep this component ready for use.
     *
     * @param id id
     * @param running running
     */
    public StartStopMessage(int id, boolean running) {
        super(id, running);
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

    /**
     * Handles running for this component.
     *
     * @return whether nning
     */
    @Override
    public boolean running() {
        return super.running();
    }
}
