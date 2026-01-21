package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Executes commands in order.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 *
 * @deprecated Use {@link SequenceMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class SequenceMsg extends SequenceMessage {

    /**
     * Creates a sequence of commands.
     *
     * @param commands commands to execute in order
     * @deprecated Use {@link SequenceMessage#SequenceMessage(Command...)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public SequenceMsg(Command... commands) {
        super(commands);
    }
}
