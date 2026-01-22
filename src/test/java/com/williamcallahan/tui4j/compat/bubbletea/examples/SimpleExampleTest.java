package com.williamcallahan.tui4j.compat.bubbletea.examples;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.QuitMessage;
import com.williamcallahan.tui4j.compat.bubbletea.SuspendMessage;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.Key;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.KeyAliases;
import com.williamcallahan.tui4j.compat.bubbletea.input.key.KeyAliases.KeyAlias;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Port of bubbletea/examples/simple/main_test.go.
 */
class SimpleExampleTest {

    /**
     * Verifies countdown messages update the view output.
     */
    @Test
    void testCountdownUpdatesView() {
        SimpleModel model = new SimpleModel(10);
        UpdateResult<? extends Model> result = model.update(new TickMessage(LocalDateTime.now()));
        SimpleModel updated = (SimpleModel) result.model();

        assertTrue(updated.view().contains("This program will exit in 9 seconds"));
    }

    /**
     * Verifies ctrl+c triggers a quit message.
     */
    @Test
    void testQuitOnCtrlC() {
        SimpleModel model = new SimpleModel(10);
        KeyPressMessage ctrlC = new KeyPressMessage(new Key(KeyAliases.getKeyType(KeyAlias.KeyCtrlC)));
        UpdateResult<? extends Model> result = model.update(ctrlC);

        assertInstanceOf(QuitMessage.class, result.command().execute());
    }

    /**
     * Verifies ctrl+z triggers a suspend message.
     */
    @Test
    void testSuspendOnCtrlZ() {
        SimpleModel model = new SimpleModel(10);
        KeyPressMessage ctrlZ = new KeyPressMessage(new Key(KeyAliases.getKeyType(KeyAlias.KeyCtrlZ)));
        UpdateResult<? extends Model> result = model.update(ctrlZ);

        assertInstanceOf(SuspendMessage.class, result.command().execute());
    }

    /**
     * Simple countdown model for testing.
     */
    private static final class SimpleModel implements Model {
        private final int seconds;

        /**
         * Creates the test model.
         *
         * @param seconds seconds remaining
         */
        private SimpleModel(int seconds) {
            this.seconds = seconds;
        }

        /**
         * Starts the timer tick.
         *
         * @return initial command
         */
        @Override
        public Command init() {
            return () -> new TickMessage(LocalDateTime.now());
        }

        /**
         * Updates the countdown and handles quit or suspend keys.
         *
         * @param msg incoming message
         * @return next model state and command
         */
        @Override
        public UpdateResult<? extends Model> update(Message msg) {
            if (msg instanceof KeyPressMessage keyPressMessage) {
                String key = keyPressMessage.key();
                if ("ctrl+c".equals(key) || "q".equals(key)) {
                    return UpdateResult.from(this, QuitMessage::new);
                }
                if ("ctrl+z".equals(key)) {
                    return UpdateResult.from(this, SuspendMessage::new);
                }
            }

            if (msg instanceof TickMessage) {
                int next = seconds - 1;
                if (next <= 0) {
                    return UpdateResult.from(new SimpleModel(next), QuitMessage::new);
                }
                return UpdateResult.from(new SimpleModel(next), this::tick);
            }
            return UpdateResult.from(this);
        }

        /**
         * Renders the view string for the countdown.
         *
         * @return view text
         */
        @Override
        public String view() {
            return String.format(
                "Hi. This program will exit in %d seconds.%n%nTo quit sooner press ctrl-c, or press ctrl-z to suspend...%n",
                seconds
            );
        }

        /**
         * Produces the next tick message.
         *
         * @return tick message
         */
        private Message tick() {
            return new TickMessage(LocalDateTime.now());
        }
    }

    /**
     * Tick message for countdown updates.
     *
     * @param time tick time
     */
    private record TickMessage(LocalDateTime time) implements Message {
    }
}
