package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent when a directory is selected in the file picker.
 * <p>
 * Bubbles: bubbles/filepicker/filepicker.go
 *
 * @deprecated Use {@link DidSelectDirectoryMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/filepicker/filepicker.go">bubbles/filepicker/filepicker.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class DidSelectDirectoryMsg implements Message {

    private final DidSelectDirectoryMessage message;

    /**
     * Creates a directory selection message.
     *
     * @param path selected directory path
     * @deprecated Use {@link DidSelectDirectoryMessage#DidSelectDirectoryMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public DidSelectDirectoryMsg(String path) {
        this.message = new DidSelectDirectoryMessage(path);
    }

    /** @deprecated Use {@link DidSelectDirectoryMessage#path()} instead. */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public String path() {
        return message.path();
    }
}
