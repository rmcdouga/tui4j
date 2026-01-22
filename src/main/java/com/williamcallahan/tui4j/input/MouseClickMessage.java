package com.williamcallahan.tui4j.input;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.input.MouseButton;

/**
 * Synthesized click message from mouse press/release.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/input/MouseClickMessage.java
 *
 * @param column column where the click occurred
 * @param row row where the click occurred
 * @param button mouse button associated with the click
 * @param shift whether shift was held
 * @param alt whether alt was held
 * @param ctrl whether ctrl was held
 * @param clickCount click chain count at the same cell
 * @param target resolved target under the click, if any
 * @param source originating mouse release message
 */
public record MouseClickMessage(
        int column,
        int row,
        MouseButton button,
        boolean shift,
        boolean alt,
        boolean ctrl,
        int clickCount,
        MouseTarget target,
        com.williamcallahan.tui4j.compat.bubbletea.input.MouseMessage source
) implements Message {
    /**
     * Creates a click message from a release event and timestamp.
     *
     * @param event source mouse event
     * @param timestamp event time in milliseconds
     */
    public MouseClickMessage(com.williamcallahan.tui4j.compat.bubbletea.input.MouseMessage event, long timestamp) {
        this(
                event.column(),
                event.row(),
                event.getButton(),
                event.isShift(),
                event.isAlt(),
                event.isCtrl(),
                1,
                null,
                event
        );
    }
}
