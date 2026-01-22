package com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.spinner.Spinner} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: spinner/spinner.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Spinner extends com.williamcallahan.tui4j.compat.bubbles.spinner.Spinner {
    
    /**
     * Creates Spinner to keep this component ready for use.
     *
     * @param type type
     */
    public Spinner(SpinnerType type) {
        super(type.toNew());
    }

    /**
     * Updates the type.
     *
     * @param type type
     */
    public void setType(SpinnerType type) {
        super.setType(type.toNew());
    }

    /**
     * Handles tick for this component.
     *
     * @return result
     */
    @Override
    public Message tick() {
        com.williamcallahan.tui4j.compat.bubbles.spinner.TickMessage msg = 
            (com.williamcallahan.tui4j.compat.bubbles.spinner.TickMessage) super.tick();
        return new TickMessage(msg.time(), msg.tag(), msg.id());
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg msg
     * @return next model state and command
     */
    @Override
    public UpdateResult<com.williamcallahan.tui4j.compat.bubbles.spinner.Spinner> update(Message msg) {
        if (msg instanceof TickMessage tm) {
            msg = new com.williamcallahan.tui4j.compat.bubbles.spinner.TickMessage(tm.time(), tm.tag(), tm.id());
        }
        return super.update(msg);
    }
}
