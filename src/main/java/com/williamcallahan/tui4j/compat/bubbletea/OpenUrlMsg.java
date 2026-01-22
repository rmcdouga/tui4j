package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link com.williamcallahan.tui4j.message.OpenUrlMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0")
public class OpenUrlMsg extends com.williamcallahan.tui4j.message.OpenUrlMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link com.williamcallahan.tui4j.message.OpenUrlMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param url url to open
     */
    @Deprecated(since = "0.3.0")
    public OpenUrlMsg(String url) {
        super(url);
    }
}
