package com.williamcallahan.tui4j.compat.bubbletea.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.timer.TickMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: timer/timer.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class TickMessage implements Message {
    private final com.williamcallahan.tui4j.compat.bubbles.timer.TickMessage delegate;

    /**
     * Creates TickMessage.
     *
     * @param id timer id
     * @param timeout whether this tick hit the timeout
     * @param tag timer tag
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public TickMessage(int id, boolean timeout, int tag) {
        this.delegate = new com.williamcallahan.tui4j.compat.bubbles.timer.TickMessage(id, timeout, tag);
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
     * Returns whether this tick hit the timeout.
     *
     * @return whether timeout
     */
    public boolean timeout() {
        return delegate.timeout();
    }

    /**
     * Returns the timer tag.
     *
     * @return timer tag
     */
    public int tag() {
        return delegate.tag();
    }

    /**
     * Returns the canonical delegate.
     *
     * @return canonical TickMessage
     */
    public com.williamcallahan.tui4j.compat.bubbles.timer.TickMessage toCanonical() {
        return delegate;
    }
}
