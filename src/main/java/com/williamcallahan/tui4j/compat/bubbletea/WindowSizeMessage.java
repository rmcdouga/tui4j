package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Reports the terminal size.
 * <p>
 * Bubble Tea: screen.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * <p>
 * Bubble Tea: key_windows.go.
 */
public class WindowSizeMessage implements Message {

    private final int width;
    private final int height;

    /**
     * Creates a window size message.
     *
     * @param width terminal width in columns
     * @param height terminal height in rows
     */
    public WindowSizeMessage(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the terminal width in columns.
     *
     * @return width in columns
     */
    public int width() {
        return width;
    }

    /**
     * Returns the terminal height in rows.
     *
     * @return height in rows
     */
    public int height() {
        return height;
    }
}
