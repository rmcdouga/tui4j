package com.williamcallahan.tui4j.compat.bubbletea.input;

/**
 * No-op input handler used when input handling is disabled.
 * tui4j extension; no Bubble Tea equivalent.
 */
public class NoopInputHandler implements InputHandler {

    /**
     * Creates a no-op input handler.
     */
    public NoopInputHandler() {
    }

    @Override
    public void start() {}
    @Override
    public void stop() {}
}
