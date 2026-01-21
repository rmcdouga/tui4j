package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Disables bracketed paste mode in the terminal.
 * <p>
 * Bubble Tea: bubbletea/screen.go disableBracketedPasteMsg
 *
 * @deprecated Use {@link DisableBracketedPasteMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class DisableBracketedPasteMsg implements Message {

    /**
     * Creates a disable bracketed paste message.
     *
     * @deprecated Use {@link DisableBracketedPasteMessage#DisableBracketedPasteMessage()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public DisableBracketedPasteMsg() {
    }
}
