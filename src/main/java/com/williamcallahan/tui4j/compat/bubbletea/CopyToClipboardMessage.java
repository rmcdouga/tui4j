package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.message.CopyToClipboardMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class CopyToClipboardMessage extends com.williamcallahan.tui4j.message.CopyToClipboardMessage {

    /**
     * Creates CopyToClipboardMessage to keep this component ready for use.
     *
     * @param text text
     */
    public CopyToClipboardMessage(String text) {
        super(text);
    }
}
