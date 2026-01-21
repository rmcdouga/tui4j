package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests entering the alternate screen buffer.
 * <p>
 * Bubble Tea: bubbletea/screen.go
 *
 * @deprecated Use {@link EnterAltScreenMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record EnterAltScreenMsg() implements Message {
}
