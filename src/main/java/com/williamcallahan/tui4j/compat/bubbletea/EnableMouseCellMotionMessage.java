package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Enables "cell motion" mouse tracking (report motion while a button is pressed).
 * <p>
 * Bubble Tea: screen.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * <p>
 * Bubble Tea: key_windows.go.
 */
public class EnableMouseCellMotionMessage implements Message {

    /**
     * Creates an enable mouse cell-motion message.
     */
    public EnableMouseCellMotionMessage() {
    }
}
