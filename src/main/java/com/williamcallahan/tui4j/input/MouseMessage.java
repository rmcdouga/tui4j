package com.williamcallahan.tui4j.input;

import com.williamcallahan.tui4j.compat.bubbletea.input.MouseAction;
import com.williamcallahan.tui4j.compat.bubbletea.input.MouseButton;

/**
 * Mouse input event for tui4j input tracking.
 * <p>
 * Extends the compat mouse message to provide seamless interoperability
 * between tui4j extensions and the Bubble Tea compatibility layer.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/input/MouseMessage.java
 */
public class MouseMessage extends com.williamcallahan.tui4j.compat.bubbletea.input.MouseMessage {

    /**
     * Creates a mouse message.
     *
     * @param x column position
     * @param y row position
     * @param shift whether shift was held
     * @param alt whether alt was held
     * @param ctrl whether ctrl was held
     * @param action the mouse action
     * @param button the mouse button
     */
    public MouseMessage(int x, int y, boolean shift, boolean alt, boolean ctrl,
                        MouseAction action, MouseButton button) {
        super(x, y, shift, alt, ctrl, action, button);
    }
}
