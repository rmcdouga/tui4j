package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.ResumeMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea tea.go ResumeMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/tea.go">bubbletea/tea.go</a>
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.ResumeMessage} instead.
 * Bubble Tea: tea.go.
 */
@Deprecated(since = "0.3.0")
public class ResumeMessage extends com.williamcallahan.tui4j.compat.bubbletea.ResumeMessage {

    /** Creates a resume message. */
    public ResumeMessage() {
        super();
    }
}
