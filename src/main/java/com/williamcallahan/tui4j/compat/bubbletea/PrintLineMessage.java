package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to print a line to the terminal.
 * <p>
 * Bubble Tea: standard_renderer.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/tea.go">bubbletea/tea.go</a>
 * <p>
 * Bubble Tea: key_windows.go.
 */
public class PrintLineMessage implements Message {

    private final String messageBody;

    /**
     * Creates PrintLineMessage to keep this component ready for use.
     *
     * @param messageBody message body
     */
    public PrintLineMessage(String messageBody) {
        this.messageBody = messageBody;
    }

    /**
     * Handles message body for this component.
     *
     * @return result
     */
    public String messageBody() {
        return messageBody;
    }
}
