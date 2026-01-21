package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Executes commands concurrently with no ordering guarantees.
 * Bubble Tea: bubbletea/commands.go
 *
 * @param commands commands to execute
 */
public record BatchMsg(Command... commands) implements Message {
}
