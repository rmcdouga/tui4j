package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.Objects;

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
public class PasteMsg implements Message {

    private final PasteMessage message;

    /**
     * Creates a paste message with the specified content.
     *
     * @param content the pasted content
     * @deprecated Use {@link PasteMessage#PasteMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public PasteMsg(String content) {
        this.message = new PasteMessage(content);
    }

    /**
     * Returns the pasted content.
     *
     * @return the content
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String content() {
        return message.content();
    }

    @Override
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PasteMessage pasteMessage) {
            return Objects.equals(content(), pasteMessage.content());
        }
        if (!(other instanceof PasteMsg pasteMsg)) {
            return false;
        }
        return Objects.equals(content(), pasteMsg.content());
    }

    @Override
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int hashCode() {
        return Objects.hash(content());
    }

    @Override
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String toString() {
        return "PasteMessage[content=" + content() + "]";
    }
}
