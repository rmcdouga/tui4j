package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link SequenceMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0")
public class SequenceMsg extends SequenceMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link SequenceMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param commands commands to run sequentially
     */
    @Deprecated(since = "0.3.0")
    public SequenceMsg(Command... commands) {
        super(commands);
    }
}
