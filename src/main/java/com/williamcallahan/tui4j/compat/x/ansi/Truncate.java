package com.williamcallahan.tui4j.compat.x.ansi;

import com.williamcallahan.tui4j.compat.x.ansi.parser.Action;
import com.williamcallahan.tui4j.compat.x.ansi.parser.State;
import com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * ANSI-aware string truncation.
 * Port of github.com/charmbracelet/x/ansi (truncate.go)
 */
public final class Truncate {
    private Truncate() {}

    /**
     * Truncates a string to a given length, adding a tail if truncated.
     * Uses grapheme clustering for width calculation.
     * ANSI escape codes are preserved and not counted toward width.
     *
     * @param s the input string (must not be null)
     * @param length the maximum cell width
     * @param tail the tail to append if truncated (must not be null)
     * @return the truncated string
     * @throws NullPointerException if s or tail is null
     */
    public static String truncate(String s, int length, String tail) {
        return truncate(Method.GRAPHEME_WIDTH, s, length, tail);
    }

    /**
     * Truncates a string to a given length, adding a tail if truncated.
     * Uses wcwidth for width calculation.
     * ANSI escape codes are preserved and not counted toward width.
     *
     * @param s the input string (must not be null)
     * @param length the maximum cell width
     * @param tail the tail to append if truncated (must not be null)
     * @return the truncated string
     * @throws NullPointerException if s or tail is null
     */
    public static String truncateWc(String s, int length, String tail) {
        return truncate(Method.WC_WIDTH, s, length, tail);
    }

    /**
     * Truncates a string to a given length, adding a tail if truncated.
     * ANSI escape codes are preserved and not counted toward width.
     *
     * @param method the width calculation method (must not be null)
     * @param s the input string (must not be null)
     * @param length the maximum cell width
     * @param tail the tail to append if truncated (must not be null)
     * @return the truncated string
     * @throws NullPointerException if method, s, or tail is null
     */
    public static String truncate(Method method, String s, int length, String tail) {
        Objects.requireNonNull(method, "method");
        Objects.requireNonNull(s, "s");
        Objects.requireNonNull(tail, "tail");
        if (s.isEmpty()) {
            return s;
        }
        if (StringWidth.stringWidth(s) <= length) {
            return s;
        }

        int tailWidth = StringWidth.stringWidth(tail);
        int targetLength = length - tailWidth;
        if (targetLength < 0) {
            return "";
        }

        TransitionTable table = TransitionTable.get();
        State pstate = State.GROUND;
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);

        StringBuilder buf = new StringBuilder();
        int curWidth = 0;
        boolean ignoring = false;

        for (int i = 0; i < bytes.length; ) {
            TransitionTable.Transition transition = table.transition(pstate, bytes[i]);
            State state = transition.state();
            Action action = transition.action();

            if (state == State.UTF8) {
                GraphemeCluster.Result result = GraphemeCluster.getFirstGraphemeCluster(bytes, i, method);
                if (result == null) {
                    // Null signals no valid grapheme cluster at this position (malformed UTF-8
                    // or end of data). Skip the byte and continue - this matches Go's behavior
                    // where invalid sequences are skipped rather than causing errors.
                    i++;
                    continue;
                }

                i += result.clusterBytes().length;
                curWidth += result.width();

                if (ignoring) {
                    continue;
                }

                if (curWidth > targetLength) {
                    ignoring = true;
                    buf.append(tail);
                    continue;
                }

                buf.append(result.cluster());
                pstate = State.GROUND;
                continue;
            }

            switch (action) {
                case PRINT:
                    if (curWidth >= targetLength && !ignoring) {
                        ignoring = true;
                        buf.append(tail);
                    }

                    if (ignoring) {
                        i++;
                        continue;
                    }

                    curWidth++;
                    buf.append((char) (bytes[i] & Ansi.BYTE_MASK));
                    break;
                case EXECUTE:
                    if (ignoring) {
                        i++;
                        continue;
                    }
                    buf.append((char) (bytes[i] & Ansi.BYTE_MASK));
                    break;
                default:
                    // ANSI sequences are always preserved
                    buf.append((char) (bytes[i] & Ansi.BYTE_MASK));
                    break;
            }

            i++;
            pstate = state;

            if (curWidth > targetLength && !ignoring) {
                ignoring = true;
                buf.append(tail);
            }
        }

