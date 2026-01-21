package com.williamcallahan.tui4j.compat.bubbletea;
import com.williamcallahan.tui4j.message.OpenUrlMessage;
import com.williamcallahan.tui4j.message.CopyToClipboardMessage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents a command that yields a Message.
 * <p>
 * Port of github.com/charmbracelet/bubbletea/commands.go.
 */
public interface Command {

    /**
     * Executes the command and returns a message.
     *
     * @return message to deliver
     */
    Message execute();

    /**
     * Batches commands into a single message.
     *
     * @param commands commands to batch
     * @return batch command
     */
    static Command batch(Collection<Command> commands) {
        Command[] filteredCommands = commands.stream()
                .filter(Objects::nonNull)
                .toArray(Command[]::new);
        return () -> new BatchMessage(filteredCommands);
    }

    /**
     * Batches commands into a single message.
     *
     * @param commands commands to batch
     * @return batch command
     */
    static Command batch(Command... commands) {
        Command[] filteredCommands = Arrays.stream(commands)
                .filter(Objects::nonNull)
                .toArray(Command[]::new);
        return () -> new BatchMessage(filteredCommands);
    }

    /**
     * Runs commands sequentially.
     *
     * @param commands commands to run
     * @return sequence command
     */
    static Command sequence(Command... commands) {
        return () -> new SequenceMessage(commands);
    }

    /**
     * Runs commands in order and returns the first non-null message.
     *
     * @param commands commands to execute
     * @return sequential command
     * @deprecated Deprecated in upstream Bubble Tea. Use {@link #sequence(Command...)} instead.
     *             This method will not be removed for API compatibility, but new code should
     *             use {@code sequence()} which properly returns messages from each command.
     * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/commands.go">bubbletea/commands.go</a>
     */
    @Deprecated(since = "0.3.0")
    static Command sequentially(Command... commands) {
        return () -> {
            if (commands == null) {
                return null;
            }
            for (Command command : commands) {
                if (command == null) {
                    continue;
                }
                Message message = command.execute();
                if (message != null) {
                    return message;
                }
            }
            return null;
        };
    }

