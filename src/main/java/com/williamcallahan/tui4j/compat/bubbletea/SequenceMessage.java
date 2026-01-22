package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message that sequences commands for ordered execution.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 */
public class SequenceMessage implements Message {

    private final Command[] commands;

    /**
     * Creates a sequence message from commands.
     *
     * @param commands commands to execute in order
     */
    public SequenceMessage(Command... commands) {
        this.commands = commands;
    }

    /**
     * Returns the sequenced commands.
     *
     * @return commands
     */
    public Command[] commands() {
        return commands;
    }
}
