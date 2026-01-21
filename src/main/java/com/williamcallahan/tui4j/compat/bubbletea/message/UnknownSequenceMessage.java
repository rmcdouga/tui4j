package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea key.go unknownCSISequenceMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 */
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
