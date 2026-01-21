package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to clear the terminal screen.
 * <p>
 * Bubble Tea: bubbletea/screen.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@SuppressWarnings("deprecation")
public class ClearScreenMessage extends ClearScreenMsg implements MessageShim {

    /**
     * Creates a clear screen message.
     */
    public ClearScreenMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
