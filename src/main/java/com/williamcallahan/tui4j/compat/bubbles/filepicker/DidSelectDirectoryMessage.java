package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Compatibility shim for {@link DidSelectDirectoryMsg}.
 * Bubbles: bubbles/filepicker/filepicker.go
 */
public class DidSelectDirectoryMessage extends DidSelectDirectoryMsg implements MessageShim {
    /**
     * Creates a directory selection message.
     *
     * @param path selected directory path
     */
    public DidSelectDirectoryMessage(String path) {
        super(path);
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
