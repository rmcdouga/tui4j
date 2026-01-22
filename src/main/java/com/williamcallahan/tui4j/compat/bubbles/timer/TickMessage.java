package com.williamcallahan.tui4j.compat.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import java.util.Objects;

/**
 * Port of Bubbles tick message.
 * Bubble Tea: bubbletea/examples/timer/main.go
 * <p>
 * Bubbles: timer/timer.go.
 */
public class TickMessage implements Message {
    private final int id;
    private final boolean timeout;
    private final int tag;

    /**
     * Creates TickMessage to keep this component ready for use.
     *
     * @param id id
     * @param timeout timeout
     * @param tag tag
     */
    public TickMessage(int id, boolean timeout, int tag) {
        this.id = id;
        this.timeout = timeout;
        this.tag = tag;
    }

    /**
     * Handles id for this component.
     *
     * @return result
     */
    public int id() {
        return id;
    }

    /**
     * Handles timeout for this component.
     *
     * @return whether meout
     */
    public boolean timeout() {
        return timeout;
    }

    /**
     * Handles tag for this component.
     *
     * @return result
     */
    public int tag() {
        return tag;
    }

    /**
     * Handles equals for this component.
     *
     * @param o o
     * @return whether uals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TickMessage that = (TickMessage) o;
        return id == that.id && timeout == that.timeout && tag == that.tag;
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, timeout, tag);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "TickMessage[id=" + id + ", timeout=" + timeout + ", tag=" + tag + "]";
    }
}
