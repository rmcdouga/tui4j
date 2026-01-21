package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when an unknown input byte is received.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public class UnknownInputByteMessage implements Message {

    private final byte value;

    public UnknownInputByteMessage(byte value) {
        this.value = value;
    }

    public byte value() {
        return value;
    }

    public byte b() {
        return value;
    }
}
