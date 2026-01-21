package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Enables "all motion" mouse tracking (report motion without a pressed button).
 * Bubble Tea: bubbletea/screen.go
 */
public record EnableMouseAllMotionMsg() implements Message {
}
