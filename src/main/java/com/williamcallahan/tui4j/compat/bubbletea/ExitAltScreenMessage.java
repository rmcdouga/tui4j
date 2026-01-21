package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to exit the alternate screen buffer.
 * <p>
 * Port of charmbracelet/bubbletea screen.go exitAltScreenMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
public class ExitAltScreenMessage implements Message {

    /** Creates a new exit alt screen message. */
    public ExitAltScreenMessage() {}
}
