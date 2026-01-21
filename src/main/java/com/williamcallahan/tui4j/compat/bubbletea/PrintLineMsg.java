package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests printing a line above the program output.
 * Bubble Tea: bubbletea/standard_renderer.go
 *
 * @param messageBody line content
 */
public record PrintLineMsg(String messageBody) implements Message {
}
