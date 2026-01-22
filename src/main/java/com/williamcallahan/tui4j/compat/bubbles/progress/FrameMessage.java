package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Animation frame message for progress bar updates.
 * <p>
 * Bubbles: progress/progress.go FrameMessage type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 */
public class FrameMessage implements Message {

    private final int id;
    private final int tag;

    /**
     * Creates a frame message.
     *
     * @param id progress identifier
     * @param tag animation tag
     */
    public FrameMessage(int id, int tag) {
        this.id = id;
        this.tag = tag;
    }

    /**
     * Returns the progress identifier.
     *
     * @return progress id
     */
    public int id() {
        return id;
    }

    /**
     * Returns the animation tag.
     *
     * @return animation tag
     */
    public int tag() {
        return tag;
    }
}
