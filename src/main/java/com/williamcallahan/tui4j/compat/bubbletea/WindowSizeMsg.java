package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Reports the terminal size.
 * <p>
 * Bubble Tea: bubbletea/screen.go
 *
 * @deprecated Use {@link WindowSizeMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class WindowSizeMsg implements Message {

    private final WindowSizeMessage message;

    /**
     * Creates a window size message.
     *
     * @param width terminal width in columns
     * @param height terminal height in rows
     * @deprecated Use {@link WindowSizeMessage#WindowSizeMessage(int, int)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public WindowSizeMsg(int width, int height) {
        this.message = new WindowSizeMessage(width, height);
    }

    /**
     * Returns the terminal width in columns.
     *
     * @return width in columns
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int width() {
        return message.width();
    }

    /**
     * Returns the terminal height in rows.
     *
     * @return height in rows
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public int height() {
        return message.height();
    }
}
