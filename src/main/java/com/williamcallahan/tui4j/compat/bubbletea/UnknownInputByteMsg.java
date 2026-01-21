package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when an unknown input byte is received.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @param b the unknown byte
 * @deprecated Use {@link UnknownInputByteMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record UnknownInputByteMsg(byte b) implements Message {
}
