package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message that batches commands for execution.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 */
public class BatchMessage implements Message {

    private final Command[] commands;

    /**
     * Creates a batch message from commands.
     *
     * @param commands commands to batch
     */
    public BatchMessage(Command... commands) {
        this.commands = commands;
    }

    /**
     * Returns the batched commands.
     *
     * @return commands
     */
    public Command[] commands() {
        return commands;
    }
}
