package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Interface for handling terminal input events.
 * <p>
 * Port of charmbracelet/bubbletea inputreader_other.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/inputreader_other.go">bubbletea/inputreader_other.go</a>
 */
public interface InputHandler {

    /** Starts listening for input events. */
    void start();

    /** Stops listening for input events. */
    void stop();
}
