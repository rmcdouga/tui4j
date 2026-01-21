package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.SetWindowTitleMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea commands.go setWindowTitleMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
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
