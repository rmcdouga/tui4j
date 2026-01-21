package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.Objects;

/**
 * Message for bracketed paste events.
 * <p>
 * Bubble Tea: bubbletea/key.go (KeyMsg with Paste=true)
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 */
public class PasteMessage implements Message {

    private final String content;

    /**
     * Creates a paste message with the specified content.
     *
     * @param content the pasted content
     */
    public PasteMessage(String content) {
        this.content = content;
    }

    /**
     * Returns the pasted content.
     *
     * @return the content
     */
    public String content() {
        return content;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PasteMessage pasteMessage)) {
            return false;
        }
        return Objects.equals(content, pasteMessage.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "PasteMessage[content=" + content + "]";
    }
}
