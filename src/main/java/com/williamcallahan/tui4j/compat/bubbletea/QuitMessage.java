package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Signals that the program should quit.
 * <p>
 * Bubble Tea: tea.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/tea.go">bubbletea/tea.go</a>
 * <p>
 * Bubble Tea: key_windows.go.
 */
public class QuitMessage implements Message {

    /**
     * Creates a quit message.
     */
    public QuitMessage() {
    }
}
