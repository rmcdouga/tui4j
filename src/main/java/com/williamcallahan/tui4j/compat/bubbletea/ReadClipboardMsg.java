package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message requesting clipboard contents via OSC 52.
 * When the renderer receives this message, it sends an OSC 52 read request
 * to the terminal. The terminal responds with clipboard contents which are
 * delivered as a {@link PasteMessage}.
 * <p>
 * Bubble Tea: bubbletea/commands.go (Paste command)
 *
 * @deprecated Use {@link ReadClipboardMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ReadClipboardMsg implements Message {

    @Override
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other instanceof ReadClipboardMsg || other instanceof ReadClipboardMessage;
    }

    @Override
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int hashCode() {
        return ReadClipboardMessage.class.hashCode();
    }

    @Override
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String toString() {
        return "ReadClipboardMessage[]";
    }
}
