package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Port of the Bubble Tea suspend message.
 * <p>
 * Upstream: github.com/charmbracelet/bubbletea (tea.go)
 *
 * @deprecated Use {@link SuspendMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/tea.go">bubbletea/tea.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record SuspendMsg() implements Message {
}
