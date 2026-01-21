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
public class WindowSizeMsg extends WindowSizeMessage {

    /**
     * Creates a window size message.
     *
     * @param width terminal width in columns
     * @param height terminal height in rows
     * @deprecated Use {@link WindowSizeMessage#WindowSizeMessage(int, int)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public WindowSizeMsg(int width, int height) {
        super(width, height);
    }
}
