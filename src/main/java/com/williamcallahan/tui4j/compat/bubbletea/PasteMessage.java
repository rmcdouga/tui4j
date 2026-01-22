package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.Objects;

/**
 * Message for bracketed paste events.
 * <p>
 * Bubble Tea: key.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 * <p>
 * Bubble Tea: inputreader_windows.go.
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

    /**
     * Handles equals for this component.
     *
     * @param other other
     * @return whether uals
     */
    @SuppressWarnings("removal")
/** {@inheritDoc} */
    @Override
 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PasteMsg pasteMsg) {
            return Objects.equals(content, pasteMsg.content());
        }
        if (!(other instanceof PasteMessage pasteMessage)) {
            return false;
        }
        return Objects.equals(content, pasteMessage.content);
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "PasteMessage[content=" + content + "]";
    }
}
