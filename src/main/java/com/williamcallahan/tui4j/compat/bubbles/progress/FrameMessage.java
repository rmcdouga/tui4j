package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Compatibility shim for {@link FrameMsg}.
 */
public class FrameMessage implements MessageShim {
    private final int id;
    private final int tag;

    public FrameMessage(int id, int tag) {
        this.id = id;
        this.tag = tag;
    }

    public int id() {
        return id;
    }

    public int tag() {
        return tag;
    }

    @Override
    public Message toMessage() {
        return new FrameMsg(id, tag);
    }
}
