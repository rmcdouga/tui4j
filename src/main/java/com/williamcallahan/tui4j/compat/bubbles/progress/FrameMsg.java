package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

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
public class FrameMsg implements Message {

    private final FrameMessage message;

    /**
     * Creates a new frame message.
     *
     * @param id the progress bar's unique identifier
     * @param tag the animation frame tag
     * @deprecated Use {@link FrameMessage#FrameMessage(int, int)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public FrameMsg(int id, int tag) {
        this.message = new FrameMessage(id, tag);
    }

    /**
     * Returns the progress bar's unique identifier.
     *
     * @return the id
     * @deprecated Use {@link FrameMessage#id()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int id() {
        return message.id();
    }

    /**
     * Returns the animation frame tag.
     *
     * @return the tag
     * @deprecated Use {@link FrameMessage#tag()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int tag() {
        return message.tag();
    }
}
