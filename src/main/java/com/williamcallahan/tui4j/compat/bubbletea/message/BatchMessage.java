package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.Command;

/**
 * Legacy package shim for {@link com.williamcallahan.tui4j.compat.bubbletea.BatchMessage}.
 * Bubble Tea: bubbletea/commands.go
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
