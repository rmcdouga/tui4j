package com.williamcallahan.tui4j.input.kitty;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.ProgramOption;
import com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage;
import com.williamcallahan.tui4j.message.EnterKeyModifier;
import com.williamcallahan.tui4j.message.EnterKeyModifierMessage;

/**
 * Maps Kitty CSI-u Enter sequences to tui4j messages without altering compat.
 */
public final class KittyEnterKeyMappings {
    private static final String ENTER_PREFIX = "\u001b[13;";
    private static final char ENTER_SUFFIX = 'u';

    /**
     * Creates a utility container for Kitty Enter mappings.
     */
    private KittyEnterKeyMappings() {
    }

    /**
     * Returns a program option that converts Kitty CSI-u Enter sequences into
     * {@link EnterKeyModifierMessage} instances.
     *
     * @return program option for mapping Kitty Enter sequences
     */
    public static ProgramOption withKittyEnterKeyMappings() {
        return ProgramOption.withFilter(KittyEnterKeyMappings::filterMessage);
    }

    /**
     * Parses a Kitty CSI-u Enter sequence into a modifier value.
     *
     * @param sequence input sequence string
     * @return modifier value, or {@code null} when not a Kitty Enter sequence
     */
    public static EnterKeyModifier parseEnterKeyModifier(String sequence) {
        if (!sequence.startsWith(ENTER_PREFIX)) {
            return null;
        }
        if (sequence.length() <= ENTER_PREFIX.length()) {
            return null;
        }
        if (sequence.charAt(sequence.length() - 1) != ENTER_SUFFIX) {
            return null;
        }
        String modifier = sequence.substring(
            ENTER_PREFIX.length(),
            sequence.length() - 1
        );
        return switch (modifier) {
            case "2" -> EnterKeyModifier.Shift;
            case "5" -> EnterKeyModifier.Ctrl;
            case "6" -> EnterKeyModifier.CtrlShift;
            default -> null;
        };
    }

    /**
     * Applies Kitty Enter mappings to an incoming message.
     *
     * @param model current model
     * @param message incoming message
     * @return mapped message or the original when not applicable
     */
    static Message filterMessage(Model model, Message message) {
        if (message instanceof UnknownSequenceMessage unknown) {
            EnterKeyModifier modifier = parseEnterKeyModifier(unknown.sequence());
            if (modifier != null) {
                return new EnterKeyModifierMessage(modifier);
            }
        }
        return message;
    }
}
