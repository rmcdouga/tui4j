package com.williamcallahan.tui4j.compat.bubbles.timer;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import java.util.Objects;

/**
 * Port of Bubbles start stop message.
 * Bubble Tea: bubbletea/examples/timer/main.go
 * <p>
 * Bubbles: timer/timer.go.
 */
public class StartStopMessage implements Message {
    private final int id;
    private final boolean running;

    /**
     * Creates StartStopMessage to keep this component ready for use.
     *
     * @param id id
     * @param running running
     */
    public StartStopMessage(int id, boolean running) {
        this.id = id;
        this.running = running;
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
     * Handles running for this component.
     *
     * @return whether nning
     */
    public boolean running() {
        return running;
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
        StartStopMessage that = (StartStopMessage) o;
        return id == that.id && running == that.running;
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, running);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "StartStopMessage[id=" + id + ", running=" + running + "]";
    }
}
