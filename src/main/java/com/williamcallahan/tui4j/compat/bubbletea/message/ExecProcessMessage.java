package com.williamcallahan.tui4j.compat.bubbletea.message;

import java.util.function.BiConsumer;

/**
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.ExecProcessMessage} for package convenience.
 * <p>
 * Port of charmbracelet/bubbletea exec.go execMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbletea.ExecProcessMessage} instead.
 * Bubble Tea: exec.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ExecProcessMessage extends com.williamcallahan.tui4j.compat.bubbletea.ExecProcessMessage {

    /**
     * Creates a new exec process message.
     *
     * @param process the process to execute
     * @param outputHandler handler for stdout (receives line number and bytes)
     * @param errorHandler handler for stderr (receives line number and bytes)
     */
    public ExecProcessMessage(Process process, BiConsumer<Integer, byte[]> outputHandler, BiConsumer<Integer, byte[]> errorHandler) {
        super(process, outputHandler, errorHandler);
    }
}
