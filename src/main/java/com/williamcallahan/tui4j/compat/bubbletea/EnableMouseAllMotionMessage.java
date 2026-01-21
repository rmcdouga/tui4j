package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Enables "all motion" mouse tracking (report motion without a pressed button).
 * <p>
 * Bubble Tea: bubbletea/screen.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
public class EnableMouseAllMotionMessage implements Message {

    /**
     * Creates an enable mouse all-motion message.
     */
    public EnableMouseAllMotionMessage() {
    }
}
