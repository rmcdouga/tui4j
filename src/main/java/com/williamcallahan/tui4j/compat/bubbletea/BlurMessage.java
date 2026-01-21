package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when the terminal window loses focus.
 * <p>
 * Bubble Tea: bubbletea/focus.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/focus.go">bubbletea/focus.go</a>
 */
@SuppressWarnings("deprecation")
public class BlurMessage extends BlurMsg implements MessageShim {

    /**
     * Creates a blur message.
     */
    public BlurMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
