package com.williamcallahan.tui4j.compat.bubbletea.input.key;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Validates key name mappings against Bubble Tea behavior.
 */
class KeyNamesTest {

    /**
     * Ensures control key labels align with upstream names.
     */
    @Test
    void testControlKeyNames() {
        assertThat(KeyNames.getKeyName(KeyType.keyCAN)).isEqualTo("ctrl+x");
        assertThat(KeyNames.getKeyName(KeyType.keyEM)).isEqualTo("ctrl+y");
    }
}
