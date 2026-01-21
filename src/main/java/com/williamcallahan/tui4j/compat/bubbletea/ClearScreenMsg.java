package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to clear the terminal screen.
 * <p>
 * Bubble Tea: bubbletea/screen.go
 *
 * @deprecated Use {@link ClearScreenMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ClearScreenMsg implements Message {

    /**
     * Creates a clear screen message.
     *
     * @deprecated Use {@link ClearScreenMessage#ClearScreenMessage()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ClearScreenMsg() {
    }
}
