package com.williamcallahan.tui4j.compat.bubbletea.bubbles.progress;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.progress.Spring} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Spring extends com.williamcallahan.tui4j.compat.bubbles.progress.Spring {

    @Deprecated(since = "0.3.0")
    public Spring(double frequency, double damping) {
        super(frequency, damping);
    }

}
