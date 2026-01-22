package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent on each animation frame of a progress bar.
 * <p>
 * Bubbles: progress/progress.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 * <p>
 * Bubbles: filepicker/hidden_windows.go.
 */
public class FrameMessage implements Message {
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
}
