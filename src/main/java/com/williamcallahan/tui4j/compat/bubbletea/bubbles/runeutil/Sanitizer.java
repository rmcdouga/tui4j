package com.williamcallahan.tui4j.compat.bubbletea.bubbles.runeutil;

import java.util.function.Consumer;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: runeutil/runeutil.go.
 */
@Deprecated(since = "0.3.0")
public class Sanitizer extends com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    public Sanitizer() {
        super();
    }

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param options sanitizer options
     */
    @SafeVarargs
    @Deprecated(since = "0.3.0")
    public Sanitizer(Consumer<com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer>... options) {
        super(options);
    }
}
