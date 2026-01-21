package com.williamcallahan.tui4j.compat.bubbles.progress;

/**
 * Message sent to set the progress bar percentage.
 * <p>
 * Bubbles: bubbles/progress/progress.go
 *
 * @deprecated Use {@link SetPercentMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class SetPercentMsg extends SetPercentMessage {

    /**
     * Creates a set percent message.
     *
     * @param percent the new percentage (0.0 to 1.0)
     * @deprecated Use {@link SetPercentMessage#SetPercentMessage(double)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public SetPercentMsg(double percent) {
        super(percent);
    }
}
