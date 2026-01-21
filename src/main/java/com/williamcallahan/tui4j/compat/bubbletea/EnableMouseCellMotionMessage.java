package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link EnableMouseCellMotionMsg}.
 * Bubble Tea: bubbletea/screen.go
 */
public class EnableMouseCellMotionMessage implements MessageShim {

    /**
     * Creates an enable mouse cell-motion message.
     */
    public EnableMouseCellMotionMessage() {
    }

    @Override
    public Message toMessage() {
        return new EnableMouseCellMotionMsg();
    }
}
