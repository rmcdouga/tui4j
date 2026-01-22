package com.williamcallahan.tui4j.ansi;

/**
 * ANSI parser action for the tui4j.ansi transition table.
 * This is a simplified action set used by the native tui4j.ansi package.
 * For the full compat parser, see {@link com.williamcallahan.tui4j.compat.x.ansi.parser.Action}.
 *
 */
public enum Action {
    /** No-op / Ignore input. */
    NONE,
    /** Reset parser state. */
    CLEAR,
    /** Collect intermediate bytes. */
    COLLECT,
    /** Collect marker/prefix bytes. */
    MARKER,
    /** Dispatch a control sequence. */
    DISPATCH,
    /** Execute a control character. */
    EXECUTE,
    /** Start of a data string. */
    START,
    /** Put into the data string. */
    PUT,
    /** Collect parameter bytes. */
    PARAM,
    /** Print a glyph. */
    PRINT
}
