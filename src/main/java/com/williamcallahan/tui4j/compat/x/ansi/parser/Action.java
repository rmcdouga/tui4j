package com.williamcallahan.tui4j.compat.x.ansi.parser;

/**
 * ANSI parser action.
 * Port of github.com/charmbracelet/x/ansi/parser (const.go)
 */
public enum Action {
    /** No-op / Ignore input. */
    NONE,
    /** Reset parser state. */
    CLEAR,
    /** Collect intermediate bytes. */
    COLLECT,
    /** Collect prefix/marker bytes. */
    PREFIX,
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
    PRINT;

    /** Alias for NONE - ignore input. */
    public static final Action IGNORE = NONE;

    /**
     * Returns the action for a stored ordinal.
     *
     * @param ordinal ordinal value
     * @return matching action
     */
    public static Action fromOrdinal(int ordinal) {
        return values()[ordinal];
    }
}
