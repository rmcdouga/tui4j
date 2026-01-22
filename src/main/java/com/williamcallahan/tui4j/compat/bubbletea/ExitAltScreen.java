package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to exit the alternate screen buffer.
 * <p>
 * Legacy alias for {@link ExitAltScreenMessage}.
 * <p>
 * Bubble Tea: screen.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 *
 * @deprecated Compatibility shim for relocated type; use {@link ExitAltScreenMessage} instead.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ExitAltScreen extends ExitAltScreenMessage {

    /**
     * Creates an exit alternate screen message.
     */
    public ExitAltScreen() {
    }
}
