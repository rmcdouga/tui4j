package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when the terminal window loses focus.
 * <p>
 * Bubble Tea: bubbletea/focus.go
 *
 * @deprecated Use {@link BlurMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/focus.go">bubbletea/focus.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class BlurMsg implements Message {

    /**
     * Creates a blur message.
     *
     * @deprecated Use {@link BlurMessage#BlurMessage()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public BlurMsg() {
    }
}
