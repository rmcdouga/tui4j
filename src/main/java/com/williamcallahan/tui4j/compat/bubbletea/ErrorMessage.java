package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Reports an error from command execution.
 * <p>
 * Bubble Tea: bubbletea/tea.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/tea.go">bubbletea/tea.go</a>
 */
public class ErrorMessage implements Message {

    private final Throwable reason;

    /**
     * Creates an error message from a throwable.
     *
     * @param reason error cause
     */
    public ErrorMessage(Throwable reason) {
        this.reason = reason;
    }

    /**
     * Creates an error message from a reason string.
     *
     * @param reason error message
     */
    public ErrorMessage(String reason) {
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
