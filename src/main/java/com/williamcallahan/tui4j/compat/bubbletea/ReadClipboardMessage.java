package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message requesting clipboard contents via OSC 52.
 * <p>
 * When the renderer receives this message, it sends an OSC 52 read request
 * to the terminal. The terminal responds with clipboard contents which are
 * delivered as a {@link PasteMessage}.
 * <p>
 * Bubble Tea: commands.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
public class ReadClipboardMessage implements Message {

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
        return other instanceof ReadClipboardMessage || other instanceof ReadClipboardMsg;
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return ReadClipboardMessage.class.hashCode();
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "ReadClipboardMessage[]";
    }
}
