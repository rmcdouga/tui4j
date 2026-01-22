package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when a command execution completes.
 * <p>
 * Bubble Tea: exec.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 */
public class ExecCompletedMessage implements Message {

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
        return exitCode == 0 && error == null;
    }

    /**
     * Returns a human-readable error message, if any.
     *
     * @return error message or null when successful
     */
    public String errorMessage() {
        if (error != null) {
            return error.getMessage();
        }
        if (exitCode != 0) {
            return "Process exited with code " + exitCode;
        }
        return null;
    }
}
