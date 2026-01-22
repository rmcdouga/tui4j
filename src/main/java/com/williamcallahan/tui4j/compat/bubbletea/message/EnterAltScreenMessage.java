package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.EnterAltScreenMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea screen.go enterAltScreenMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.EnterAltScreenMessage} instead.
 * Bubble Tea: screen.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class EnterAltScreenMessage extends com.williamcallahan.tui4j.compat.bubbletea.EnterAltScreenMessage {

    /**
     * Creates an enter alternate screen message.
     */
    public EnterAltScreenMessage() {
        super();
    }
}
