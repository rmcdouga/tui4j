package com.williamcallahan.tui4j.compat.bubbletea.bubbles.textinput;

/**
 * Port of Bubbles echo mode.
 * Bubble Tea: bubbletea/examples/textinput/main.go
 */
@Deprecated(since = "0.3.0")
public enum EchoMode {

    /** Echoes input as typed. */
    EchoNormal,
    /** Masks input characters (password mode). */
    EchoPassword,
    /** Does not echo input. */
    EchoNone
}
