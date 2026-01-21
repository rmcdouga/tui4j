package com.williamcallahan.tui4j.message;

/**
 * Requests copying text to the clipboard.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.CopyToClipboardMessage}
 * for convenient access from the tui4j.message package.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public class CopyToClipboardMessage extends com.williamcallahan.tui4j.compat.bubbletea.CopyToClipboardMessage {

    /**
     * Creates a clipboard request message.
     *
     * @param text text to copy
     */
    public CopyToClipboardMessage(String text) {
        super(text);
    }
}
