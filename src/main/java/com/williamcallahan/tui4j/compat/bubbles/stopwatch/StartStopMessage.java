package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Start/stop message for stopwatch control.
 * <p>
 * Bubbles: stopwatch/stopwatch.go StartStopMessage type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/stopwatch/stopwatch.go">bubbles/stopwatch/stopwatch.go</a>
 */
public class StartStopMessage implements Message {

    private final int id;
    private final boolean running;

    /**
     * Creates a start/stop message.
     *
     * @param id stopwatch identifier
     * @param running whether the stopwatch should be running
     */
    public StartStopMessage(int id, boolean running) {
        this.id = id;
        this.running = running;
    }

    /**
     * Returns the stopwatch identifier.
     *
     * @return stopwatch id
     */
    public int id() {
        return id;
    }

    /**
     * Returns whether the stopwatch should be running.
     *
     * @return true if running
     */
    public boolean running() {
        return running;
    }
}
