package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link CopyToClipboardMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class CopyToClipboardMsg extends CopyToClipboardMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link CopyToClipboardMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param text clipboard contents
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public CopyToClipboardMsg(String text) {
        super(text);
    }
}
