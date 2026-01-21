package com.williamcallahan.tui4j.compat.bubbletea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/logging_test.go.
 */
class LoggingTest {

    @TempDir
    Path tempDir;

    @Test
    void testLogToFile() throws Exception {
        Path path = tempDir.resolve("log.txt");
        String prefix = "logprefix";

        FileOutputStream stream = Logging.logToFile(path.toString(), prefix);
        Logger logger = Logger.getLogger(Logging.class.getName());
        logger.setLevel(Level.INFO);
        logger.log(Level.INFO, "some test log");

        for (Handler handler : logger.getHandlers()) {
            handler.flush();
        }

        stream.close();

        String out = Files.readString(path);
        assertThat(out).isEqualTo(prefix + " some test log" + System.lineSeparator());
    }
}
