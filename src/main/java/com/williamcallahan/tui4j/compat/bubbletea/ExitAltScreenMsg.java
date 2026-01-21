package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests exiting the alternate screen buffer.
 * Bubble Tea: bubbletea/screen.go
 */
public record ExitAltScreenMsg() implements Message {
}
