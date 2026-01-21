package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.Command;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.BatchMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea commands.go BatchMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
public class BatchMessage extends com.williamcallahan.tui4j.compat.bubbletea.BatchMessage {

    /**
     * Creates a batch message from commands.
     *
     * @param commands commands to batch
     */
    public BatchMessage(Command... commands) {
        super(commands);
    }
}
