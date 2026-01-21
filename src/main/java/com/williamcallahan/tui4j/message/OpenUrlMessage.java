package com.williamcallahan.tui4j.message;

/**
 * Requests opening a URL with the system handler.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.OpenUrlMessage}
 * for convenient access from the tui4j.message package.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public class OpenUrlMessage extends com.williamcallahan.tui4j.compat.bubbletea.OpenUrlMessage {

    /**
     * Creates an open URL message.
     *
     * @param url URL to open
     */
    public OpenUrlMessage(String url) {
        super(url);
    }
}
