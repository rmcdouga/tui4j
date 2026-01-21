package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests opening a URL with the system handler.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public class OpenUrlMessage implements Message {

    private final String url;

    /**
     * Creates an open URL message.
     *
     * @param url URL to open
     */
    public OpenUrlMessage(String url) {
        this.url = url;
    }

    /**
     * Returns the URL to open.
     *
     * @return URL string
     */
    public String url() {
        return url;
    }
}
