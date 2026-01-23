package com.williamcallahan.tui4j.compat.bubbletea.input.key;

import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/key_test.go.
 */
class KeyTest {

    @Test
    void testKeyStringAltSpace() {
        KeyPressMessage msg = new KeyPressMessage(new Key(KeyType.KeySpace, new char[]{' '}, true, false));
        assertThat(msg.key()).isEqualTo("alt+ ");
    }

    @Test
    void testKeyStringRunes() {
        KeyPressMessage msg = new KeyPressMessage(new Key(KeyType.KeyRunes, new char[]{'a'}, false, false));
        assertThat(msg.key()).isEqualTo("a");
    }
}
