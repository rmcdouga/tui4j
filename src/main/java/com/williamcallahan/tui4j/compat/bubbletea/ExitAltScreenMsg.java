package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests exiting the alternate screen buffer.
 * <p>
 * Bubble Tea: bubbletea/screen.go
 *
 * @deprecated Use {@link ExitAltScreenMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ExitAltScreenMsg implements Message {

    /**
     * Creates a new exit alt screen message.
     */
    public ExitAltScreenMsg() {
    }
}
