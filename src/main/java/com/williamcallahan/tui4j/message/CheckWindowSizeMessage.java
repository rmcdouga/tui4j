package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests a terminal size check.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.CheckWindowSizeMessage}.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public class CheckWindowSizeMessage implements Message {

    /**
     * Creates a window size check message.
     */
    public CheckWindowSizeMessage() {
    }
}
