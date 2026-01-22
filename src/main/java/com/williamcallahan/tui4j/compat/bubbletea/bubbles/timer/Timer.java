package com.williamcallahan.tui4j.compat.bubbletea.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;

import java.time.Duration;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.timer.Timer} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: timer/timer.go.
 */
@Deprecated(since = "0.3.0")
public class Timer extends com.williamcallahan.tui4j.compat.bubbles.timer.Timer {
    /**
     * Creates Timer to keep this component ready for use.
     */
    public Timer() {
        super();
    }

    /**
     * Creates Timer to keep this component ready for use.
     *
     * @param timeout timeout
     */
    public Timer(Duration timeout) {
        super(timeout);
    }

    /**
     * Creates Timer to keep this component ready for use.
     *
     * @param timeout timeout
     * @param interval interval
     */
    public Timer(Duration timeout, Duration interval) {
        super(timeout, interval);
    }
}
