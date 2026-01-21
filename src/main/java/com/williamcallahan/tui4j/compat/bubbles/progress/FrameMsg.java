package com.williamcallahan.tui4j.compat.bubbles.progress;

/**
 * Message sent on each animation frame of a progress bar.
 * <p>
 * Bubbles: bubbles/progress/progress.go
 *
 * @deprecated Use {@link FrameMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class FrameMsg extends FrameMessage {

    /**
     * Creates a new frame message.
     *
     * @param id the progress bar's unique identifier
     * @param tag the animation frame tag
     * @deprecated Use {@link FrameMessage#FrameMessage(int, int)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public FrameMsg(int id, int tag) {
        super(id, tag);
    }
}
