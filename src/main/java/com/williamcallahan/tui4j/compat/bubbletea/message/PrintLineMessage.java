package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.PrintLineMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea standard_renderer.go printLineMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/standard_renderer.go">bubbletea/standard_renderer.go</a>
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.PrintLineMessage} instead.
 * Bubble Tea: standard_renderer.go.
 */
@Deprecated(since = "0.3.0")
public class PrintLineMessage extends com.williamcallahan.tui4j.compat.bubbletea.PrintLineMessage {

    /**
     * Creates a print line message.
     *
     * @param messageBody the text to print
     */
    public PrintLineMessage(String messageBody) {
        super(messageBody);
    }
}
