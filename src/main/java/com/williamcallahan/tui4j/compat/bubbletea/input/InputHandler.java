package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Port of Bubble Tea input handler.
 * Upstream: github.com/charmbracelet/bubbletea/inputreader_other.go
 */
public interface InputHandler {
    /**
     * Starts reading input.
     */
    void start();

    /**
     * Stops reading input.
     */
    void stop();
}
