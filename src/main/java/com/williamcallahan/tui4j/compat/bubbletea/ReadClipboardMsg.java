package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message requesting clipboard contents via OSC 52.
 * When the renderer receives this message, it sends an OSC 52 read request
 * to the terminal. The terminal responds with clipboard contents which are
 * delivered as a {@link PasteMsg}.
 * <p>
 * Bubble Tea: bubbletea/commands.go (Paste command)
 */
public class ReadClipboardMsg implements Message {

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other instanceof ReadClipboardMsg;
    }

    @Override
    public int hashCode() {
        return ReadClipboardMsg.class.hashCode();
    }

    @Override
    public String toString() {
        return "ReadClipboardMsg[]";
    }
}
