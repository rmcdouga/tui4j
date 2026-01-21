package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.Objects;

/**
 * Message for bracketed paste events.
 * <p>
 * Bubble Tea: bubbletea/key.go (KeyMsg with Paste=true)
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 */
@SuppressWarnings("deprecation")
public class PasteMessage extends PasteMsg implements MessageShim {

    private final String contentRef;

    /**
     * Creates a paste message with the specified content.
     *
     * @param content the pasted content
     */
    public PasteMessage(String content) {
        super(content);
        this.contentRef = content;
    }

    /**
     * Returns the pasted content.
     *
     * @return the content
     */
    @Override
    public String content() {
        return contentRef;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PasteMessage pasteMessage)) {
            return false;
        }
        return Objects.equals(contentRef, pasteMessage.contentRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentRef);
    }

    @Override
    public String toString() {
        return "PasteMessage[content=" + contentRef + "]";
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
