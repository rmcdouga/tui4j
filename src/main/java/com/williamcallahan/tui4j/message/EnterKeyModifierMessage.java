package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message emitted for Kitty CSI-u Enter modifier sequences.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public final class EnterKeyModifierMessage implements Message {
    private final EnterKeyModifier modifier;

    /**
     * Creates an Enter key modifier message.
     *
     * @param modifier Enter modifier value
     */
    public EnterKeyModifierMessage(EnterKeyModifier modifier) {
        this.modifier = modifier;
    }

    /**
     * Returns the Enter modifier.
     *
     * @return modifier value
     */
    public EnterKeyModifier modifier() {
        return modifier;
    }
}
