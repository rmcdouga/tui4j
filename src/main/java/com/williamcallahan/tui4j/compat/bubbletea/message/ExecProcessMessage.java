package com.williamcallahan.tui4j.compat.bubbletea.message;

import java.util.function.BiConsumer;

public class ExecProcessMessage extends com.williamcallahan.tui4j.compat.bubbletea.ExecProcessMessage {

    public ExecProcessMessage(Process process, BiConsumer<Integer, byte[]> outputHandler, BiConsumer<Integer, byte[]> errorHandler) {
        super(process, outputHandler, errorHandler);
    }
}
