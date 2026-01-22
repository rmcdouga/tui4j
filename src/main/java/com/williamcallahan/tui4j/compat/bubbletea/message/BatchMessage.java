package com.williamcallahan.tui4j.compat.bubbletea.message;

import com.williamcallahan.tui4j.compat.bubbletea.Command;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.BatchMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: commands.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class BatchMessage extends com.williamcallahan.tui4j.compat.bubbletea.BatchMessage {

    /**
     * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.BatchMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param commands commands to batch
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public BatchMessage(Command... commands) {
        super(commands);
    }
}
