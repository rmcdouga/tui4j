package com.williamcallahan.tui4j.compat.bubbletea.input.key;

import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests Kitty CSI-u enter modifier mappings preserved for TUI4J compatibility.
 */
class KittyEnterSequencesTest {

    /**
     * Verifies key name strings for enter modifier key types.
     */
    @Test
    void testEnterModifierKeyNames() {
        KeyPressMessage shiftEnter = new KeyPressMessage(new Key(KeyType.KeyShiftEnter));
        KeyPressMessage ctrlEnter = new KeyPressMessage(new Key(KeyType.KeyCtrlEnter));
        KeyPressMessage ctrlShiftEnter = new KeyPressMessage(new Key(KeyType.KeyCtrlShiftEnter));

        assertThat(shiftEnter.key()).isEqualTo("shift+enter");
        assertThat(ctrlEnter.key()).isEqualTo("ctrl+enter");
        assertThat(ctrlShiftEnter.key()).isEqualTo("ctrl+shift+enter");
    }

    /**
     * Verifies Kitty CSI-u sequences map to enter modifier key types.
     */
    @Test
    void testKittyEnterSequences() {
        Key shiftEnter = Sequences.SEQUENCES.get("\u001B[13;2u");
        Key ctrlEnter = Sequences.SEQUENCES.get("\u001B[13;5u");
        Key ctrlShiftEnter = Sequences.SEQUENCES.get("\u001B[13;6u");

        assertThat(shiftEnter).isNotNull();
        assertThat(ctrlEnter).isNotNull();
        assertThat(ctrlShiftEnter).isNotNull();

        assertThat(shiftEnter.type()).isEqualTo(KeyType.KeyShiftEnter);
        assertThat(ctrlEnter.type()).isEqualTo(KeyType.KeyCtrlEnter);
        assertThat(ctrlShiftEnter.type()).isEqualTo(KeyType.KeyCtrlShiftEnter);

        assertThat(shiftEnter.alt()).isFalse();
        assertThat(ctrlEnter.alt()).isFalse();
        assertThat(ctrlShiftEnter.alt()).isFalse();
    }
}
