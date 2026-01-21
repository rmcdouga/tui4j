package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Signals that the program should quit.
 * <p>
 * Bubble Tea: bubbletea/tea.go
 *
 * @deprecated Use {@link QuitMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/tea.go">bubbletea/tea.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class QuitMsg extends QuitMessage {
}
