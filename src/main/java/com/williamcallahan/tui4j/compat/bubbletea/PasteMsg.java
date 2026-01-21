package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message for bracketed paste events.
 * <p>
 * Bubble Tea: bubbletea/key.go (KeyMsg with Paste=true)
 *
 * @deprecated Use {@link PasteMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class PasteMsg extends PasteMessage {

    /**
     * Creates a paste message with the specified content.
     *
     * @param content the pasted content
     * @deprecated Use {@link PasteMessage#PasteMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public PasteMsg(String content) {
        super(content);
    }
}
