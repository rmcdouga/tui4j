package com.williamcallahan.tui4j.compat.bubbletea.bubbles.stopwatch;

import java.time.Duration;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.stopwatch.Stopwatch} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 */
@Deprecated(since = "0.3.0")
public class Stopwatch extends com.williamcallahan.tui4j.compat.bubbles.stopwatch.Stopwatch {
    /**
     * Creates Stopwatch to keep this component ready for use.
     */
    public Stopwatch() {
        super();
    }
    /**
     * Creates Stopwatch to keep this component ready for use.
     *
     * @param precision precision
     */
    public Stopwatch(Duration precision) {
        super(precision);
    }
}
