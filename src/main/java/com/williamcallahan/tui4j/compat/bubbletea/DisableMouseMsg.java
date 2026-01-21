package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Disables mouse tracking (motion modes and SGR extended mouse mode).
 * Bubble Tea: bubbletea/screen.go
 */
public record DisableMouseMsg() implements Message {
}
