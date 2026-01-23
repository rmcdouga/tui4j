package com.williamcallahan.tui4j.compat.bubbles.textinput;

/**
 * Port of Bubbles echo modes for text input.
 * Bubbles: bubbles/textinput/textinput.go
 */
public enum EchoMode {

    /**
     * Echo input as-is.
     */
    EchoNormal,

    /**
     * Echo input using a password mask.
     */
    EchoPassword,

    /**
     * Do not echo input characters.
     */
    EchoNone
}
