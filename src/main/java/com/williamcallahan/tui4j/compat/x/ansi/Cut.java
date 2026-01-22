package com.williamcallahan.tui4j.compat.x.ansi;

import java.util.Objects;

/**
 * ANSI-aware string cutting.
 * Port of github.com/charmbracelet/x/ansi (truncate.go Cut functions)
 */
public final class Cut {
    /**
     * Creates Cut to keep this component ready for use.
     */
    private Cut() {}

    /**
     * Cuts the string to display a portion from left to right positions.
     * Uses grapheme clustering for width calculation.
     * ANSI escape codes within the visible region are preserved.
     *
     * <p>Note that [left] is inclusive, while [right] is exclusive,
     * which is to say it returns [left, right).
     *
     * @param s the input string (must not be null)
     * @param left start position (inclusive)
     * @param right end position (exclusive)
     * @return the cut string
     * @throws NullPointerException if s is null
     */
    public static String cut(String s, int left, int right) {
        return cut(Method.GRAPHEME_WIDTH, s, left, right);
    }

    /**
     * Cuts the string to display a portion from left to right positions.
     * Uses wcwidth for width calculation.
     * ANSI escape codes within the visible region are preserved.
     *
     * <p>Note that [left] is inclusive, while [right] is exclusive,
     * which is to say it returns [left, right).
     *
     * @param s the input string (must not be null)
     * @param left start position (inclusive)
     * @param right end position (exclusive)
     * @return the cut string
     * @throws NullPointerException if s is null
     */
    public static String cutWc(String s, int left, int right) {
        return cut(Method.WC_WIDTH, s, left, right);
    }

    /**
     * Cuts the string to display a portion from left to right positions.
     * ANSI escape codes within the visible region are preserved.
     *
     * <p>Note that [left] is inclusive, while [right] is exclusive,
     * which is to say it returns [left, right).
     *
     * <p>Returns empty string for invalid bounds (right &lt;= left), consistent
     * with slice semantics used in the upstream Go implementation.
     *
     * @param method the width calculation method (must not be null)
     * @param s the input string (must not be null)
     * @param left start position (inclusive)
     * @param right end position (exclusive)
     * @return the cut string, or empty string if bounds are invalid
     * @throws NullPointerException if method or s is null
     */
    public static String cut(Method method, String s, int left, int right) {
        Objects.requireNonNull(method, "method");
        Objects.requireNonNull(s, "s");
        if (right <= left) {
            return "";
        }

        if (method == Method.WC_WIDTH) {
            if (left == 0) {
                return Truncate.truncateWc(s, right, "");
            }
            return Truncate.truncateWc(Truncate.truncateWc(s, right, ""), left, "");
        }

        if (left == 0) {
            return Truncate.truncate(s, right, "");
        }

        return Truncate.truncateLeft(Truncate.truncate(s, right, ""), left, "");
    }
}
