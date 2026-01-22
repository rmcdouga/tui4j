package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to enter the alternate screen buffer.
 * <p>
 * Legacy alias for {@link EnterAltScreenMessage}.
 * <p>
 * Bubble Tea: screen.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * <p>
 * Bubble Tea: key_windows.go.
 * @deprecated Compatibility shim for relocated type; use {@link EnterAltScreenMessage} instead.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class EnterAltScreen extends EnterAltScreenMessage {

    /**
     * Creates an enter alternate screen message.
     */
    public EnterAltScreen() {
    }
}
