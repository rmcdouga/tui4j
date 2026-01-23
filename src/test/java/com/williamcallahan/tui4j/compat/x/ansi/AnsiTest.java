package com.williamcallahan.tui4j.compat.x.ansi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for ANSI utility helpers.
 */
public class AnsiTest {

    @Test
    public void testUtf8ByteLengthMatchesUpstream() {
        assertEquals(1, Ansi.utf8ByteLength((byte) 0x7F));
        assertEquals(2, Ansi.utf8ByteLength((byte) 0xC0));
        assertEquals(3, Ansi.utf8ByteLength((byte) 0xE0));
        assertEquals(4, Ansi.utf8ByteLength((byte) 0xF0));
        assertEquals(-1, Ansi.utf8ByteLength((byte) 0x80));
        assertEquals(-1, Ansi.utf8ByteLength((byte) 0xF8));
    }
}
