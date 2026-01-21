package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message sent when the terminal window gains focus.
 * <p>
 * Port of charmbracelet/bubbletea focus.go FocusMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/focus.go">bubbletea/focus.go</a>
 */
@SuppressWarnings("deprecation")
public class FocusMessage extends FocusMsg implements MessageShim {

    /** Creates a new focus message. */
    public FocusMessage() {
        super();
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
