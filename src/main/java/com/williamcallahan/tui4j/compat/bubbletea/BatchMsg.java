package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Executes commands concurrently with no ordering guarantees.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 *
 * @deprecated Use {@link BatchMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class BatchMsg implements Message {

    private final BatchMessage message;

    /**
     * Creates a batch of commands.
     *
     * @param commands commands to execute
     * @deprecated Use {@link BatchMessage#BatchMessage(Command...)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public BatchMsg(Command... commands) {
        this.message = new BatchMessage(commands);
    }

    /**
     * Returns the batched commands.
     *
     * @return commands
     * @deprecated Use {@link BatchMessage#commands()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Command[] commands() {
        return message.commands();
    }
}
