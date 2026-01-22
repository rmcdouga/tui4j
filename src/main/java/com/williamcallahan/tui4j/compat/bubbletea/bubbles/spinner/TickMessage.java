package com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner;

import java.time.LocalDateTime;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.spinner.TickMessage} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: spinner/spinner.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class TickMessage extends com.williamcallahan.tui4j.compat.bubbles.spinner.TickMessage {
    /**
     * Creates TickMessage to keep this component ready for use.
     *
     * @param time time
     * @param tag tag
     * @param id id
     */
    public TickMessage(LocalDateTime time, int tag, int id) {
        super(time, tag, id);
    }
}
