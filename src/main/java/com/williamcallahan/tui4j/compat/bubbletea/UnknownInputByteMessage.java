package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link UnknownInputByteMsg}.
 */
public class UnknownInputByteMessage implements MessageShim {

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

    @Override
    public Message toMessage() {
        return new UnknownInputByteMsg(value);
    }
}
