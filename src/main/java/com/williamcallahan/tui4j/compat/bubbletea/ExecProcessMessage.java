package com.williamcallahan.tui4j.compat.bubbletea;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.BiConsumer;

/**
 * Message sent when an external process needs to be executed.
 * <p>
 * Port of charmbracelet/bubbletea exec.go execMsg type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/exec.go">bubbletea/exec.go</a>
 */
public class ExecProcessMessage implements Message {

    private final Process process;
    private final BiConsumer<Integer, byte[]> outputHandler;
    private final BiConsumer<Integer, byte[]> errorHandler;

    /**
     * Creates a new exec process message.
     *
     * @param process the process to execute
     * @param outputHandler handler for stdout (receives line number and bytes)
     * @param errorHandler handler for stderr (receives line number and bytes)
     */
    public ExecProcessMessage(Process process, BiConsumer<Integer, byte[]> outputHandler, BiConsumer<Integer, byte[]> errorHandler) {
        this.process = process;
        this.outputHandler = outputHandler;
        this.errorHandler = errorHandler;
    }

    /**
     * Returns the process to execute.
     *
     * @return the process
     */
    public Process process() {
        return process;
    }

    /**
     * Returns the stdout handler.
     *
     * @return the output handler
     */
    public BiConsumer<Integer, byte[]> outputHandler() {
        return outputHandler;
    }

    /**
     * Returns the stderr handler.
     *
     * @return the error handler
     */
    public BiConsumer<Integer, byte[]> errorHandler() {
        return errorHandler;
    }

    /**
     * Reads all bytes from an input stream.
     *
     * @param inputStream the stream to read
     * @return the bytes read
     * @throws IOException if reading fails
     */
    public static byte[] readStream(InputStream inputStream) throws IOException {
        return inputStream.readAllBytes();
    }
}
