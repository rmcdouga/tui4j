package com.williamcallahan.tui4j.compat.x.ansi.parser;

/**
 * ANSI parser state.
 * Port of github.com/charmbracelet/x/ansi/parser (const.go)
 */
public enum State {
    GROUND,
    CSI_ENTRY,
    CSI_INTERMEDIATE,
    CSI_PARAM,
    DCS_ENTRY,
    DCS_INTERMEDIATE,
    DCS_PARAM,
    DCS_STRING,
    ESCAPE,
    ESCAPE_INTERMEDIATE,
    OSC_STRING,
    SOS_STRING,
    PM_STRING,
    APC_STRING,
    /** UTF-8 state - not part of DEC ANSI standard, used for UTF-8 handling. */
    UTF8;

    /**
     * Returns the state for a stored ordinal.
     *
     * @param ordinal ordinal value
     * @return matching state
     */
    public static State fromOrdinal(int ordinal) {
        return values()[ordinal];
    }
}
