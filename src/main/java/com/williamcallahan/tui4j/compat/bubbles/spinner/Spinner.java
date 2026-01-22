package com.williamcallahan.tui4j.compat.bubbles.spinner;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.lipgloss.Style;

import java.time.LocalDateTime;

/**
 * Port of Bubbles spinner.
 * Bubble Tea: bubbletea/examples/spinner/main.go
 * <p>
 * Bubbles: spinner/spinner.go.
 */
public class Spinner implements Model {

    private SpinnerType type;
    private int frame;
    private int id;
    private int tag;
    private Style style = Style.newStyle();

    /**
     * Creates Spinner to keep this component ready for use.
     *
     * @param type type
     */
    public Spinner(SpinnerType type) {
        this.type = type;
    }

    /**
     * Updates the type.
     *
     * @param type type
     */
    public void setType(SpinnerType type) {
        this.type = type;
    }

    /**
     * Updates the style.
     *
     * @param style style
     * @return result
     */
    public Spinner setStyle(Style style) {
        this.style = style;
        return this;
    }

    /**
     * Supplies the initial command for the model.
     *
     * @return initial command
     */
    public Command init() {
        return this::tick;
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg msg
     * @return next model state and command
     */
    public UpdateResult<Spinner> update(Message msg) {
        if (msg instanceof TickMessage tickMessage) {
            if (tickMessage.id() > 0 && tickMessage.id() != id) {
                return UpdateResult.from(this);
            }
            if (tickMessage.tag() > 0 && tickMessage.tag() != tag) {
                return UpdateResult.from(this);
            }

            frame++;
            if (frame >= type.frames().length) {
                frame = 0;
            }

            tag++;
            return UpdateResult.from(
                    this,
                    Command.tick(type.duration(), localDateTime -> new TickMessage(localDateTime, tag, id))
            );
        }

        return UpdateResult.from(this);
    }

    /**
     * Renders the model view for display.
     *
     * @return rendered view
     */
    public String view() {
        if (frame >= type.frames().length) {
            return "(error)";
        }
        return style.render(type.frames()[frame]);
    }

    /**
     * Handles tick for this component.
     *
     * @return result
     */
    public Message tick() {
        return new TickMessage(LocalDateTime.now(), tag, id);
    }
}
