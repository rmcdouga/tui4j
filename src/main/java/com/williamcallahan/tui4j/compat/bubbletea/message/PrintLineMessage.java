package com.williamcallahan.tui4j.compat.bubbletea.message;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.PrintLineMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea standard_renderer.go printLineMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/standard_renderer.go">bubbletea/standard_renderer.go</a>
 */
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
