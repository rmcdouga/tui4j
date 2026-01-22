package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.function.BiConsumer;

/**
 * @deprecated Compatibility alias for legacy *Msg naming; use {@link ExecProcessMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: exec.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ExecProcessMsg extends ExecProcessMessage {

    /**
     * @deprecated Compatibility alias for legacy *Msg naming; use {@link ExecProcessMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param process process to execute
     * @param outputHandler handler for stdout bytes
     * @param errorHandler handler for stderr bytes
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ExecProcessMsg(
        Process process,
        BiConsumer<Integer, byte[]> outputHandler,
        BiConsumer<Integer, byte[]> errorHandler
    ) {
        super(process, outputHandler, errorHandler);
    }
}
