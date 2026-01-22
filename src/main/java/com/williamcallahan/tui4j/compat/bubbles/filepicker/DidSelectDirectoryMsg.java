package com.williamcallahan.tui4j.compat.bubbles.filepicker;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link DidSelectDirectoryMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: filepicker/filepicker.go.
 */
@Deprecated(since = "0.3.0")
public class DidSelectDirectoryMsg extends DidSelectDirectoryMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link DidSelectDirectoryMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param path selected directory path
     */
    @Deprecated(since = "0.3.0")
    public DidSelectDirectoryMsg(String path) {
        super(path);
    }
}
