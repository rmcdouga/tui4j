package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests opening a URL with the system handler.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @param url URL to open
 * @deprecated Use {@link OpenUrlMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record OpenUrlMsg(String url) implements Message {
}
