package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Compatibility shim for {@link SetPercentMsg}.
 */
public class SetPercentMessage implements MessageShim {
    private final double percent;

    public SetPercentMessage(double percent) {
        this.percent = percent;
    }

    public double percent() {
        return percent;
    }

    @Override
    public Message toMessage() {
        return new SetPercentMsg(percent);
    }
}
