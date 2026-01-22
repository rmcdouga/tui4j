package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link SetWindowTitleMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class SetWindowTitleMsg extends SetWindowTitleMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link SetWindowTitleMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public SetWindowTitleMsg(String title) {
        super(title);
    }
}
