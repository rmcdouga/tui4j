package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to copy text to the system clipboard.
 * Bubble Tea: commands.go
 *
 * @param text text to copy
 */
public record CopyToClipboardMessage(String text) implements Message {
}
