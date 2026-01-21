package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests opening a URL with the system handler.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.OpenUrlMessage}.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @param url URL to open
 */
public record OpenUrlMessage(String url) implements Message {
}
