package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.function.BiConsumer;

/**
 * Message sent when an external process needs to be executed.
 * <p>
 * Port of charmbracelet/bubbletea exec.go execMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 */
@SuppressWarnings("deprecation")
public class ExecProcessMessage extends ExecProcessMsg implements MessageShim {

    private final Process processRef;
    private final BiConsumer<Integer, byte[]> outputHandlerRef;
    private final BiConsumer<Integer, byte[]> errorHandlerRef;

    /**
     * Creates a new exec process message.
     *
     * @param process the process to execute
     * @param outputHandler handler for stdout (receives line number and bytes)
     * @param errorHandler handler for stderr (receives line number and bytes)
     */
    public ExecProcessMessage(Process process, BiConsumer<Integer, byte[]> outputHandler, BiConsumer<Integer, byte[]> errorHandler) {
        super(process, outputHandler, errorHandler);
        this.processRef = process;
        this.outputHandlerRef = outputHandler;
        this.errorHandlerRef = errorHandler;
    }

    /**
     * Returns the process to execute.
     *
     * @return the process
     */
    @Override
    public Process process() {
        return processRef;
    }

    /**
     * Returns the stdout handler.
     *
     * @return the output handler
     */
    @Override
    public BiConsumer<Integer, byte[]> outputHandler() {
        return outputHandlerRef;
    }

    /**
     * Returns the stderr handler.
     *
     * @return the error handler
     */
    @Override
    public BiConsumer<Integer, byte[]> errorHandler() {
        return errorHandlerRef;
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
