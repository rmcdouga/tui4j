package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.render.NilRenderer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/options_test.go.
 */
class ProgramOptionsTest {

    @Test
    void testOutputOption() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Program program = new Program(null, ProgramOption.withOutput(output),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])));

        assertThat(getField(program, "output", ByteArrayOutputStream.class)).isSameAs(output);
    }

    @Test
    void testCustomInputOption() {
        ByteArrayInputStream input = new ByteArrayInputStream(new byte[0]);
        Program program = new Program(null, ProgramOption.withInput(input),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        assertThat(getField(program, "input", ByteArrayInputStream.class)).isSameAs(input);
        assertThat(getBoolean(program, "inputDisabled")).isFalse();
    }

    @Test
    void testRendererOption() {
        Program program = new Program(null,
                ProgramOption.withoutRenderer(),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        Object renderer = getField(program, "renderer", Object.class);
        assertThat(renderer).isInstanceOf(NilRenderer.class);
    }

    @Test
    void testWithoutSignalsOption() {
        Program program = new Program(null,
                ProgramOption.withoutSignals(),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        AtomicBoolean ignoreSignals = getField(program, "ignoreSignals", AtomicBoolean.class);
        assertThat(ignoreSignals.get()).isTrue();
    }

    @Test
    void testFilterOption() {
        BiFunction<Model, Message, Message> filter = (model, msg) -> msg;
        Program program = new Program(null,
                ProgramOption.withFilter(filter),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        assertThat(getField(program, "filter", BiFunction.class)).isSameAs(filter);
    }

    @Test
    void testContextOption() {
        CompletableFuture<?> cancelSignal = new CompletableFuture<>();
        Program program = new Program(null,
                ProgramOption.withContext(cancelSignal),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        CompletableFuture<?> actualCancelSignal = getField(program, "cancelSignal", CompletableFuture.class);
        assertThat(actualCancelSignal).isSameAs(cancelSignal);
    }

    @Test
    void testInputOptions() {
        Program program = new Program(null,
                ProgramOption.withInputTTY(),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        assertThat(getBoolean(program, "useInputTTY")).isTrue();
    }

    @Test
    void testStartupOptions() {
        Program program = new Program(null,
                ProgramOption.withAltScreen(),
                ProgramOption.withoutBracketedPaste(),
                ProgramOption.withoutCatchPanics(),
                ProgramOption.withoutSignalHandler(),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        assertThat(getBoolean(program, "enableAltScreen")).isTrue();
        assertThat(getBoolean(program, "withoutBracketedPaste")).isTrue();
        assertThat(getBoolean(program, "withoutCatchPanics")).isTrue();
        assertThat(getBoolean(program, "withoutSignalHandler")).isTrue();
    }

    @Test
    void testMouseOptionsOverride() {
        Program cellMotion = new Program(null,
                ProgramOption.withMouseAllMotion(),
                ProgramOption.withMouseCellMotion(),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        assertThat(getBoolean(cellMotion, "enableMouseCellMotion")).isTrue();
        assertThat(getBoolean(cellMotion, "enableMouseAllMotion")).isFalse();

        Program allMotion = new Program(null,
                ProgramOption.withMouseCellMotion(),
                ProgramOption.withMouseAllMotion(),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        assertThat(getBoolean(allMotion, "enableMouseAllMotion")).isTrue();
        assertThat(getBoolean(allMotion, "enableMouseCellMotion")).isFalse();
    }

    private static <T> T getField(Program program, String name, Class<T> type) {
        try {
            Field field = Program.class.getDeclaredField(name);
            field.setAccessible(true);
            return type.cast(field.get(program));
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Failed to read field: " + name, e);
        }
    }

    private static boolean getBoolean(Program program, String name) {
        return getField(program, name, Boolean.class);
    }
}
