package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.input.NoopInputHandler;
import com.williamcallahan.tui4j.compat.bubbletea.render.NilRenderer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/screen_test.go.
 */
class ScreenTest {

    @Test
    void testProgramHandlesScreenMessages() throws Exception {
        ScreenModel model = new ScreenModel();
        Program program = new Program(model,
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        SpyRenderer renderer = new SpyRenderer();
        setField(program, "renderer", renderer);
        setField(program, "inputHandler", new NoopInputHandler());

        program.run();

        assertThat(renderer.clearScreenCalled).isTrue();
        assertThat(renderer.enterAltScreenCalled).isTrue();
        assertThat(renderer.exitAltScreenCalled).isTrue();
        assertThat(renderer.enableMouseCellMotionCalled).isTrue();
        assertThat(renderer.enableMouseAllMotionCalled).isTrue();
        assertThat(renderer.disableMouseCalled).isTrue();
    }

    private static void setField(Program program, String name, Object value) throws Exception {
        Field field = Program.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(program, value);
    }

    private static final class ScreenModel implements Model {
        @Override
        public Command init() {
            return Command.sequence(
                    () -> new ClearScreenMessage(),
                    () -> new EnterAltScreenMessage(),
                    () -> new ExitAltScreenMessage(),
                    () -> new EnableMouseCellMotionMessage(),
                    () -> new EnableMouseAllMotionMessage(),
                    () -> new DisableMouseMessage(),
                    Command.quit()
            );
        }

        @Override
        public UpdateResult<ScreenModel> update(Message msg) {
            return UpdateResult.from(this);
        }

        @Override
        public String view() {
            return "success";
        }
    }

    private static final class SpyRenderer extends NilRenderer {
        private boolean clearScreenCalled;
        private boolean enterAltScreenCalled;
        private boolean exitAltScreenCalled;
        private boolean enableMouseCellMotionCalled;
        private boolean enableMouseAllMotionCalled;
        private boolean disableMouseCalled;

        @Override
        public void clearScreen() {
            clearScreenCalled = true;
        }

        @Override
        public void enterAltScreen() {
            enterAltScreenCalled = true;
        }

        @Override
        public void exitAltScreen() {
            exitAltScreenCalled = true;
        }

        @Override
        public void handleMessage(Message msg) {
            Message internal = msg instanceof MessageShim shim ? shim.toMessage() : msg;
            if (internal instanceof EnableMouseCellMotionMsg) {
                enableMouseCellMotionCalled = true;
            } else if (internal instanceof EnableMouseAllMotionMsg) {
                enableMouseAllMotionCalled = true;
            } else if (internal instanceof DisableMouseMsg) {
                disableMouseCalled = true;
            }
        }
    }
}
