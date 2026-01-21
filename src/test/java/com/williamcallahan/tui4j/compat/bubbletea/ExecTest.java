package com.williamcallahan.tui4j.compat.bubbletea;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/exec_test.go.
 */
class ExecTest {

    @Test
    void testExecProcess() throws IOException {
        runExecCase("true", false);
        runExecCase("false", true);
    }

    private void runExecCase(String command, boolean expectError) throws IOException {
        Process process = new ProcessBuilder(command).start();
        TestExecModel model = new TestExecModel(process);
        Program program = new Program(model,
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(new ByteArrayOutputStream()));

        program.run();

        if (expectError) {
            assertThat(model.error).isNotNull();
        } else {
            assertThat(model.error).isNull();
        }
    }

    private static final class TestExecModel implements Model {
        private final Process process;
        private Throwable error;

        private TestExecModel(Process process) {
            this.process = process;
        }

        @Override
        public Command init() {
            return Command.execProcess(process);
        }

        @Override
        public UpdateResult<TestExecModel> update(Message msg) {
            if (msg instanceof ExecCompletedMessage completed) {
                if (!completed.success()) {
                    Throwable err = completed.error();
                    if (err == null) {
                        err = new IllegalStateException(completed.errorMessage());
                    }
                    this.error = err;
                }
                return UpdateResult.from(this, Command.quit());
            }
            return UpdateResult.from(this);
        }

        @Override
        public String view() {
            return "\n";
        }
    }
}
