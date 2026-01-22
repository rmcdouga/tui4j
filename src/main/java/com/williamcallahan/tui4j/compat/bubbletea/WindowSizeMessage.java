package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message reporting the terminal window size.
 * <p>
 * Bubble Tea: bubbletea/screen.go
 */
public class WindowSizeMessage implements Message {

    private final int width;
    private final int height;

    /**
     * Creates a window size message.
     *
     * @param width terminal width in cells
     * @param height terminal height in cells
     */
    public WindowSizeMessage(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the terminal width in cells.
     *
     * @return width in cells
     */
    public int width() {
        return width;
    }

    /**
     * Returns the terminal height in cells.
     *
     * @return height in cells
     */
    public int height() {
        return height;
    }
}
