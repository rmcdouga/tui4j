package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests setting the terminal window title.
 * Bubble Tea: bubbletea/commands.go
 *
 * @param title window title to set
 */
public record SetWindowTitleMsg(String title) implements Message {
}
