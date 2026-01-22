package com.williamcallahan.tui4j.compat.bubbletea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Objects;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * Logging helpers for Bubble Tea compatibility.
 * Bubble Tea: bubbletea/logging.go
 */
public final class Logging {

    /**
     * Creates Logging to keep this component ready for use.
     */
    private Logging() {
    }

    /**
     * Port of Bubble Tea LogOptionsSetter.
     */
    public interface LogOptionsSetter {

        /**
         * Sets the output stream.
         *
         * @param output the output stream
         */
        void setOutput(OutputStream output);

        /**
         * Sets the prefix for log messages.
         *
         * @param prefix the prefix
         */
        void setPrefix(String prefix);
    }

    /**
     * Sets up default logging to log to a file, using a standard logger adapter.
     *
     * @param path   path to the log file
     * @param prefix prefix to apply
     * @return file output stream for closing by caller
     * @throws IOException when the file cannot be opened
     */
    public static FileOutputStream logToFile(String path, String prefix) throws IOException {
        return logToFileWith(path, prefix, new LoggerAdapter(Logger.getLogger(Logging.class.getName())));
    }

    /**
     * Sets up logging to log to a file using a custom logger adapter.
     *
     * @param path   path to the log file
     * @param prefix prefix to apply
     * @param log    logger adapter
     * @return file output stream for closing by caller
     * @throws IOException when the file cannot be opened
     */
    public static FileOutputStream logToFileWith(String path, String prefix, LogOptionsSetter log) throws IOException {
        FileOutputStream file = new FileOutputStream(Path.of(path).toFile(), true);
        try {
            log.setOutput(file);
            if (prefix != null && !prefix.isEmpty()) {
                char last = prefix.charAt(prefix.length() - 1);
                if (!Character.isWhitespace(last)) {
                    prefix = prefix + " ";
                }
            }
            log.setPrefix(prefix == null ? "" : prefix);
            return file;
        } catch (RuntimeException | Error e) {
            file.close();
            throw e;
        }
    }

    /**
     * Compatibility helper for LoggerAdapter to keep API parity.
     */
    private static final class LoggerAdapter implements LogOptionsSetter {
        private final Logger logger;
        private Handler handler;
        private String prefix = "";

        /**
         * Creates LoggerAdapter to keep this component ready for use.
         *
         * @param logger logger
         */
        private LoggerAdapter(Logger logger) {
            this.logger = Objects.requireNonNull(logger, "logger");
        }

        /**
         * Updates the output.
         *
         * @param output output
         */
        @Override
        public synchronized void setOutput(OutputStream output) {
            if (handler != null) {
                logger.removeHandler(handler); handler.close();
            }
            StreamHandler streamHandler = new FlushingStreamHandler(output, new PrefixedFormatter(prefix));
            streamHandler.setLevel(Level.ALL); logger.setLevel(Level.ALL);
            logger.addHandler(streamHandler);
            logger.setUseParentHandlers(false);
            handler = streamHandler;
        }

        /**
         * Updates the prefix.
         *
         * @param prefix prefix
         */
        @Override
        public synchronized void setPrefix(String prefix) {
            this.prefix = prefix == null ? "" : prefix;
            if (handler != null) {
                handler.setFormatter(new PrefixedFormatter(this.prefix));
            }
        }
    }

    /**
     * Compatibility helper for PrefixedFormatter to keep API parity.
     */
    private static final class PrefixedFormatter extends Formatter {
        private final String prefix;

        /**
         * Creates PrefixedFormatter to keep this component ready for use.
         *
         * @param prefix prefix
         */
        private PrefixedFormatter(String prefix) {
            this.prefix = prefix == null ? "" : prefix;
        }

        /**
         * Handles format for this component.
         *
         * @param record record
         * @return result
         */
        @Override
        public String format(LogRecord record) {
            return prefix + record.getMessage() + System.lineSeparator();
        }
    }

    /**
     * Stream handler that flushes on every published record.
     */
    private static final class FlushingStreamHandler extends StreamHandler {
        /**
         * Creates a handler that flushes after each message.
         *
         * @param output output stream for log records
         * @param formatter formatter for log records
         */
        private FlushingStreamHandler(OutputStream output, Formatter formatter) {
            super(output, formatter);
        }

        /**
         * Publishes the record and flushes the stream immediately.
         *
         * @param record log record to publish
         */
        @Override
        public synchronized void publish(LogRecord record) {
            super.publish(record);
            flush();
        }
    }
}
