package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.function.BiConsumer;

/**
 * Message sent when an external process needs to be executed.
 * <p>
 * Port of charmbracelet/bubbletea exec.go execMsg type.
 *
 * @deprecated Use {@link ExecProcessMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ExecProcessMsg extends ExecProcessMessage {

    /**
     * Creates a new exec process message.
     *
     * @param process the process to execute
     * @param outputHandler handler for stdout (receives line number and bytes)
     * @param errorHandler handler for stderr (receives line number and bytes)
     * @deprecated Use {@link ExecProcessMessage#ExecProcessMessage(Process, BiConsumer, BiConsumer)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public ExecProcessMsg(Process process, BiConsumer<Integer, byte[]> outputHandler, BiConsumer<Integer, byte[]> errorHandler) {
        super(process, outputHandler, errorHandler);
    }
}
