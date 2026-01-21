package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Port of the file picker directory selection message.
 * Bubbles: bubbles/filepicker/filepicker.go
 */
public class DidSelectDirectoryMsg implements Message {

    private final String path;

    /**
     * Creates a directory selection message.
     *
     * @param path selected directory path
     */
    public DidSelectDirectoryMsg(String path) {
        this.path = path;
    }

    /**
     * Returns the selected directory path.
     *
     * @return directory path
     */
    public String path() {
        return path;
    }
}
