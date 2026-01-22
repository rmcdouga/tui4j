package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link EnableMouseAllMotionMsg}.
 * Bubble Tea: bubbletea/screen.go
 */
public class EnableMouseAllMotionMessage implements MessageShim {

    /**
     * Creates an enable mouse all-motion message.
     */
    public EnableMouseAllMotionMessage() {
    }

    @Override
    public Message toMessage() {
        return new EnableMouseAllMotionMsg();
    }
}
