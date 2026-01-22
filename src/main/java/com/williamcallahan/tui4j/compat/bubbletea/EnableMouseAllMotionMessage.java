package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Enables "all motion" mouse tracking (report motion without a pressed button).
 * <p>
 * Bubble Tea: screen.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * <p>
 * Bubble Tea: key_windows.go.
 */
public class EnableMouseAllMotionMessage implements Message {

    /**
     * Creates an enable mouse all-motion message.
     */
    public EnableMouseAllMotionMessage() {
    }
}
