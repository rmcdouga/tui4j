package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Port of Bubble Tea error message.
 * Bubble Tea: bubbletea/tea.go
 */
public class ErrorMsg implements Message {

    private final Throwable reason;

    /**
     * Creates an error message from a throwable.
     *
     * @param reason error cause
     */
    public ErrorMsg(Throwable reason) {
        this.reason = reason;
    }

    /**
     * Creates an error message from a reason string.
     *
     * @param reason error message
     */
    public ErrorMsg(String reason) {
        this.reason = new RuntimeException(reason);
    }

    /**
     * Returns the underlying error.
     *
     * @return error cause
     */
    public Throwable error() {
        return reason;
    }
}
