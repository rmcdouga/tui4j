package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Port of the file picker file selection message.
 * Bubbles: bubbles/filepicker/filepicker.go
 */
public class DidSelectFileMsg implements Message {

    private final String path;

    /**
     * Creates a file selection message.
     *
     * @param path selected file path
     */
    public DidSelectFileMsg(String path) {
        this.path = path;
    }

    /**
     * Returns the selected file path.
     *
     * @return file path
     */
    public String path() {
        return path;
    }
}
