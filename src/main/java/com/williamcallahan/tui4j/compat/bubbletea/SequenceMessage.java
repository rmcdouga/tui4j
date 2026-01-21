package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Executes commands in order.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
public class SequenceMessage implements Message {

    private final Command[] commands;

    public SequenceMessage(Command... commands) {
        this.commands = commands;
    }

    public Command[] commands() {
        return commands;
    }
}
