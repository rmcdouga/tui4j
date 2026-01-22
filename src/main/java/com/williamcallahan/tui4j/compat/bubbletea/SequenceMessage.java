package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Executes commands in order.
 * <p>
 * Bubble Tea: commands.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
public class SequenceMessage implements Message {

    private final Command[] commands;

    /**
     * Creates SequenceMessage to keep this component ready for use.
     *
     * @param commands commands
     */
    public SequenceMessage(Command... commands) {
        this.commands = commands;
    }

    /**
     * Handles commands for this component.
     *
     * @return result
     */
    public Command[] commands() {
        return commands;
    }
}
