package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests opening a URL with the system handler.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/OpenUrlMsg.java
 *
 * @param url URL to open
 */
public record OpenUrlMsg(String url) implements Message {
}
