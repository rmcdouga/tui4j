package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.PrintLineMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea standard_renderer.go printLineMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/standard_renderer.go">bubbletea/standard_renderer.go</a>
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.PrintLineMessage} instead.
 * Bubble Tea: standard_renderer.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
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
