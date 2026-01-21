package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.function.BiConsumer;

/**
 * Message sent when an external process needs to be executed.
 * <p>
 * Port of charmbracelet/bubbletea exec.go execMsg type.
 * Preferred alias for {@link ExecProcessMsg}.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 */
public class ExecProcessMessage extends ExecProcessMsg implements MessageShim {

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

    @Override
    public Message toMessage() {
        return this;
    }
}
