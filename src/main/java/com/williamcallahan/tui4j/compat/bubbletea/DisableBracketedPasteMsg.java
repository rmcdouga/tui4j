package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Disables bracketed paste mode in the terminal.
 * <p>
 * Bubble Tea: bubbletea/screen.go disableBracketedPasteMsg
 */
public record DisableBracketedPasteMsg() implements Message {
}
