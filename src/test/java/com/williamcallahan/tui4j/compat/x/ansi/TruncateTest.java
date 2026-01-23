package com.williamcallahan.tui4j.compat.x.ansi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for ANSI-aware truncation.
 */
public class TruncateTest {

    @Test
    public void testTruncateWcUsesGraphemeWidthForEarlyReturn() {
        // Family emoji is a single grapheme cluster with ZWJ, width 2 in grapheme mode.
        String family = "\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC66";
        assertEquals(family, Truncate.truncateWc(family, 2, ""));
    }
}
