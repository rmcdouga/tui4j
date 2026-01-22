package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link ResumeMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: tea.go.
 */
@Deprecated(since = "0.3.0")
public class ResumeMsg extends ResumeMessage {
    /**
     * Creates a legacy resume message.
     */
    public ResumeMsg() {
        super();
    }
}
