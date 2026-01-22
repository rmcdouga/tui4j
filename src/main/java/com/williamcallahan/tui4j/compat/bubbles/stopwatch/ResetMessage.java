package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent to reset the stopwatch.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 * <p>
 * Bubbles: filepicker/hidden_windows.go.
 */
public class ResetMessage implements Message {
    private final int id;

    /**
     * Creates a reset message.
     *
     * @param id the stopwatch id
     */
    public ResetMessage(int id) {
        this.id = id;
    }

    /**
     * Returns the stopwatch id.
     *
     * @return the id
     */
    public int id() {
        return id;
    }
}
