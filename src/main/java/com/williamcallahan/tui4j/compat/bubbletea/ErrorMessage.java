package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link ErrorMsg}.
 * Bubble Tea: bubbletea/tea.go
 */
public class ErrorMessage extends ErrorMsg {

    /**
     * Creates an error message from a throwable.
     *
     * @param reason error cause
     */
    public ErrorMessage(Throwable reason) {
        super(reason);
    }

    /**
     * Creates an error message from a reason string.
     *
     * @param reason error message
     */
    public ErrorMessage(String reason) {
        super(reason);
    }
}
