package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message for bracketed paste events.
 * Bubble Tea: bubbletea/key.go (KeyMsg with Paste=true)
 */
public class PasteMessage extends PasteMsg implements MessageShim {
    public PasteMessage(String content) {
        super(content);
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
