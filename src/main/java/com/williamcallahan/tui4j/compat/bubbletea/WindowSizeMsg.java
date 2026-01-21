package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Reports the terminal size.
 * Bubble Tea: bubbletea/screen.go
 *
 * @param width terminal width in columns
 * @param height terminal height in rows
 */
public record WindowSizeMsg(int width, int height) implements Message {
}
