package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Compatibility shim for {@link DidSelectFileMsg}.
 * Bubbles: bubbles/filepicker/filepicker.go
 */
public class DidSelectFileMessage extends DidSelectFileMsg implements MessageShim {
    /**
     * Creates a file selection message.
     *
     * @param path selected file path
     */
    public DidSelectFileMessage(String path) {
        super(path);
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
