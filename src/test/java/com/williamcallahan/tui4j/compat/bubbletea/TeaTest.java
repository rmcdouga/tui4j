package com.williamcallahan.tui4j.compat.bubbletea;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/tea_test.go.
 */
class TeaTest {

    @Test
    void testProgramRunWritesOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Program program = new Program(new SimpleModel(),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(output));

        program.run();

        assertThat(output.toString()).contains("success");
    }

    @Test
    void testProgramSendQuit() throws InterruptedException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Program program = new Program(new BlockingModel(),
                ProgramOption.withInput(new ByteArrayInputStream(new byte[0])),
                ProgramOption.withOutput(output));

        Thread thread = new Thread(program::run);
        thread.start();

        program.waitForInit();
        program.send(new QuitMessage());

        thread.join(2000);
        assertThat(thread.isAlive()).isFalse();
    }

    private static final class SimpleModel implements Model {
        @Override
        public Command init() {
            return Command.quit();
        }

        @Override
        public UpdateResult<SimpleModel> update(Message msg) {
            return UpdateResult.from(this);
        }

        @Override
        public String view() {
            return "success\n";
        }
    }

    private static final class BlockingModel implements Model {
        @Override
        public Command init() {
            return null;
        }

        @Override
        public UpdateResult<BlockingModel> update(Message msg) {
            return UpdateResult.from(this);
        }

        @Override
        public String view() {
            return "success\n";
        }
    }
}
