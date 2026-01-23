package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message that sets the terminal window title.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 */
public class SetWindowTitleMessage implements Message {

    private final String title;

    /**
     * Creates a set window title message.
     *
     * @param title title to set
     */
    public SetWindowTitleMessage(String title) {
        this.title = title;
    }

    /**
     * Returns the requested window title.
     *
     * @return title text
     */
    public String title() {
        return title;
    }
}
