package com.williamcallahan.tui4j.message;

/**
 * Message to copy text to the clipboard.
 * <p>
 * tui4j extension; no direct Bubble Tea equivalent.
 */
public class CopyToClipboardMessage implements com.williamcallahan.tui4j.compat.bubbletea.Message {
    private final String text;

    /**
     * Creates a clipboard request message.
     *
     * @param text text to copy
     */
    public CopyToClipboardMessage(String text) {
        this.text = text;
    }

    /**
     * Returns the clipboard text.
     *
     * @return text to copy
     */
    public String text() {
        return text;
    }
}
