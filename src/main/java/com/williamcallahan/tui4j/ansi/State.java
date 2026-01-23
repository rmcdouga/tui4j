package com.williamcallahan.tui4j.ansi;

/**
 * ANSI parser state.
 * tui4j: src/main/java/com/williamcallahan/tui4j/ansi/State.java
 */
public enum State {
    /** Ground state (normal text). */
    GROUND,
    /** CSI entry (Control Sequence Introducer). */
    CSI_ENTRY,
    /** CSI intermediate bytes. */
    CSI_INTERMEDIATE,
    /** CSI parameter bytes. */
    CSI_PARAM,
    /** DCS entry (Device Control String). */
    DCS_ENTRY,
    /** DCS intermediate bytes. */
    DCS_INTERMEDIATE,
    /** DCS parameter bytes. */
    DCS_PARAM,
    /** DCS string passthrough. */
    DCS_STRING,
    /** Escape state (after ESC). */
    ESCAPE,
    /** Escape intermediate bytes. */
    ESCAPE_INTERMEDIATE,
    /** OSC string (Operating System Command). */
    OSC_STRING,
    /** SOS string (Start of String). */
    SOS_STRING,
    /** PM string (Privacy Message). */
    PM_STRING,
    /** APC string (Application Program Command). */
    APC_STRING,
    /** UTF-8 multibyte state. */
    UTF8;

    /**
     * Returns the state for the given ordinal.
     *
     * @param ordinal ordinal value
     * @return corresponding state
     */
    public static State fromOrdinal(int ordinal) {
        State[] values = values();
        if (ordinal < 0 || ordinal >= values.length) {
            throw new IllegalArgumentException(
                "Invalid State ordinal: " + ordinal
            );
        }
        return values[ordinal];
    }
}
