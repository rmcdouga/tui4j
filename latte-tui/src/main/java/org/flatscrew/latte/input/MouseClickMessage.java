package org.flatscrew.latte.input;

import org.flatscrew.latte.Message;

/**
 * Synthesized click message created from mouse press/release.
 * Latte extension; no Bubble Tea equivalent.
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
        MouseMessage source
) implements Message {
}
