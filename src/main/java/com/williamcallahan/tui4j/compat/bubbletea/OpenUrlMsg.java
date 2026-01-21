package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests opening a URL with the system handler.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @deprecated Use {@link OpenUrlMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class OpenUrlMsg implements Message {

    private final OpenUrlMessage message;

    /**
     * Creates an open URL message.
     *
     * @param url URL to open
     * @deprecated Use {@link OpenUrlMessage#OpenUrlMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public OpenUrlMsg(String url) {
        this.message = new OpenUrlMessage(url);
    }

    /**
     * Returns the URL to open.
     *
     * @return URL string
     * @deprecated Use {@link OpenUrlMessage#url()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String url() {
        return message.url();
    }
}
