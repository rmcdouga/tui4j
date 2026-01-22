package com.williamcallahan.tui4j.ansi;

/**
 * ANSI parser state for the tui4j.ansi transition table.
 * This mirrors the compat parser states.
 * For the full compat parser, see {@link com.williamcallahan.tui4j.compat.x.ansi.parser.State}.
 *
 * @deprecated Deprecated in tui4j in favor of the full compat parser; use
 *             {@link com.williamcallahan.tui4j.compat.x.ansi.parser.State} instead.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public enum State {
    /** Initial state; normal text processing. */
    GROUND,
    /** Control Sequence Introducer entry state. */
    CSI_ENTRY,
    /** CSI intermediate byte collection state. */
    CSI_INTERMEDIATE,
    /** CSI parameter byte collection state. */
    CSI_PARAM,
    /** Device Control String entry state. */
    DCS_ENTRY,
    /** DCS intermediate byte collection state. */
    DCS_INTERMEDIATE,
    /** DCS parameter byte collection state. */
    DCS_PARAM,
    /** DCS passthrough string state. */
    DCS_STRING,
    /** Escape sequence entry state. */
    ESCAPE,
    /** Escape intermediate byte collection state. */
    ESCAPE_INTERMEDIATE,
    /** Operating System Command string state. */
    OSC_STRING,
    /** Start of String state. */
    SOS_STRING,
    /** Privacy Message string state. */
    PM_STRING,
    /** Application Program Command string state. */
    APC_STRING,
    /** UTF-8 multibyte sequence state; not part of DEC ANSI standard. */
    UTF8
}
