package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.Command;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.SequenceMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea commands.go sequenceMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
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
