package com.williamcallahan.tui4j.compat.bubbletea.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.timer.Timer} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Timer extends com.williamcallahan.tui4j.compat.bubbles.timer.Timer {

    @Deprecated(since = "0.3.0")
    public Timer() {
        super();
    }

    @Deprecated(since = "0.3.0")
    public Timer(Duration timeout) {
        super(timeout);
    }

    @Deprecated(since = "0.3.0")
    public Timer(Duration timeout, Duration interval) {
        super(timeout, interval);
    }

}
