package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.Command;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.SequenceMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea commands.go sequenceMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.SequenceMessage} instead.
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0")
public class SequenceMessage extends com.williamcallahan.tui4j.compat.bubbletea.SequenceMessage {

    /**
     * Creates a sequence message from commands.
     *
     * @param commands commands to execute sequentially
     */
    public SequenceMessage(Command... commands) {
        super(commands);
    }
}
