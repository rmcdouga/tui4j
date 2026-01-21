package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link SetMouseCursorPointerMsg}.
 * Bubble Tea: bubbletea/screen.go (tui4j extension; no direct equivalent).
 */
public class SetMouseCursorPointerMessage implements MessageShim {

    /**
     * Creates a set mouse cursor pointer message.
     */
    public SetMouseCursorPointerMessage() {
    }

    @Override
    public Message toMessage() {
        return new SetMouseCursorPointerMsg();
    }
}
