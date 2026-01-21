package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.Objects;

/**
 * Message for bracketed paste events.
 * Bubble Tea: bubbletea/key.go (KeyMsg with Paste=true)
 */
public class PasteMsg implements Message {
    private final String content;

    public PasteMsg(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PasteMsg pasteMsg)) {
            return false;
        }
        return Objects.equals(content, pasteMsg.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "PasteMsg[content=" + content + "]";
    }
}
