package com.williamcallahan.tui4j.compat.bubbletea;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public interface ProgramOption {
    void apply(Program program);

    static ProgramOption withContext(CompletableFuture<?> cancelSignal) {
        return program -> program.setCancelSignal(cancelSignal);
    }

    static ProgramOption withOutput(OutputStream output) {
        return program -> program.setOutput(output);
    }

    static ProgramOption withInput(InputStream input) {
        return program -> program.setInput(input);
    }

    static ProgramOption withInputTTY() {
        return program -> program.setInputTTY(true);
    }

    static ProgramOption withEnvironment(List<String> environment) {
        return program -> program.setEnvironment(environment);
    }

    static ProgramOption withoutSignalHandler() {
        return program -> program.setWithoutSignalHandler(true);
    }

    static ProgramOption withoutCatchPanics() {
        return program -> program.setWithoutCatchPanics(true);
    }

    static ProgramOption withoutSignals() {
        return program -> program.setIgnoreSignals(true);
    }

    static ProgramOption withAltScreen() {
        return Program::withAltScreen;
    }

    static ProgramOption withoutBracketedPaste() {
        return program -> program.setWithoutBracketedPaste(true);
    }

    static ProgramOption withMouseCellMotion() {
        return Program::withMouseCellMotion;
    }

    static ProgramOption withMouseAllMotion() {
        return Program::withMouseAllMotion;
    }

    static ProgramOption withoutRenderer() {
        return program -> program.setWithoutRenderer(true);
    }

    /**
     * Removes redundant ANSI sequences to produce potentially smaller output.
     *
     * @return program option
     * @deprecated This incurs a noticeable performance hit. A future release will
     *             optimize ANSI automatically without the performance penalty.
     *             This option is accepted for API compatibility but has no effect.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @SuppressWarnings("removal")
    static ProgramOption withAnsiCompressor() {
        return program -> program.setAnsiCompressor(true);
    }

    static ProgramOption withFilter(BiFunction<Model, Message, Message> filter) {
        return program -> program.setFilter(filter);
    }

    static ProgramOption withFps(int fps) {
        return program -> program.setFps(fps);
    }

    static ProgramOption withReportFocus() {
        return Program::withReportFocus;
    }
}
