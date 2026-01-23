package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message that sequences commands for ordered execution.
 * <p>
 * When the runtime receives this message, it executes the contained commands
 * one at a time, in order. Contrast with {@link BatchMessage}, which runs
 * commands concurrently with no ordering guarantees.
 * <p>
 * <b>Not to be confused with {@link com.williamcallahan.tui4j.message.SequencedMessage}</b>,
 * a tui4j extension that tags a message with a correlation ID for tracking asynchronous
 * results. This class controls <em>when</em> commands run; {@code SequencedMessage}
 * tracks <em>where</em> results came from.
 * <p>
 * Bubble Tea: bubbletea/commands.go (sequenceMsg)
 *
 * @see com.williamcallahan.tui4j.message.SequencedMessage
 * @see BatchMessage
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
