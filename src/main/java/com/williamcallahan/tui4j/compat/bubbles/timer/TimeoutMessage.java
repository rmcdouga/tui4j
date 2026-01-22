package com.williamcallahan.tui4j.compat.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import java.util.Objects;

/**
 * Emitted once when a timer reaches (or passes) its timeout.
 * Bubble Tea: bubbletea/examples/timer/main.go
 * <p>
 * Bubbles: timer/timer.go.
 */
public class TimeoutMessage implements Message {
    private final int id;

    /**
     * Creates TimeoutMessage to keep this component ready for use.
     *
     * @param id id
     */
    public TimeoutMessage(int id) {
        this.id = id;
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
     * Handles equals for this component.
     *
     * @param o o
     * @return whether uals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeoutMessage that = (TimeoutMessage) o;
        return id == that.id;
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "TimeoutMessage[id=" + id + "]";
    }
}