    /**
     * Emits a message after a duration.
     *
     * @param duration delay duration
     * @param fn       function to map time to message
     * @return tick command
     */
    static Command tick(Duration duration, Function<LocalDateTime, Message> fn) {
        return () -> {
            BlockingQueue<LocalDateTime> queue = new ArrayBlockingQueue<>(1);
            Timer timer = new Timer(true);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    queue.offer(LocalDateTime.now());
                }
            }, duration.toMillis());

            try {
                LocalDateTime time = queue.take();
                timer.cancel();
                return fn.apply(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    /**
     * Emits a message aligned to the system clock.
     *
     * @param duration tick duration
     * @param fn function to map time to message
     * @return every command
     */
    static Command every(Duration duration, Function<LocalDateTime, Message> fn) {
        return () -> {
            long millis = duration.toMillis();
            if (millis <= 0) {
                return fn.apply(LocalDateTime.now());
            }

            long now = System.currentTimeMillis();
            long next = ((now / millis) + 1) * millis;
            long delay = Math.max(0, next - now);

            BlockingQueue<LocalDateTime> queue = new ArrayBlockingQueue<>(1);
            Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    queue.offer(LocalDateTime.now());
                }
            }, delay);

            try {
                LocalDateTime time = queue.take();
                timer.cancel();
                return fn.apply(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    /**
     * Emits a line with the provided arguments.
     *
     * @param arguments values to join with spaces
     * @return print line command
     */
    static Command println(Object... arguments) {
        return () -> new PrintLineMessage(Arrays.stream(arguments)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    /**
     * Emits a formatted line.
     *
     * @param template  format string
     * @param arguments format arguments
     * @return print line command
     */
    static Command printf(String template, Object... arguments) {
        return () -> new PrintLineMessage(template.formatted(arguments));
    }

    /**
     * Sets the terminal window title.
     *
     * @param title the title to set
     * @return the command
     */
    static Command setWindowTitle(String title) {
        return () -> new SetWindowTitleMessage(title);
    }

    /**
     * @deprecated Use {@link #setWindowTitle(String)} instead (typo fix).
     *
     * @param title the title to set
     * @return the command
     */
    @Deprecated(forRemoval = true)
    static Command setWidowTitle(String title) {
        return setWindowTitle(title);
    }

    /**
     * Clears the terminal screen.
     *
     * @return clear screen command
     */
    static Command clearScreen() {
        return ClearScreenMessage::new;
    }

    /**
     * Requests a window size check.
     *
     * @return check window size command
     */
    static Command checkWindowSize() {
        return CheckWindowSizeMessage::new;
    }

    /**
     * Quits the program.
     *
     * @return quit command
     */
    static Command quit() {
        return QuitMessage::new;
    }

    /**
     * Sets the mouse cursor to text mode.
     *
     * @return set cursor text command
     */
    static Command setMouseCursorText() {
        return SetMouseCursorTextMessage::new;
    }

    /**
     * Sets the mouse cursor to pointer mode.
     *
     * @return set cursor pointer command
     */
    static Command setMouseCursorPointer() {
        return SetMouseCursorPointerMessage::new;
    }

    /**
     * Resets the mouse cursor to the default.
     *
     * @return reset cursor command
     */
    static Command resetMouseCursor() {
        return ResetMouseCursorMessage::new;
    }

    /**
     * Enables mouse cell motion reporting.
     *
     * @return enable mouse cell motion command
     */
    static Command enableMouseCellMotion() {
        return EnableMouseCellMotionMessage::new;
    }

    /**
     * Enables mouse all-motion reporting.
     *
     * @return enable mouse all motion command
     */
    static Command enableMouseAllMotion() {
        return EnableMouseAllMotionMessage::new;
    }

    /**
     * Disables mouse reporting.
     *
     * @return disable mouse command
     */
    static Command disableMouse() {
        return DisableMouseMessage::new;
    }

    /**
     * Copies text to the clipboard.
     *
     * @param text text to copy
     * @return clipboard command
     */
    static Command copyToClipboard(String text) {
        return () -> new CopyToClipboardMessage(text);
    }

    /**
     * Requests clipboard contents from the terminal.
     * The clipboard contents are delivered as a {@link PasteMessage}.
     * <p>
     * Bubble Tea: bubbletea/commands.go Paste
     *
     * @return paste command
     */
    static Command paste() {
        return ReadClipboardMessage::new;
    }

    /**
     * Enables bracketed paste mode in the terminal.
     * <p>
     * Bubble Tea: bubbletea/commands.go EnableBracketedPaste
     *
     * @return enable bracketed paste command
     */
    static Command enableBracketedPaste() {
        return EnableBracketedPasteMessage::new;
    }

    /**
     * Disables bracketed paste mode in the terminal.
     * <p>
     * Bubble Tea: bubbletea/commands.go DisableBracketedPaste
     *
     * @return disable bracketed paste command
     */
    static Command disableBracketedPaste() {
        return DisableBracketedPasteMessage::new;
    }

    /**
     * Opens a URL via the host OS.
     *
     * @param url URL to open
     * @return open URL command
     */
    static Command openUrl(String url) {
        return () -> new OpenUrlMessage(url);
    }

    /**
     * Executes a process with output handlers.
     *
     * @param process       process to execute
     * @param outputHandler output handler
     * @param errorHandler  error handler
     * @return exec command
     */
    static Command execProcess(Process process, BiConsumer<Integer, byte[]> outputHandler,
                               BiConsumer<Integer, byte[]> errorHandler) {
        return () -> new ExecProcessMessage(process, outputHandler, errorHandler);
    }

    /**
     * Executes a process without output handlers.
     *
     * @param process process to execute
     * @return exec command
     */
    static Command execProcess(Process process) {
        return () -> new ExecProcessMessage(process, null, null);
    }
}
