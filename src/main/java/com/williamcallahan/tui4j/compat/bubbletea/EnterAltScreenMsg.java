package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests entering the alternate screen buffer.
 * Bubble Tea: bubbletea/screen.go
 */
public record EnterAltScreenMsg() implements Message {
}
