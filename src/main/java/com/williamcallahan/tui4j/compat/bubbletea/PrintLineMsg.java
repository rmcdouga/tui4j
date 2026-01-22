package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link PrintLineMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: standard_renderer.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class PrintLineMsg extends PrintLineMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link PrintLineMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public PrintLineMsg(String messageBody) {
        super(messageBody);
    }
}
