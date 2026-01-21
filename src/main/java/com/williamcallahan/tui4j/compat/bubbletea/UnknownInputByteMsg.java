package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when an unknown input byte is received.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @deprecated Use {@link UnknownInputByteMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class UnknownInputByteMsg extends UnknownInputByteMessage {

    /**
     * Creates an unknown input byte message.
     *
     * @param b the unknown byte
     * @deprecated Use {@link UnknownInputByteMessage#UnknownInputByteMessage(byte)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public UnknownInputByteMsg(byte b) {
        super(b);
    }
}
