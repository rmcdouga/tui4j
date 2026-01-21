package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests setting the terminal window title.
 * <p>
 * Bubble Tea: bubbletea/commands.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
public class SetWindowTitleMessage implements Message {

    private final String title;

    /**
     * Creates a set window title message.
     *
     * @param title window title to set
     */
    public SetWindowTitleMessage(String title) {
        this.title = title;
    }

    /**
     * Returns the window title to set.
     *
     * @return window title
     */
    public String title() {
        return title;
    }
}
