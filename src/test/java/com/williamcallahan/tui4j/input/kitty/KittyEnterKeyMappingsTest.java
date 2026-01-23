package com.williamcallahan.tui4j.input.kitty;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage;
import com.williamcallahan.tui4j.message.EnterKeyModifier;
import com.williamcallahan.tui4j.message.EnterKeyModifierMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests Kitty CSI-u Enter sequence mapping.
 */
class KittyEnterKeyMappingsTest {

    /**
     * Ensures Kitty CSI-u enter modifiers parse to the expected values.
     */
    @Test
    void testParseEnterKeyModifier() {
        assertThat(
            KittyEnterKeyMappings.parseEnterKeyModifier("\u001b[13;2u")
        ).isEqualTo(EnterKeyModifier.Shift);
        assertThat(
            KittyEnterKeyMappings.parseEnterKeyModifier("\u001b[13;5u")
        ).isEqualTo(EnterKeyModifier.Ctrl);
        assertThat(
            KittyEnterKeyMappings.parseEnterKeyModifier("\u001b[13;6u")
        ).isEqualTo(EnterKeyModifier.CtrlShift);
        assertThat(
            KittyEnterKeyMappings.parseEnterKeyModifier("\u001b[13;9u")
        ).isNull();
    }

    /**
     * Ensures unknown sequences are mapped only when they match Kitty Enter.
     */
    @Test
    void testFilterMessage() {
        Message mapped = KittyEnterKeyMappings.filterMessage(
            null,
            new UnknownSequenceMessage("\u001b[13;5u")
        );
        assertThat(mapped).isInstanceOf(EnterKeyModifierMessage.class);
        EnterKeyModifierMessage enterMessage =
            (EnterKeyModifierMessage) mapped;
        assertThat(enterMessage.modifier()).isEqualTo(EnterKeyModifier.Ctrl);

        UnknownSequenceMessage original =
            new UnknownSequenceMessage("\u001b[1;2A");
        Message passthrough = KittyEnterKeyMappings.filterMessage(null, original);
        assertThat(passthrough).isSameAs(original);
    }
}
