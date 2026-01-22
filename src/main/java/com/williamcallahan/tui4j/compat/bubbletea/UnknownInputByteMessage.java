package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message reporting an unrecognized input byte.
 * <p>
 * Bubble Tea: bubbletea/key.go
 */
public class UnknownInputByteMessage implements Message {

    private final byte value;

    /**
     * Creates a message for an unknown input byte.
     *
     * @param value raw byte value
     */
    public UnknownInputByteMessage(byte value) {
        this.value = value;
    }

    /**
     * Returns the raw byte value.
     *
     * @return byte value
     */
    public byte value() {
        return value;
    }

    /**
     * Returns the raw byte value.
     *
     * @return byte value
     */
    public byte b() {
        return value;
    }
}
