package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message containing multiple commands to run in batch.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
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
