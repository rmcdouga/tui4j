package com.williamcallahan.tui4j.compat.bubbletea;

import java.util.function.BiConsumer;

/**
 * Compatibility shim for {@link ExecProcessMsg}.
 */
public class ExecProcessMessage extends ExecProcessMsg implements MessageShim {

    public ExecProcessMessage(Process process, BiConsumer<Integer, byte[]> outputHandler, BiConsumer<Integer, byte[]> errorHandler) {
        super(process, outputHandler, errorHandler);
    }

    @Override
    public Message toMessage() {
        return this;
    }
}