        return buf.toString();
    }

    /**
     * Truncates a string from the left side by removing n characters.
     * Uses grapheme clustering for width calculation.
     * ANSI escape codes are preserved.
     *
     * @param s the input string (must not be null)
     * @param n the number of cells to remove from the left
     * @param prefix the prefix to prepend after truncation (must not be null)
     * @return the truncated string
     * @throws NullPointerException if s or prefix is null
     */
    public static String truncateLeft(String s, int n, String prefix) {
        return truncateLeft(Method.GRAPHEME_WIDTH, s, n, prefix);
    }

    /**
     * Truncates a string from the left side by removing n characters.
     * Uses wcwidth for width calculation.
     * ANSI escape codes are preserved.
     *
     * @param s the input string (must not be null)
     * @param n the number of cells to remove from the left
     * @param prefix the prefix to prepend after truncation (must not be null)
     * @return the truncated string
     * @throws NullPointerException if s or prefix is null
     */
    public static String truncateLeftWc(String s, int n, String prefix) {
        return truncateLeft(Method.WC_WIDTH, s, n, prefix);
    }

    /**
     * Truncates a string from the left side by removing n characters.
     * ANSI escape codes are preserved.
     *
     * @param method the width calculation method (must not be null)
     * @param s the input string (must not be null)
     * @param n the number of cells to remove from the left
     * @param prefix the prefix to prepend after truncation (must not be null)
     * @return the truncated string
     * @throws NullPointerException if method, s, or prefix is null
     */
    public static String truncateLeft(Method method, String s, int n, String prefix) {
        Objects.requireNonNull(method, "method");
        Objects.requireNonNull(s, "s");
        Objects.requireNonNull(prefix, "prefix");
        if (s.isEmpty()) {
            return s;
        }
        if (n <= 0) {
            return s;
        }

        TransitionTable table = TransitionTable.get();
        State pstate = State.GROUND;
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);

        StringBuilder buf = new StringBuilder();
        int curWidth = 0;
        boolean ignoring = true;

        for (int i = 0; i < bytes.length; ) {
            if (!ignoring) {
                buf.append(new String(bytes, i, bytes.length - i, StandardCharsets.UTF_8));
                break;
            }

            TransitionTable.Transition transition = table.transition(pstate, bytes[i]);
            State state = transition.state();
            Action action = transition.action();

            if (state == State.UTF8) {
                GraphemeCluster.Result result = GraphemeCluster.getFirstGraphemeCluster(bytes, i, method);
                if (result == null) {
                    // Null signals no valid grapheme cluster at this position (malformed UTF-8
                    // or end of data). Skip the byte and continue - this matches Go's behavior
                    // where invalid sequences are skipped rather than causing errors.
                    i++;
                    continue;
                }

                i += result.clusterBytes().length;
                curWidth += result.width();

                if (curWidth > n && ignoring) {
                    ignoring = false;
                    buf.append(prefix);
                }

                if (curWidth > n) {
                    buf.append(result.cluster());
                }

                if (ignoring) {
                    continue;
                }

                pstate = State.GROUND;
                continue;
            }

            switch (action) {
                case PRINT:
                    curWidth++;

                    if (curWidth > n && ignoring) {
                        ignoring = false;
                        buf.append(prefix);
                    }

                    if (ignoring) {
                        i++;
                        continue;
                    }

                    buf.append((char) (bytes[i] & Ansi.BYTE_MASK));
                    break;
                case EXECUTE:
                    if (ignoring) {
                        i++;
                        continue;
                    }
                    buf.append((char) (bytes[i] & Ansi.BYTE_MASK));
                    break;
                default:
                    // ANSI sequences are always preserved
                    buf.append((char) (bytes[i] & Ansi.BYTE_MASK));
                    break;
            }

            i++;
            pstate = state;

            if (curWidth > n && ignoring) {
                ignoring = false;
                buf.append(prefix);
            }
        }

        return buf.toString();
    }
}
