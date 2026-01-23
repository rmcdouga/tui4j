package com.williamcallahan.tui4j.compat.bubbletea.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.timer.StartStopMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: timer/timer.go.
 */
@Deprecated(since = "0.3.0")
public class StartStopMessage implements Message {
    private final com.williamcallahan.tui4j.compat.bubbles.timer.StartStopMessage delegate;

    /**
     * Creates StartStopMessage.
     *
     * @param id timer id
     * @param running whether the timer should run
     */
    @Deprecated(since = "0.3.0")
    public StartStopMessage(int id, boolean running) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.timer.StartStopMessage(id, running);
    }

    /**
     * Returns the timer id.
     *
     * @return timer id
     */
    public int id() {
        return delegate.id();
    }

    /**
     * Returns whether the timer should run.
     *
     * @return whether running
     */
    public boolean running() {
        return delegate.running();
    }

    /**
     * Returns the canonical delegate.
     *
     * @return canonical StartStopMessage
     */
    public com.williamcallahan.tui4j.compat.bubbles.timer.StartStopMessage toCanonical() {
        return delegate;
    }
}
