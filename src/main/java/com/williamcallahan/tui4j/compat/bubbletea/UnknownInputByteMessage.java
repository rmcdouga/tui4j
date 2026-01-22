package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when an unknown input byte is received.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 * <p>
 * Bubble Tea: key.go.
 */
public class UnknownInputByteMessage implements Message {

    private final byte value;

    /**
     * Creates UnknownInputByteMessage to keep this component ready for use.
     *
     * @param value value
     */
    public UnknownInputByteMessage(byte value) {
        this.value = value;
    }

    /**
     * Handles value for this component.
     *
     * @return result
     */
    public byte value() {
        return value;
    }

    /**
     * Handles b for this component.
     *
     * @return result
     */
    public byte b() {
        return value;
    }
}
