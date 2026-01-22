package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * Compatibility helper for NoopInputHandler to keep API parity.
 * <p>
 * Bubble Tea: inputreader_other.go.
 */
public class NoopInputHandler implements InputHandler {

    /**
     * Creates a no-op input handler.
     */
    public NoopInputHandler() {
    }

    /**
     * Handles start for this component.
     */
    @Override
    public void start() {}
    /**
     * Handles stop for this component.
     */
    @Override
    public void stop() {}
}
