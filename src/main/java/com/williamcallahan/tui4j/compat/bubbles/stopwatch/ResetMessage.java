package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Reset message for stopwatch.
 * <p>
 * Bubbles: stopwatch/stopwatch.go ResetMessage type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 */
public class ResetMessage implements Message {

    private final int id;

    /**
     * Creates a reset message.
     *
     * @param id stopwatch identifier
     */
    public ResetMessage(int id) {
        this.id = id;
    }

    /**
     * Returns the stopwatch identifier.
     *
     * @return stopwatch id
     */
    public int id() {
        return id;
    }
}
