package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link PrintLineMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: standard_renderer.go.
 */
@Deprecated(since = "0.3.0")
public class PrintLineMsg extends PrintLineMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link PrintLineMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param messageBody line to print
     */
    @Deprecated(since = "0.3.0")
    public PrintLineMsg(String messageBody) {
        super(messageBody);
    }
}
