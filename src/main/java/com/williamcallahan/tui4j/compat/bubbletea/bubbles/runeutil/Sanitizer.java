package com.williamcallahan.tui4j.compat.bubbletea.bubbles.runeutil;

import java.util.function.Consumer;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: runeutil/runeutil.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Sanitizer extends com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer {

    /**
     * @deprecated Compatibility shim for relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Sanitizer() {
        super();
    }

    /**
     * @deprecated Compatibility shim for relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @SafeVarargs
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Sanitizer(Consumer<com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer>... options) {
        super(options);
    }
}
