package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.WindowSizeMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea screen.go WindowSizeMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.WindowSizeMessage} instead.
 * Bubble Tea: screen.go.
 */
@Deprecated(since = "0.3.0")
public class WindowSizeMessage extends com.williamcallahan.tui4j.compat.bubbletea.WindowSizeMessage {

    /**
     * Creates a window size message.
     *
     * @param width the window width in columns
     * @param height the window height in rows
     */
    public WindowSizeMessage(int width, int height) {
        super(width, height);
    }
}
