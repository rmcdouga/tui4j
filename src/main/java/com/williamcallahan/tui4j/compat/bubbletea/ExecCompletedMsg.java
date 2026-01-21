package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when a process execution completes.
 * <p>
 * Bubble Tea: bubbletea/exec.go
 *
 * @deprecated Use {@link ExecCompletedMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ExecCompletedMsg extends ExecCompletedMessage {

    /**
     * Creates an execution completion message.
     *
     * @param exitCode process exit code
     * @param error execution error, if any
     * @deprecated Use {@link ExecCompletedMessage#ExecCompletedMessage(int, Throwable)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ExecCompletedMsg(int exitCode, Throwable error) {
        super(exitCode, error);
    }
}
