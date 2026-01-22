package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea key.go unknownCSISequenceMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage} instead.
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class UnknownSequenceMessage extends com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage {

    /**
     * Creates an unknown sequence message.
     *
     * @param sequence the unrecognized escape sequence
     */
    public UnknownSequenceMessage(String sequence) {
        super(sequence);
    }
}
