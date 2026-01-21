package com.williamcallahan.tui4j.message;

/**
 * Reports an error from command execution.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.ErrorMessage}
 * for convenient access from the tui4j.message package.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public class ErrorMessage extends com.williamcallahan.tui4j.compat.bubbletea.ErrorMessage {

    /**
     * Creates an error message from a throwable.
     *
     * @param error error payload
     */
    public ErrorMessage(Throwable error) {
        super(error);
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
