package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Disables mouse tracking (motion modes and SGR extended mouse mode).
 * <p>
 * Bubble Tea: bubbletea/screen.go
 *
 * @deprecated Use {@link DisableMouseMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class DisableMouseMsg implements Message {

    /**
     * Creates a new disable mouse message.
     */
    public DisableMouseMsg() {
    }
}
