package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea exec.go execCompletedMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage} instead.
 * Bubble Tea: exec.go.
 */
@Deprecated(since = "0.3.0")
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
