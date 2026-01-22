package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to exit the alternate screen buffer.
 * <p>
 * Port of charmbracelet/bubbletea screen.go exitAltScreenMsg type.
 * Legacy alias for {@link ExitAltScreenMessage}.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * <p>
 * Bubble Tea: screen.go.
 * @deprecated Compatibility shim for relocated type; use {@link ExitAltScreenMessage} instead.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ExitAltScreen extends ExitAltScreenMessage {

    /** Creates a new exit alt screen message. */
    public ExitAltScreen() {}
}
