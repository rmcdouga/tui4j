package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Compatibility shim for {@link WindowSizeMsg}.
 */
public class WindowSizeMessage implements MessageShim {

    private final int width;
    private final int height;

    public WindowSizeMessage(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    @Override
    public Message toMessage() {
        return new WindowSizeMsg(width, height);
    }
}
