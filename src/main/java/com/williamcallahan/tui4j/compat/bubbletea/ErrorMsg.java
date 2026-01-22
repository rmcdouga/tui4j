package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link ErrorMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: tea.go.
 */
@Deprecated(since = "0.3.0")
public class ErrorMsg extends ErrorMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link ErrorMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param reason error cause
     */
    @Deprecated(since = "0.3.0")
    public ErrorMsg(Throwable reason) {
        super(reason);
    }

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link ErrorMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param reason error message
     */
    @Deprecated(since = "0.3.0")
    public ErrorMsg(String reason) {
        super(reason);
    }
}
