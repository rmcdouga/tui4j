package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when a process execution completes.
 * <p>
 * Bubble Tea: bubbletea/exec.go
 *
 * @param exitCode process exit code
 * @param error execution error, if any
 * @deprecated Use {@link ExecCompletedMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record ExecCompletedMsg(int exitCode, Throwable error) implements Message {

    /**
     * Checks if the process completed successfully (exit code 0 and no execution error).
     * <p>
     * Note: This method returns false if an execution error occurred (e.g., failed to start),
     * even if exitCode happens to be 0 (though -1 is standard for execution errors).
     *
     * @return true when execution succeeds
     */
    public boolean success() {
        return error == null && exitCode == 0;
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
