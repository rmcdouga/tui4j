package com.williamcallahan.tui4j.examples.debounce;

import com.williamcallahan.tui4j.compat.bubbles.spinner.Spinner;
import com.williamcallahan.tui4j.compat.bubbles.spinner.SpinnerType;
import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.Program;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import java.time.Duration;

public class DebounceExample implements Model {

    private static final Duration DEBOUNCE_DURATION = Duration.ofSeconds(1);

    private int tag;
    private boolean quitting;
    private Spinner spinner;

    public DebounceExample() {
        this.tag = 0;
        this.quitting = false;
        this.spinner = new Spinner(SpinnerType.DOTS);
        this.spinner.setStyle(
            com.williamcallahan.tui4j.compat.lipgloss.Style.newStyle().foregroundColor(
                240
            )
        );
    }

    @Override
    public Command init() {
        return Command.none();
    }

    @Override
    public UpdateResult<? extends Model> update(Message msg) {
        if (msg instanceof KeyPressMessage keyPressMessage) {
            tag++;
            return UpdateResult.from(
                this,
                Command.batch(
                    Command.tick(DEBOUNCE_DURATION, __ -> new ExitMessage(tag)),
                    Command.ofMsg(spinner::tick)
                )
            );
        }

        if (msg instanceof ExitMessage exitMessage) {
            if (exitMessage.tag() == tag) {
                quitting = true;
                return UpdateResult.from(this, Command.quit());
            }
        }

        UpdateResult<Spinner> spinnerResult = spinner.update(msg);
        if (spinnerResult.command() != null) {
            spinner = spinnerResult.model();
            return UpdateResult.from(this, spinnerResult.command());
        }

        return UpdateResult.from(this);
    }

    @Override
    public String view() {
        String status = spinner.view() + " Waiting for debounce...";
        return (
            "Key presses: " +
            tag +
            "\n" +
            status +
            "\n\nTo exit press any key, then wait for one second without pressing anything."
        );
    }

    public static void main(String[] args) {
        new Program(new DebounceExample()).run();
    }

    private record ExitMessage(int tag) implements Message {}
}
