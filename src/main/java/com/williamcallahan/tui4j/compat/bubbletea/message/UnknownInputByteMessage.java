package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.UnknownInputByteMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea key.go unknownInputByteMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.UnknownInputByteMessage} instead.
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0")
public class UnknownInputByteMessage extends com.williamcallahan.tui4j.compat.bubbletea.UnknownInputByteMessage {

    /**
     * Creates an unknown input byte message.
     *
     * @param value the unrecognized byte
     */
    public UnknownInputByteMessage(byte value) {
        super(value);
    }
}
