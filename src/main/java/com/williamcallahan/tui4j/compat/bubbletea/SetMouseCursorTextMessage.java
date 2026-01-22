package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link SetMouseCursorTextMsg}.
 * Bubble Tea: bubbletea/screen.go (tui4j extension; no direct equivalent).
 */
public class SetMouseCursorTextMessage implements MessageShim {

    /**
     * Creates a set mouse cursor text message.
     */
    public SetMouseCursorTextMessage() {
    }

    @Override
    public Message toMessage() {
        return new SetMouseCursorTextMsg();
    }
}
