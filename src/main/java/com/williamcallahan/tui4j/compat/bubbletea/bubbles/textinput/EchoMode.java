package com.williamcallahan.tui4j.compat.bubbletea.bubbles.textinput;

/**
 * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.EchoMode} instead.
 *             This enum has been moved as part of the Bubbles package restructuring.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public enum EchoMode {

    /**
     * Echo input as-is.
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.EchoMode#EchoNormal} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    EchoNormal,

    /**
     * Echo input using a password mask.
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.EchoMode#EchoPassword} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    EchoPassword,

    /**
     * Do not echo input characters.
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.EchoMode#EchoNone} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    EchoNone
}
