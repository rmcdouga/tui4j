package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent when a file is selected in the file picker.
 * <p>
 * Bubbles: bubbles/filepicker/filepicker.go
 *
 * @deprecated Use {@link DidSelectFileMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/filepicker/filepicker.go">bubbles/filepicker/filepicker.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class DidSelectFileMsg implements Message {

    private final String path;

    /**
     * Creates a file selection message.
     *
     * @param path selected file path
     * @deprecated Use {@link DidSelectFileMessage#DidSelectFileMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public DidSelectFileMsg(String path) {
        this.path = path;
    }

    /**
     * Returns the selected file path.
     *
     * @return file path
     * @deprecated Use {@link DidSelectFileMessage#path()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String path() {
        return path;
    }
}
