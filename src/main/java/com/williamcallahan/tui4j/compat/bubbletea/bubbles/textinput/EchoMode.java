package com.williamcallahan.tui4j.compat.bubbletea.bubbles.textinput;

/**
 * Echo modes for Bubble Tea-compatible text input.
 * <p>
 * Bubbles: textinput/textinput.go.
 */
public enum EchoMode {
    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.EchoMode#EchoNormal}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    EchoNormal,

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.EchoMode#EchoPassword}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    EchoPassword,

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.EchoMode#EchoNone}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    EchoNone,
}
