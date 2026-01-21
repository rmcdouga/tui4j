package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link PrintLineMsg}.
 */
public class PrintLineMessage implements MessageShim {

    private final String messageBody;

    public PrintLineMessage(String messageBody) {
        this.messageBody = messageBody;
    }

    public String messageBody() {
        return messageBody;
    }

    @Override
    public Message toMessage() {
        return new PrintLineMsg(messageBody);
    }
}
