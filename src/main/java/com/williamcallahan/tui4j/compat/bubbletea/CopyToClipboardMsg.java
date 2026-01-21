package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests copying text to the clipboard.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @deprecated Use {@link CopyToClipboardMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class CopyToClipboardMsg implements Message {

    private final CopyToClipboardMessage message;

    /**
     * Creates a clipboard request message.
     *
     * @param text text to copy
     * @deprecated Use {@link CopyToClipboardMessage#CopyToClipboardMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public CopyToClipboardMsg(String text) {
        this.message = new CopyToClipboardMessage(text);
    }

    /**
     * @return the text to copy
     * @deprecated Use {@link CopyToClipboardMessage#text()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String text() {
        return message.text();
    }
}
