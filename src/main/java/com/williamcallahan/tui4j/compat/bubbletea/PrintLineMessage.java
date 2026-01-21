package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to print a line to the terminal.
 * <p>
 * Bubble Tea: bubbletea/tea.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/tea.go">bubbletea/tea.go</a>
 */
public class PrintLineMessage implements Message {

    private final String messageBody;

    public PrintLineMessage(String messageBody) {
        this.messageBody = messageBody;
    }

    public String messageBody() {
        return messageBody;
    }
}
