package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests setting the terminal window title.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 *
 * @param title window title to set
 * @deprecated Use {@link SetWindowTitleMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record SetWindowTitleMsg(String title) implements Message {
}
