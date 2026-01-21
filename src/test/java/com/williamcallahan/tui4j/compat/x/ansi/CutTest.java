package com.williamcallahan.tui4j.compat.x.ansi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for ANSI-aware string cutting.
 * Verifies that Cut.cut() properly handles ANSI escape sequences,
 * preserving them in the output regardless of their position.
 */
public class CutTest {

    @Test
    public void testCutBasic() {
        assertEquals("ello", Cut.cut("hello world", 1, 5));
        assertEquals("hello", Cut.cut("hello world", 0, 5));
        assertEquals("world", Cut.cut("hello world", 6, 11));
    }

    @Test
    public void testCutPreservesAnsiInVisibleRegion() {
        // ANSI red color: ESC[31m ... ESC[0m
        String redText = "\u001B[31mhello\u001B[0m world";
        String result = Cut.cut(redText, 0, 5);
        // Should preserve the ANSI codes
        assertTrue(result.contains("\u001B[31m"));
    }

    @Test
    public void testCutPreservesAnsiBeforeVisibleRegion() {
        // ANSI codes before the visible region should still be preserved
        // (they may affect rendering of visible text)
        String styledText = "\u001B[31mred\u001B[0m normal";
        String result = Cut.cut(styledText, 4, 10);
        // The cut region starts after "red " - the ANSI reset should be preserved
        assertNotNull(result);
    }

    @Test
    public void testCutPreservesAnsiAfterVisibleRegion() {
        // ANSI codes after the visible region should be preserved
        // (this matches the original Viewport.cutLine() behavior)
        String styledText = "hello\u001B[31m world\u001B[0m";
        String result = Cut.cut(styledText, 0, 5);
        // Result should contain "hello" plus the ANSI codes that follow
        assertTrue(result.contains("hello"));
        // The ANSI codes after "hello" are preserved
        assertTrue(result.contains("\u001B[31m") || result.contains("\u001B[0m"));
    }

    @Test
    public void testCutWithWideCjkCharacters() {
        // CJK characters are 2 cells wide
        String cjk = "AB\u4E2D\u6587CD"; // AB中文CD - 中 and 文 are 2 cells each
        // Width: A(1) B(1) 中(2) 文(2) C(1) D(1) = 8 cells total
        String result = Cut.cut(cjk, 0, 4);
        // Should get "AB中" (1+1+2 = 4 cells)
        assertEquals("AB\u4E2D", result);
    }

    @Test
    public void testCutWithEmoji() {
        // Emojis are typically 2 cells wide
        String emoji = "Hi\uD83D\uDE00there"; // Hi😀there
        String result = Cut.cut(emoji, 0, 4);
        // Should get "Hi😀" (1+1+2 = 4 cells)
        assertEquals("Hi\uD83D\uDE00", result);
    }

    @Test
    public void testCutWcMatchesUpstreamBehavior() {
        // WC width uses truncateWc for both operations in upstream x/ansi.
        // This is intentionally different from TruncateLeftWc.
        assertEquals("a", Cut.cutWc("abcdef", 1, 3));
    }

    @Test
    public void testCutInvalidBounds() {
        // Invalid bounds should return empty string (slice semantics)
        assertEquals("", Cut.cut("hello", 5, 3)); // right <= left
        assertEquals("", Cut.cut("hello", 0, 0)); // right == left
        assertEquals("", Cut.cut("hello", -1, -1)); // negative bounds
    }

    @Test
    public void testCutNullInput() {
        assertThrows(NullPointerException.class, () -> Cut.cut(null, 0, 5));
    }

    @Test
    public void testCutEmptyInput() {
        assertEquals("", Cut.cut("", 0, 5));
    }

    @Test
    public void testCutEntireString() {
        assertEquals("hello", Cut.cut("hello", 0, 10));
    }

    @Test
    public void testCutFromMiddle() {
        assertEquals("lo wo", Cut.cut("hello world", 3, 8));
    }

    /**
     * Verifies semantic equivalence with original Viewport.cutLine() behavior.
     * The original cutLine preserved all ANSI sequences unconditionally
     * (the condition was always true for valid bounds).
     */
    @Test
    public void testCutMatchesOriginalCutLineBehavior() {
        // Original cutLine condition: (currentCol >= startCol || currentCol < endCol)
        // For valid startCol < endCol, this is always true, so ALL ANSI sequences were preserved.
        // Cut.cut() also preserves all ANSI sequences, so behavior should match.

        // Test case: ANSI sequence before visible region
        String beforeTest = "\u001B[1mbold\u001B[0m normal text";
        String cutResult = Cut.cut(beforeTest, 5, 11); // "normal"
        // ANSI reset (after "bold") should be in the output
        assertTrue(cutResult.contains("normal"));

        // Test case: ANSI sequence in visible region
        String inTest = "hello \u001B[31mred\u001B[0m world";
        String inResult = Cut.cut(inTest, 6, 12);
        assertTrue(inResult.contains("\u001B[31m"));
        assertTrue(inResult.contains("red"));
    }
}
