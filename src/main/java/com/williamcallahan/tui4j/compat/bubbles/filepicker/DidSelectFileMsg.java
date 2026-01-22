package com.williamcallahan.tui4j.compat.bubbles.filepicker;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link DidSelectFileMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: filepicker/filepicker.go.
 */
@Deprecated(since = "0.3.0")
public class DidSelectFileMsg extends DidSelectFileMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link DidSelectFileMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param path selected file path
     */
    @Deprecated(since = "0.3.0")
    public DidSelectFileMsg(String path) {
        super(path);
    }
}
