package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Disables mouse tracking (motion modes and SGR extended mouse mode).
 * <p>
 * Bubble Tea: screen.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * <p>
 * Bubble Tea: key_windows.go.
 */
public class DisableMouseMessage implements Message {

    /**
     * Creates a disable mouse message.
     */
    public DisableMouseMessage() {
    }
}
