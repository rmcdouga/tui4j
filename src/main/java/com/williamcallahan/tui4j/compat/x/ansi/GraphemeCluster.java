package com.williamcallahan.tui4j.compat.x.ansi;

import com.ibm.icu.text.BreakIterator;

import java.nio.charset.StandardCharsets;

/**
 * Grapheme cluster extraction and width calculation utilities.
 * Port of github.com/charmbracelet/x/ansi grapheme utilities.
 * <p>
 * Uses ICU4J's BreakIterator for Unicode-correct grapheme segmentation,
 * equivalent to Go's rivo/uniseg library used by the upstream implementation.
 * <p>
 * Methods return {@code null} when no cluster is found (empty input, end of sequence),
 * consistent with Go's nil return pattern. Callers should check for null before use.
 */
public final class GraphemeCluster {
    private GraphemeCluster() {}

    /**
     * Result of extracting the first grapheme cluster from a byte sequence.
     *
     * @param cluster the grapheme cluster as a UTF-8 string
     * @param clusterBytes the grapheme cluster as raw bytes
     * @param width the display width in cells
     */
    public record Result(String cluster, byte[] clusterBytes, int width) {}

    /**
     * Extracts the first grapheme cluster from a byte sequence starting at the given offset.
     * <p>
     * Returns {@code null} when:
     * <ul>
     *   <li>startIndex is beyond the byte array bounds</li>
     *   <li>The remaining bytes form an empty string</li>
     *   <li>No grapheme cluster can be extracted</li>
     * </ul>
     * This null return signals "no more clusters" and is consistent with Go's
     * rivo/uniseg.FirstGraphemeCluster which returns nil for empty input.
     *
     * @param bytes the byte sequence
     * @param startIndex the starting byte index
     * @param method the width calculation method
     * @return the grapheme cluster result, or {@code null} if no cluster available
     */
    public static Result getFirstGraphemeCluster(byte[] bytes, int startIndex, Method method) {
        if (startIndex >= bytes.length) {
            return null;
        }

        String text = new String(bytes, startIndex, bytes.length - startIndex, StandardCharsets.UTF_8);
        if (text.isEmpty()) {
            return null;
        }

        BreakIterator iterator = BreakIterator.getCharacterInstance();
        iterator.setText(text);

        int clusterStart = iterator.first();
        int clusterEnd = iterator.next();

        if (clusterEnd == BreakIterator.DONE) {
            return null;
        }

        String cluster = text.substring(clusterStart, clusterEnd);
        int width = calculateWidth(cluster, method);
        byte[] clusterBytes = cluster.getBytes(StandardCharsets.UTF_8);

        return new Result(cluster, clusterBytes, width);
    }

    /**
     * Gets the first grapheme cluster from a string.
     *
     * @param s the input string
     * @param method the width calculation method
     * @return the cluster string and its width
     */
    public static StringResult getFirstGraphemeClusterString(String s, Method method) {
        if (s == null || s.isEmpty()) {
            return new StringResult("", 0);
        }

        BreakIterator iterator = BreakIterator.getCharacterInstance();
        iterator.setText(s);

        int clusterStart = iterator.first();
        int clusterEnd = iterator.next();

        if (clusterEnd == BreakIterator.DONE) {
            return new StringResult("", 0);
        }

        String cluster = s.substring(clusterStart, clusterEnd);
        int width = calculateWidth(cluster, method);

        return new StringResult(cluster, width);
    }

    /**
     * Result of extracting a grapheme cluster from a string.
     *
     * @param cluster the grapheme cluster
     * @param width the display width in cells
     */
    public record StringResult(String cluster, int width) {}

    /**
     * Calculates the display width of a grapheme cluster.
     *
     * @param cluster the grapheme cluster
     * @param method the width calculation method
     * @return the display width in cells
     */
    public static int calculateWidth(String cluster, Method method) {
        if (cluster == null || cluster.isEmpty()) {
            return 0;
        }

        int codePoint = cluster.codePointAt(0);

        // Check for zero-width characters
        if (isZeroWidth(codePoint)) {
            return 0;
        }

        // Check for control characters
        if (Character.getType(codePoint) == Character.CONTROL) {
            return 0;
        }

        // Check for ZWJ sequences (family emojis, flags, etc.) - always wide
        if (cluster.length() > 1 && cluster.indexOf(Ansi.ZWJ_CHAR) >= 0) {
            return 2;
        }

        // Check if this is a wide character (emoji, CJK, or supplementary)
        if (isWideCharacter(codePoint)) {
            return 2;
        }

        return 1;
    }

    private static boolean isZeroWidth(int codePoint) {
        int type = Character.getType(codePoint);
        return type == Character.NON_SPACING_MARK
                || type == Character.ENCLOSING_MARK
                || type == Character.COMBINING_SPACING_MARK
                || codePoint == Ansi.ZERO_WIDTH_SPACE
                || codePoint == Ansi.ZERO_WIDTH_NON_JOINER
                || codePoint == Ansi.ZERO_WIDTH_JOINER
                || codePoint == Ansi.ZERO_WIDTH_NO_BREAK_SPACE;
    }

    /**
     * Determines if a code point represents a wide character (2 terminal cells).
     * Consolidated check for emoji blocks, CJK blocks, and supplementary code points.
     */
    private static boolean isWideCharacter(int codePoint) {
        // Supplementary code points (U+10000 and above, including many emojis) are wide
        if (Character.isSupplementaryCodePoint(codePoint)) {
            return true;
        }

        // Check Unicode block for emoji and CJK characters
        Character.UnicodeBlock block = Character.UnicodeBlock.of(codePoint);
        if (block == null) {
            return false;
        }

        // Emoji blocks
        if (block == Character.UnicodeBlock.EMOTICONS
                || block == Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS
                || block == Character.UnicodeBlock.TRANSPORT_AND_MAP_SYMBOLS
                || block == Character.UnicodeBlock.SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS) {
            return true;
        }

        // CJK and East Asian wide blocks
        return block == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || block == Character.UnicodeBlock.HIRAGANA
                || block == Character.UnicodeBlock.KATAKANA
                || block == Character.UnicodeBlock.HANGUL_SYLLABLES
                || block == Character.UnicodeBlock.CJK_COMPATIBILITY
                || block == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || block == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || block == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT
                || block == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT
                || block == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || block == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS
                || block == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }
}
