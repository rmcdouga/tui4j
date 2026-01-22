package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.Command;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.BatchMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0")
public class BatchMessage extends com.williamcallahan.tui4j.compat.bubbletea.BatchMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.BatchMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param commands commands to batch
     */
    @Deprecated(since = "0.3.0")
    public BatchMessage(Command... commands) {
        super(commands);
    }
}
