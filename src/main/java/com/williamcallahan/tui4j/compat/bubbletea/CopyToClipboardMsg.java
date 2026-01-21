package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests copying text to the clipboard.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @param text text to copy
 * @deprecated Use {@link CopyToClipboardMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record CopyToClipboardMsg(String text) implements Message {
}
