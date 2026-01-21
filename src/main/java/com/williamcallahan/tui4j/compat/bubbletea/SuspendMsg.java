package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Port of the Bubble Tea suspend message.
 * Upstream: github.com/charmbracelet/bubbletea (tea.go)
 */
public record SuspendMsg() implements Message {
}
