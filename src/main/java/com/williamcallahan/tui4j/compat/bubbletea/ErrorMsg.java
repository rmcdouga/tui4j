package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link ErrorMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: tea.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ErrorMsg extends ErrorMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link ErrorMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ErrorMsg(Throwable reason) {
        super(reason);
    }

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link ErrorMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ErrorMsg(String reason) {
        super(reason);
    }
}
