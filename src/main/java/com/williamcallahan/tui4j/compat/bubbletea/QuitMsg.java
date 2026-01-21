package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Signals that the program should quit.
 * Bubble Tea: bubbletea/tea.go
 */
public record QuitMsg() implements Message {
}
