package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for legacy message types.
 * Bubble Tea: bubbletea/tea.go
 */
public interface MessageShim extends Message {

    /**
     * Returns the canonical message representation.
     *
     * @return message instance
     */
    Message toMessage();
}
