package com.williamcallahan.tui4j.compat.bubbletea.bubbles.stopwatch;

import java.time.Duration;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.stopwatch.Stopwatch}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/stopwatch/Stopwatch.java}.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.stopwatch.Stopwatch}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Stopwatch extends com.williamcallahan.tui4j.compat.bubbles.stopwatch.Stopwatch {

    /**
     * Creates a stopwatch shim.
     */
    public Stopwatch() {
        super();
    }

    /**
     * Creates a stopwatch shim with custom precision.
     *
     * @param precision precision
     */
    public Stopwatch(Duration precision) {
        super(precision);
    }

}
