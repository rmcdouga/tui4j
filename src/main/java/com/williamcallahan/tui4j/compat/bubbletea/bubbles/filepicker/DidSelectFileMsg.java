package com.williamcallahan.tui4j.compat.bubbletea.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbles.filepicker.DidSelectFileMessage;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link DidSelectFileMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: filepicker/filepicker.go.
 */
@Deprecated(since = "0.3.0")
public class DidSelectFileMsg extends DidSelectFileMessage {
    /**
     * Creates DidSelectFileMsg to keep this component ready for use.
     *
     * @param path path
     */
    public DidSelectFileMsg(String path) {
        super(path);
    }
}
