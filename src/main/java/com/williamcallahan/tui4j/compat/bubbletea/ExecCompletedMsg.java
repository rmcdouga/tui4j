package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link ExecCompletedMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: exec.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ExecCompletedMsg extends ExecCompletedMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link ExecCompletedMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param exitCode process exit code
     * @param error error cause if execution failed
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ExecCompletedMsg(int exitCode, Throwable error) {
        super(exitCode, error);
    }
}
