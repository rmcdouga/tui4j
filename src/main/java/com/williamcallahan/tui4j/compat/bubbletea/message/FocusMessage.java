package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.FocusMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea focus.go FocusMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/focus.go">bubbletea/focus.go</a>
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.FocusMessage} instead.
 * Bubble Tea: focus.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class FocusMessage extends com.williamcallahan.tui4j.compat.bubbletea.FocusMessage {

    /** Creates a new focus message. */
    public FocusMessage() {
        super();
    }
}
