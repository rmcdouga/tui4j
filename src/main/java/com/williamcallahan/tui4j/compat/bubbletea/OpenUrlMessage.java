package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.message.OpenUrlMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0")
public class OpenUrlMessage extends com.williamcallahan.tui4j.message.OpenUrlMessage {

    /**
     * Creates OpenUrlMessage to keep this component ready for use.
     *
     * @param url url
     */
    public OpenUrlMessage(String url) {
        super(url);
    }
}
