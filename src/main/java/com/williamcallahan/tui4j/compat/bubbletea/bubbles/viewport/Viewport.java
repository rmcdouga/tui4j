package com.williamcallahan.tui4j.compat.bubbletea.bubbles.viewport;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.viewport.Viewport} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Viewport extends com.williamcallahan.tui4j.compat.bubbles.viewport.Viewport {

    @Deprecated(since = "0.3.0")
    public Viewport() {
        super();
    }

    @Deprecated(since = "0.3.0")
    public Viewport(String content) {
        super(content);
    }

    @Deprecated(since = "0.3.0")
    public Viewport(String content, int height) {
        super(content, height);
    }

    @Deprecated(since = "0.3.0")
    public Viewport(String content, int width, int height) {
        super(content, width, height);
    }

    @Deprecated(since = "0.3.0")
    public Viewport(String content, int width, int height, com.williamcallahan.tui4j.compat.bubbles.viewport.KeyMap keyMap) {
        super(content, width, height, keyMap);
    }

}
