package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent when a directory is selected in the file picker.
 * <p>
 * Bubbles: filepicker/filepicker.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/filepicker/filepicker.go">bubbles/filepicker/filepicker.go</a>
 * <p>
 * Bubbles: bubbles.go.
 */
public class DidSelectDirectoryMessage implements Message {

    private final String path;

    /**
     * Creates a directory selection message.
     *
     * @param path selected directory path
     */
    public DidSelectDirectoryMessage(String path) {
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
