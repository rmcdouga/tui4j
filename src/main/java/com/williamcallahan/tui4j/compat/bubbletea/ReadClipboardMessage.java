package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message requesting clipboard contents via OSC 52.
 * <p>
 * Bubble Tea: bubbletea/commands.go (Paste command)
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
 */
public class ReadClipboardMessage implements MessageShim {

    private static final ReadClipboardMsg INSTANCE = new ReadClipboardMsg();

    @Override
    public Message toMessage() {
        return INSTANCE;
    }
}
