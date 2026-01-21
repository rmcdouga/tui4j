package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link ResetMouseCursorMsg}.
 * Bubble Tea: bubbletea/screen.go (tui4j extension; no direct equivalent).
 */
public class ResetMouseCursorMessage implements MessageShim {

    /**
     * Creates a reset mouse cursor message.
     */
    public ResetMouseCursorMessage() {
    }

    @Override
    public Message toMessage() {
        return new ResetMouseCursorMsg();
    }
}
