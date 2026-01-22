package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for legacy message types.
 * Bubble Tea: tea.go.
 * <p>
 * Bubble Tea: key_windows.go.
 */
public interface MessageShim extends Message {

    /**
     * Returns the canonical message representation.
     *
     * @return message instance
     */
    Message toMessage();
}
