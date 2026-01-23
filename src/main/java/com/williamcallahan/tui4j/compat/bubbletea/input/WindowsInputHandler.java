package com.williamcallahan.tui4j.compat.bubbletea.input;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import java.util.function.Consumer;
import org.jline.terminal.Terminal;

/**
 * Windows input handler compatibility shim.
 * <p>
 * Bubble Tea: inputreader_windows.go, key_windows.go.
 */
public class WindowsInputHandler extends NewInputHandler {

    /**
     * Creates a Windows input handler backed by the standard ANSI reader.
     *
     * @param terminal terminal to read from
     * @param messageConsumer consumer for incoming messages
     */
    public WindowsInputHandler(Terminal terminal, Consumer<Message> messageConsumer) {
        super(terminal, messageConsumer);
    }
}
