package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Disables bracketed paste mode in the terminal.
 * <p>
 * Bubble Tea: bubbletea/screen.go disableBracketedPasteMsg
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@SuppressWarnings("deprecation")
public class DisableBracketedPasteMessage extends DisableBracketedPasteMsg implements MessageShim {

    /**
     * Creates a disable bracketed paste message.
     */
    public DisableBracketedPasteMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
