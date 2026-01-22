package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.SetWindowTitleMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea commands.go setWindowTitleMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.SetWindowTitleMessage} instead.
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0")
public class SetWindowTitleMessage extends com.williamcallahan.tui4j.compat.bubbletea.SetWindowTitleMessage {

    /**
     * Creates a set window title message.
     *
     * @param title the new window title
     */
    public SetWindowTitleMessage(String title) {
        super(title);
    }
}
