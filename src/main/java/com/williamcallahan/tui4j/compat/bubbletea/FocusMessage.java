package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when the terminal window gains focus.
 * <p>
 * Port of charmbracelet/bubbletea focus.go FocusMessage type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/focus.go">bubbletea/focus.go</a>
 */
public class FocusMessage implements Message {

    /**
     * Creates a new focus message.
     */
    public FocusMessage() {
    }
}
