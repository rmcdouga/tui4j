package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link BatchMsg}.
 * Bubble Tea: bubbletea/commands.go
 */
public class BatchMessage implements MessageShim {

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

    @Override
    public Message toMessage() {
        return new BatchMsg(commands);
    }
}
