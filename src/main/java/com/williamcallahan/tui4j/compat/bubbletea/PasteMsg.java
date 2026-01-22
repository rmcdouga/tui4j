package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link PasteMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: key.go.
 */
@Deprecated(since = "0.3.0")
public class PasteMsg extends PasteMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link PasteMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param content pasted content
     */
    @Deprecated(since = "0.3.0")
    public PasteMsg(String content) {
        super(content);
    }
}
