package com.williamcallahan.tui4j.compat.bubbletea.bubbles.progress;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.progress.Spring} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: progress/progress.go.
 */
@Deprecated(since = "0.3.0")
public class Spring extends com.williamcallahan.tui4j.compat.bubbles.progress.Spring {
    /**
     * Creates Spring to keep this component ready for use.
     *
     * @param frequency frequency
     * @param damping damping
     */
    public Spring(double frequency, double damping) {
        super(frequency, damping);
    }
}
