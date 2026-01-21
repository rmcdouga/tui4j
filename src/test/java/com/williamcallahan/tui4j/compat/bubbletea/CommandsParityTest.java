package com.williamcallahan.tui4j.compat.bubbletea;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/commands_test.go.
 */
class CommandsParityTest {

    @Test
    void testEvery() {
        Message msg = Command.every(Duration.ofMillis(1), time -> new TestMessage("every"))
                .execute();

        assertThat(msg).isInstanceOf(TestMessage.class);
        assertThat(((TestMessage) msg).value()).isEqualTo("every");
    }

    @Test
    void testTick() {
        Message msg = Command.tick(Duration.ofMillis(1), time -> new TestMessage("tick"))
                .execute();

        assertThat(msg).isInstanceOf(TestMessage.class);
        assertThat(((TestMessage) msg).value()).isEqualTo("tick");
    }

    @Test
    void testBatchFiltersNulls() {
        Command[] commands = new Command[]{null, Command.quit(), null};
        Command batch = Command.batch(commands);

        Message msg = batch.execute();
        assertThat(msg).isInstanceOf(BatchMessage.class);
        assertThat(((BatchMessage) msg).commands()).hasSize(1);
    }

    @Test
    void testSequenceWrapsCommands() {
        Command sequence = Command.sequence(Command.quit());
        Message msg = sequence.execute();

        assertThat(msg).isInstanceOf(SequenceMessage.class);
        assertThat(((SequenceMessage) msg).commands()).hasSize(1);
    }

    private record TestMessage(String value) implements Message {
    }
}
