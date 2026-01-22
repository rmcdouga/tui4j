package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link SetMouseCursorTextMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: screen.go.
 */
@Deprecated(since = "0.3.0")
public class SetMouseCursorTextMsg extends SetMouseCursorTextMessage {
    /**
     * Creates a legacy mouse cursor text message.
     */
    public SetMouseCursorTextMsg() {
        super();
    }
}
