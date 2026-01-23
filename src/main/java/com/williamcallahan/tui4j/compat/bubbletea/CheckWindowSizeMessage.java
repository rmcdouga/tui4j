package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to request the current window size.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 * <p>
 * Bubble Tea: screen.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class CheckWindowSizeMessage
        extends com.williamcallahan.tui4j.message.CheckWindowSizeMessage {

    /**
     * Creates a check window size message.
     */
    public CheckWindowSizeMessage() {
        super();
    }
}
