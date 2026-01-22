package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link SequenceMsg}.
 */
public class SequenceMessage implements MessageShim {

    private final Command[] commands;

    public SequenceMessage(Command... commands) {
        this.commands = commands;
    }

    public Command[] commands() {
        return commands;
    }

    @Override
    public Message toMessage() {
        return new SequenceMsg(commands);
    }
}
