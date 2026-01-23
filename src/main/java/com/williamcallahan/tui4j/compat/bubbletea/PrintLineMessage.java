package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message that prints a line to the renderer output.
 * <p>
 * Bubble Tea: standard_renderer.go
 */
public class PrintLineMessage implements Message {

    private final String messageBody;

    /**
     * Creates a print line message.
     *
     * @param messageBody text to print
     */
    public PrintLineMessage(String messageBody) {
        this.messageBody = messageBody;
    }

    /**
     * Returns the text to print.
     *
     * @return message text
     */
    public String messageBody() {
        return messageBody;
    }
}
