package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests a terminal size check.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/CheckWindowSizeMsg.java
 */
public class CheckWindowSizeMsg implements Message {

    /**
     * Creates a window size check message.
     */
    public CheckWindowSizeMsg() {
    }
}
