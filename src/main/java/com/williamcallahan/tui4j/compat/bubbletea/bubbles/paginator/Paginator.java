package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

import com.williamcallahan.tui4j.compat.bubbles.paginator.Paginator.Option;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.paginator.Paginator}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/paginator/Paginator.java}.
 * <p>
 * Bubbles: paginator/paginator.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.paginator.Paginator}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Paginator extends com.williamcallahan.tui4j.compat.bubbles.paginator.Paginator {

    /**
     * Creates a paginator shim.
     */
    public Paginator() {
        super();
    }

    /**
     * Creates a paginator shim with options.
     *
     * @param options configuration options
     */
    public Paginator(Option... options) {
        super(options);
    }
}
