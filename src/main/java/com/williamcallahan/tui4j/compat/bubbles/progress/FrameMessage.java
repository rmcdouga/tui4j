package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Message sent on each animation frame of a progress bar.
 * <p>
 * Port of charmbracelet/bubbles progress/progress.go FrameMsg type.
 * Preferred alias for {@link FrameMsg}.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 */
public class FrameMessage implements MessageShim {
    private final int id;
    private final int tag;

    /**
     * Creates a new frame message.
     *
     * @param id the progress bar's unique identifier
     * @param tag the animation frame tag
     */
    public FrameMessage(int id, int tag) {
        this.id = id;
        this.tag = tag;
    }

    /**
     * Returns the progress bar's unique identifier.
     *
     * @return the id
     */
    public int id() {
        return id;
    }

    /**
     * Returns the animation frame tag.
     *
     * @return the tag
     */
    public int tag() {
        return tag;
    }

    @Override
    public Message toMessage() {
        return new FrameMsg(id, tag);
    }
}
