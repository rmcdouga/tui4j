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
public class ExecCompletedMsg implements Message {

    private final ExecCompletedMessage message;

    /**
     * Creates an execution completion message.
     *
     * @param exitCode process exit code
     * @param error execution error, if any
     * @deprecated Use {@link ExecCompletedMessage#ExecCompletedMessage(int, Throwable)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ExecCompletedMsg(int exitCode, Throwable error) {
        this.message = new ExecCompletedMessage(exitCode, error);
    }

    /**
     * Returns the process exit code.
     *
     * @return exit code
     * @deprecated Use {@link ExecCompletedMessage#exitCode()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int exitCode() {
        return message.exitCode();
    }

    /**
     * Returns the execution error, if any.
     *
     * @return execution error
     * @deprecated Use {@link ExecCompletedMessage#error()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Throwable error() {
        return message.error();
    }

    /**
     * Returns whether the execution completed successfully.
     *
     * @return true when successful
     * @deprecated Use {@link ExecCompletedMessage#success()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public boolean success() {
        return message.success();
    }

    /**
     * Returns a human-readable error message, if any.
     *
     * @return error message or null when successful
     * @deprecated Use {@link ExecCompletedMessage#errorMessage()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String errorMessage() {
        return message.errorMessage();
    }
}
