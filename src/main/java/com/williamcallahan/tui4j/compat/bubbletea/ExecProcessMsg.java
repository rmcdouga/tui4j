package com.williamcallahan.tui4j.compat.bubbletea;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.BiConsumer;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link ExecProcessMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubble Tea: exec.go.
 */
@Deprecated(since = "0.3.0")
public class ExecProcessMsg extends ExecProcessMessage {

    /**
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility alias for legacy *Msg naming; use {@link ExecProcessMessage} instead.
     * This transitional shim is temporary and will be removed in an upcoming release.
     *
     * @param process process to execute
     * @param outputHandler handler for stdout bytes
     * @param errorHandler handler for stderr bytes
     */
    @Deprecated(since = "0.3.0")
    public ExecProcessMsg(
        Process process,
        BiConsumer<Integer, byte[]> outputHandler,
        BiConsumer<Integer, byte[]> errorHandler
    ) {
        super(process, outputHandler, errorHandler);
    }
}
