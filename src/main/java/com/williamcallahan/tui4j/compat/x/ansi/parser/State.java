package com.williamcallahan.tui4j.compat.x.ansi.parser;

/**
 * ANSI parser state.
 * Port of github.com/charmbracelet/x/ansi/parser (const.go)
 */
public enum State {
    /** Ground state (default text rendering). */
    GROUND,
    /** Entering a CSI sequence. */
    CSI_ENTRY,
    /** CSI intermediate bytes. */
    CSI_INTERMEDIATE,
    /** CSI parameter bytes. */
    CSI_PARAM,
    /** Entering a DCS sequence. */
    DCS_ENTRY,
    /** DCS intermediate bytes. */
    DCS_INTERMEDIATE,
    /** DCS parameter bytes. */
    DCS_PARAM,
    /** DCS string data. */
    DCS_STRING,
    /** ESC sequence entry. */
    ESCAPE,
    /** ESC intermediate bytes. */
    ESCAPE_INTERMEDIATE,
    /** OSC string data. */
    OSC_STRING,
    /** SOS string data. */
    SOS_STRING,
    /** PM string data. */
    PM_STRING,
    /** APC string data. */
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
