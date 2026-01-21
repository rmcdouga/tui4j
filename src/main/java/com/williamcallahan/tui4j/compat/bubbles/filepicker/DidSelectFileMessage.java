package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Message sent when a file is selected in the file picker.
 * <p>
 * Bubbles: bubbles/filepicker/filepicker.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/filepicker/filepicker.go">bubbles/filepicker/filepicker.go</a>
 */
@SuppressWarnings("deprecation")
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
