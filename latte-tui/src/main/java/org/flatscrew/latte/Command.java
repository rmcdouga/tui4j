package org.flatscrew.latte;

import org.flatscrew.latte.message.BatchMessage;
import org.flatscrew.latte.message.CheckWindowSizeMessage;
import org.flatscrew.latte.message.ClearScreenMessage;
import org.flatscrew.latte.message.CopyToClipboardMessage;
import org.flatscrew.latte.message.DisableMouseMessage;
import org.flatscrew.latte.message.EnableMouseAllMotionMessage;
import org.flatscrew.latte.message.EnableMouseCellMotionMessage;
import org.flatscrew.latte.message.OpenUrlMessage;
import org.flatscrew.latte.message.PrintLineMessage;
import org.flatscrew.latte.message.QuitMessage;
import org.flatscrew.latte.message.ResetMouseCursorMessage;
import org.flatscrew.latte.message.SequenceMessage;
import org.flatscrew.latte.message.SetMouseCursorPointerMessage;
import org.flatscrew.latte.message.SetMouseCursorTextMessage;
import org.flatscrew.latte.message.SetWindowTitleMessage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Command {

    Message execute();

    static Command batch(Collection<Command> commands) {
        return () -> new BatchMessage(commands.toArray(new Command[0]));
    }

    static Command batch(Command... commands) {
        return () -> new BatchMessage(commands);
    }

    static Command sequence(Command... commands) {
        return () -> new SequenceMessage(commands);
    }

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

    static Command println(Object... arguments) {
        return () -> new PrintLineMessage(Arrays.stream(arguments)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    static Command printf(String template, Object... arguments) {
        return () -> new PrintLineMessage(template.formatted(arguments));
    }

    static Command setWidowTitle(String title) {
        return () -> new SetWindowTitleMessage(title);
    }

    static Command clearScreen() {
        return ClearScreenMessage::new;
    }

    static Command checkWindowSize() {
        return CheckWindowSizeMessage::new;
    }

    static Command quit() {
        return QuitMessage::new;
    }

    static Command setMouseCursorText() {
        return SetMouseCursorTextMessage::new;
    }

    static Command setMouseCursorPointer() {
        return SetMouseCursorPointerMessage::new;
    }

    static Command resetMouseCursor() {
        return ResetMouseCursorMessage::new;
    }

    static Command enableMouseCellMotion() {
        return EnableMouseCellMotionMessage::new;
    }

    static Command enableMouseAllMotion() {
        return EnableMouseAllMotionMessage::new;
    }

    static Command disableMouse() {
        return DisableMouseMessage::new;
    }

    static Command copyToClipboard(String text) {
        return () -> new CopyToClipboardMessage(text);
    }

    static Command openUrl(String url) {
        return () -> new OpenUrlMessage(url);
    }
}
