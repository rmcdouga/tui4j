package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent to start or stop the stopwatch.
 * <p>
 * Bubbles: stopwatch/stopwatch.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 * <p>
 * Bubbles: filepicker/hidden_windows.go.
 */
public class StartStopMessage implements Message {
    private final int id;
    private final boolean running;

    /**
     * Creates a start/stop message.
     *
     * @param id the stopwatch id
     * @param running whether the stopwatch should run
     */
    public StartStopMessage(int id, boolean running) {
        this.id = id;
        this.running = running;
    }

    /**
     * Returns the stopwatch id.
     *
     * @return the id
     */
    public int id() {
        return id;
    }

    /**
     * Returns whether the stopwatch should run.
     *
     * @return true if the stopwatch should run
     */
    public boolean running() {
        return running;
    }
}
