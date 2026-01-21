package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent when a file is selected in the file picker.
 * <p>
 * Bubbles: bubbles/filepicker/filepicker.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/filepicker/filepicker.go">bubbles/filepicker/filepicker.go</a>
 */
public class DidSelectFileMessage implements Message {

    private final String path;

    /**
     * Creates a file selection message.
     *
     * @param path selected file path
     */
    public DidSelectFileMessage(String path) {
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
