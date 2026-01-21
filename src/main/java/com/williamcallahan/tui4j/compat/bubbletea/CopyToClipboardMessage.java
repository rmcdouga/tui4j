package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Clipboard request message shim.
 * Bubble Tea: bubbletea/commands.go (tui4j extension; no direct equivalent).
 */
public class CopyToClipboardMessage implements MessageShim {
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

    @Override
    public Message toMessage() {
        return new CopyToClipboardMsg(text);
    }
}
