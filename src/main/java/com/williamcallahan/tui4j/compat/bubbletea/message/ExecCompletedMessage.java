package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Legacy package shim for {@link com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage}.
 * Bubble Tea: bubbletea/exec.go
 */
public class ExecCompletedMessage extends com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage {

    /**
     * Creates an execution completion message.
     *
     * @param exitCode process exit code
     * @param error execution error, if any
     */
    public ExecCompletedMessage(int exitCode, Throwable error) {
        super(exitCode, error);
    }
}
