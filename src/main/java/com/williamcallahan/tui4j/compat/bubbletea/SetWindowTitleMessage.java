package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link SetWindowTitleMsg}.
 */
public class SetWindowTitleMessage implements MessageShim {

    private final String title;

    public SetWindowTitleMessage(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }

    @Override
    public Message toMessage() {
        return new SetWindowTitleMsg(title);
    }
}
