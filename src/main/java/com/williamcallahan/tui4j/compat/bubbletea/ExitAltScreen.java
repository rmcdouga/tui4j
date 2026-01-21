package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to exit the alternate screen buffer.
 * <p>
 * Port of charmbracelet/bubbletea screen.go exitAltScreenMsg type.
 * Legacy alias for {@link ExitAltScreenMessage}.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
public class ExitAltScreen extends ExitAltScreenMessage {

    /** Creates a new exit alt screen message. */
    public ExitAltScreen() {}
}
