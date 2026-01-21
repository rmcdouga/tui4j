package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link OpenUrlMsg}.
 * Bubble Tea: bubbletea/commands.go (tui4j extension; no direct equivalent).
 */
public class OpenUrlMessage implements MessageShim {
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

    @Override
    public Message toMessage() {
        return new OpenUrlMsg(url);
    }
}
