package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to request the current window size.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
@SuppressWarnings("deprecation")
public class CheckWindowSizeMessage extends CheckWindowSizeMsg implements MessageShim {

    /**
     * Creates a check window size message.
     */
    public CheckWindowSizeMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
