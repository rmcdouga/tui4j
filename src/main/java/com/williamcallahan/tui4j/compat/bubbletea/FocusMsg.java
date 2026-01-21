package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when the terminal window gains focus.
 * <p>
 * Port of charmbracelet/bubbletea focus.go FocusMsg type.
 *
 * @deprecated Use {@link FocusMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/focus.go">bubbletea/focus.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class FocusMsg extends FocusMessage {

    /**
     * Creates a new focus message.
     *
     * @deprecated Use {@link FocusMessage#FocusMessage()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public FocusMsg() {}
}
