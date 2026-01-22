package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.EnableMouseAllMotionMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea screen.go enableMouseAllMotionMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.EnableMouseAllMotionMessage} instead.
 * Bubble Tea: screen.go.
 */
@Deprecated(since = "0.3.0")
public class EnableMouseAllMotionMessage extends com.williamcallahan.tui4j.compat.bubbletea.EnableMouseAllMotionMessage {

    /**
     * Creates an enable mouse all-motion message.
     */
    public EnableMouseAllMotionMessage() {
        super();
    }
}
