package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to open a URL in the default browser.
 * Bubble Tea: commands.go
 *
 * @param url URL to open
 */
public record OpenUrlMessage(String url) implements Message {
}
