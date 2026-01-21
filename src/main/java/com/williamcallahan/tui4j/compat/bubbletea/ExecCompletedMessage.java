package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link ExecCompletedMsg}.
 * Bubble Tea: bubbletea/exec.go
 */
public class ExecCompletedMessage implements MessageShim {

    private final int exitCode;
    private final Throwable error;

    /**
     * Creates an execution completion message.
     *
     * @param exitCode process exit code
     * @param error execution error, if any
     */
    public ExecCompletedMessage(int exitCode, Throwable error) {
        this.exitCode = exitCode;
        this.error = error;
    }

    /**
     * Returns the process exit code.
     *
     * @return exit code
     */
    public int exitCode() {
        return exitCode;
    }

    /**
     * Returns the execution error, if any.
     *
     * @return execution error
     */
    public Throwable error() {
        return error;
    }

    /**
     * Returns whether the execution completed successfully.
     *
     * @return true when successful
     */
    public boolean success() {
        return new ExecCompletedMsg(exitCode, error).success();
    }

    /**
     * Returns a human-readable error message, if any.
     *
     * @return error message or null when successful
     */
    public String errorMessage() {
        return new ExecCompletedMsg(exitCode, error).errorMessage();
    }

    @Override
    public Message toMessage() {
        return new ExecCompletedMsg(exitCode, error);
    }
}
