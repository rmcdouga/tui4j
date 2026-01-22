package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link SequenceMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class SequenceMsg extends SequenceMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link SequenceMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public SequenceMsg(Command... commands) {
        super(commands);
    }
}
