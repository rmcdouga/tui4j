package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to exit the alternate screen buffer.
 * <p>
 * Port of charmbracelet/bubbletea screen.go exitAltScreenMsg type.
 * Preferred alias for {@link ExitAltScreenMsg}.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
public class ExitAltScreenMessage extends ExitAltScreen {

    /** Creates a new exit alt screen message. */
    public ExitAltScreenMessage() {}
}
