package com.williamcallahan.tui4j.compat.bubbletea;

import java.io.IOException;
import java.io.InputStream;
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
public class ExecProcessMsg implements Message {

    private final Process process;
    private final BiConsumer<Integer, byte[]> outputHandler;
    private final BiConsumer<Integer, byte[]> errorHandler;

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
        this.process = process;
        this.outputHandler = outputHandler;
        this.errorHandler = errorHandler;
    }

    /**
     * Returns the process to execute.
     *
     * @return the process
     * @deprecated Use {@link ExecProcessMessage#process()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Process process() {
        return process;
    }

    /**
     * Returns the stdout handler.
     *
     * @return the output handler
     * @deprecated Use {@link ExecProcessMessage#outputHandler()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public BiConsumer<Integer, byte[]> outputHandler() {
        return outputHandler;
    }

    /**
     * Returns the stderr handler.
     *
     * @return the error handler
     * @deprecated Use {@link ExecProcessMessage#errorHandler()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public BiConsumer<Integer, byte[]> errorHandler() {
        return errorHandler;
    }

    /**
     * Reads all bytes from an input stream.
     *
     * @param inputStream the stream to read
     * @return the bytes read
     * @throws IOException if reading fails
     * @deprecated Use {@link ExecProcessMessage#readStream(InputStream)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static byte[] readStream(InputStream inputStream) throws IOException {
        return inputStream.readAllBytes();
    }
}

