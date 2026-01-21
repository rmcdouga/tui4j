package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Port of Bubble Tea error message.
 * <p>
 * Bubble Tea: bubbletea/tea.go
 *
 * @deprecated Use {@link ErrorMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/tea.go">bubbletea/tea.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ErrorMsg implements Message {

    private final ErrorMessage message;

    /**
     * Creates an error message from a throwable.
     *
     * @param reason error cause
     * @deprecated Use {@link ErrorMessage#ErrorMessage(Throwable)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ErrorMsg(Throwable reason) {
        this.message = new ErrorMessage(reason);
    }

    /**
     * Creates an error message from a reason string.
     *
     * @param reason error message
     * @deprecated Use {@link ErrorMessage#ErrorMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ErrorMsg(String reason) {
        this.message = new ErrorMessage(reason);
    }

    /**
     * Returns the underlying error.
     *
     * @return error cause
     * @deprecated Use {@link ErrorMessage#error()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Throwable error() {
        return message.error();
    }
}
