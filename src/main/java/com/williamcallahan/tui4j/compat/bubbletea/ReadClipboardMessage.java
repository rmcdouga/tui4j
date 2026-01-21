package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message requesting clipboard contents via OSC 52.
 * <p>
 * When the renderer receives this message, it sends an OSC 52 read request
 * to the terminal. The terminal responds with clipboard contents which are
 * delivered as a {@link PasteMessage}.
 * <p>
 * Bubble Tea: bubbletea/commands.go (Paste command)
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
public class ReadClipboardMessage implements Message {

    @SuppressWarnings("removal")
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other instanceof ReadClipboardMessage || other instanceof ReadClipboardMsg;
    }

    @Override
    public int hashCode() {
        return ReadClipboardMessage.class.hashCode();
    }

    @Override
    public String toString() {
        return "ReadClipboardMessage[]";
    }
}
