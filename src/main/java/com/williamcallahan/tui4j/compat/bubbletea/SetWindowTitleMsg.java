package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link SetWindowTitleMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0")
public class SetWindowTitleMsg extends SetWindowTitleMessage {

    /**
     * Creates a legacy window title message.
     *
     * @param title window title
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link SetWindowTitleMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0")
    public SetWindowTitleMsg(String title) {
        super(title);
    }
}
