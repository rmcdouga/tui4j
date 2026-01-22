package com.williamcallahan.tui4j.compat.bubbletea;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

/**
 * Functional interface for configuring Bubble Tea programs.
 * <p>
 * Provides options for setting input/output streams, terminal modes, and program behavior.
 * Modeled after Go Bubble Tea's functional option pattern.
 * <p>
 * Bubble Tea: options.go.
 */
public interface ProgramOption {
    /**
     * Handles apply for this component.
     *
     * @param program program
     */
    void apply(Program program);

    /**
     * Handles with context for this component.
     *
     * @param cancelSignal cancel signal
     * @return result
     */
    static ProgramOption withContext(CompletableFuture<?> cancelSignal) {
        return program -> program.setCancelSignal(cancelSignal);
    }

    /**
     * Handles with output for this component.
     *
     * @param output output
     * @return result
     */
    static ProgramOption withOutput(OutputStream output) {
        return program -> program.setOutput(output);
    }

    /**
     * Handles with input for this component.
     *
     * @param input input
     * @return result
     */
    static ProgramOption withInput(InputStream input) {
        return program -> program.setInput(input);
    }

    /**
     * Handles with input tty for this component.
     *
     * @return result
     */
    static ProgramOption withInputTTY() {
        return program -> program.setInputTTY(true);
    }

    /**
     * Handles with environment for this component.
     *
     * @param environment environment
     * @return result
     */
    static ProgramOption withEnvironment(List<String> environment) {
        return program -> program.setEnvironment(environment);
    }

    /**
     * Handles without signal handler for this component.
     *
     * @return result
     */
    static ProgramOption withoutSignalHandler() {
        return program -> program.setWithoutSignalHandler(true);
    }

    /**
     * Handles without catch panics for this component.
     *
     * @return result
     */
    static ProgramOption withoutCatchPanics() {
        return program -> program.setWithoutCatchPanics(true);
    }

    /**
     * Handles without signals for this component.
     *
     * @return result
     */
    static ProgramOption withoutSignals() {
        return program -> program.setIgnoreSignals(true);
    }

    /**
     * Handles with alt screen for this component.
     *
     * @return result
     */
    static ProgramOption withAltScreen() {
        return Program::withAltScreen;
    }

    /**
     * Handles without bracketed paste for this component.
     *
     * @return result
     */
    static ProgramOption withoutBracketedPaste() {
        return program -> program.setWithoutBracketedPaste(true);
    }

    /**
     * Handles with mouse cell motion for this component.
     *
     * @return result
     */
    static ProgramOption withMouseCellMotion() {
        return Program::withMouseCellMotion;
    }

    /**
     * Handles with mouse all motion for this component.
     *
     * @return result
     */
    static ProgramOption withMouseAllMotion() {
        return Program::withMouseAllMotion;
    }

    /**
     * Handles without renderer for this component.
     *
     * @return result
     */
    static ProgramOption withoutRenderer() {
        return program -> program.setWithoutRenderer(true);
    }

    /**
     * Removes redundant ANSI sequences to produce potentially smaller output.
     *
     * @return program option
     * @deprecated Deprecated in upstream Bubble Tea ({@code charmbracelet/bubbletea}).
     *             {@code WithANSICompressor} is deprecated due to performance overhead.
     *             Deprecated since v0.3.0 in tui4j; this option has no effect.
     * @see <a href="https://pkg.go.dev/github.com/charmbracelet/bubbletea#WithANSICompressor">
     *      bubbletea.WithANSICompressor (Go docs)</a>
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    static ProgramOption withAnsiCompressor() {
        return program -> program.setAnsiCompressorInternal(true);
    }

    /**
     * Handles with filter for this component.
     *
     * @param filter filter
     * @return result
     */
    static ProgramOption withFilter(
        BiFunction<Model, Message, Message> filter
    ) {
        return program -> program.setFilter(filter);
    }

    /**
     * Handles with fps for this component.
     *
     * @param fps fps
     * @return result
     */
    static ProgramOption withFps(int fps) {
        return program -> program.setFps(fps);
    }

    /**
     * Handles with report focus for this component.
     *
     * @return result
     */
    static ProgramOption withReportFocus() {
        return Program::withReportFocus;
    }
}
