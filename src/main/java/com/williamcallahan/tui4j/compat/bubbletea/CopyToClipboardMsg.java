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
public class CopyToClipboardMsg extends CopyToClipboardMessage {

    /**
     * Creates a clipboard request message.
     *
     * @param text text to copy
     * @deprecated Use {@link CopyToClipboardMessage#CopyToClipboardMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public CopyToClipboardMsg(String text) {
        super(text);
    }
}
