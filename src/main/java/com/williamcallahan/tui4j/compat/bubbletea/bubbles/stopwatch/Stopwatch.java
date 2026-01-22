package com.williamcallahan.tui4j.compat.bubbletea.bubbles.stopwatch;

import java.time.Duration;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.stopwatch.Stopwatch} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Stopwatch extends com.williamcallahan.tui4j.compat.bubbles.stopwatch.Stopwatch {

    @Deprecated(since = "0.3.0")
    public Stopwatch() {
        super();
    }

    @Deprecated(since = "0.3.0")
    public Stopwatch(Duration precision) {
        super(precision);
    }

}
