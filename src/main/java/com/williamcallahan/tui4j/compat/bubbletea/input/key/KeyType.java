package com.williamcallahan.tui4j.compat.bubbletea.input.key;

/**
 * Port of Bubble Tea key type.
 * Bubble Tea: bubbletea/key.go
 */
public enum KeyType {
    /** Null (NUL, \0). */
    keyNUL(0),
    /** Start of heading. */
    keySOH(1),
    /** Start of text. */
    keySTX(2),
    /** End of text (Ctrl+C). */
    keyETX(3),
    /** End of transmission. */
    keyEOT(4),
    /** Enquiry. */
    keyENQ(5),
    /** Acknowledge. */
    keyACK(6),
    /** Bell (\a). */
    keyBEL(7),
    /** Backspace. */
    keyBS(8),
    /** Horizontal tab (\t). */
    keyHT(9),
    /** Line feed (\n). */
    keyLF(10),
    /** Vertical tab (\v). */
    keyVT(11),
    /** Form feed (\f). */
    keyFF(12),
    /** Carriage return (\r). */
    keyCR(13),
    /** Shift out. */
    keySO(14),
    /** Shift in. */
    keySI(15),
    /** Data link escape. */
    keyDLE(16),
    /** Device control one. */
    keyDC1(17),
    /** Device control two. */
    keyDC2(18),
    /** Device control three. */
    keyDC3(19),
    /** Device control four. */
    keyDC4(20),
    /** Negative acknowledge. */
    keyNAK(21),
    /** Synchronous idle. */
    keySYN(22),
    /** End of transmission block. */
    keyETB(23),
    /** Cancel. */
    keyCAN(24),
    /** End of medium. */
    keyEM(25),
    /** Substitute. */
    keySUB(26),
    /** Escape. */
    keyESC(27),
    /** File separator. */
    keyFS(28),
    /** Group separator. */
    keyGS(29),
    /** Record separator. */
    keyRS(30),
    /** Unit separator. */
    keyUS(31),
    /** Delete (often backspace on terminals). */
    keyDEL(127),

    /** Rune input. */
    KeyRunes(-1),
    /** Up arrow. */
    KeyUp(-2),
    /** Down arrow. */
    KeyDown(-3),
    /** Right arrow. */
    KeyRight(-4),
    /** Left arrow. */
    KeyLeft(-5),
    /** Shift+Tab. */
    KeyShiftTab(-6),
    /** Home. */
    KeyHome(-7),
    /** End. */
    KeyEnd(-8),
    /** Page up. */
    KeyPgUp(-9),
    /** Page down. */
    KeyPgDown(-10),
    /** Ctrl+Page up. */
    KeyCtrlPgUp(-11),
    /** Ctrl+Page down. */
    KeyCtrlPgDown(-12),
    /** Delete. */
    KeyDelete(-13),
    /** Insert. */
    KeyInsert(-14),
    /** Space. */
    KeySpace(-15),
    /** Ctrl+Up arrow. */
    KeyCtrlUp(-16),
    /** Ctrl+Down arrow. */
    KeyCtrlDown(-17),
    /** Ctrl+Right arrow. */
    KeyCtrlRight(-18),
    /** Ctrl+Left arrow. */
    KeyCtrlLeft(-19),
    /** Ctrl+Home. */
    KeyCtrlHome(-20),
    /** Ctrl+End. */
    KeyCtrlEnd(-21),
    /** Shift+Up arrow. */
    KeyShiftUp(-22),
    /** Shift+Down arrow. */
    KeyShiftDown(-23),
    /** Shift+Right arrow. */
    KeyShiftRight(-24),
    /** Shift+Left arrow. */
    KeyShiftLeft(-25),
    /** Shift+Home. */
    KeyShiftHome(-26),
    /** Shift+End. */
    KeyShiftEnd(-27),
    /** Ctrl+Shift+Up arrow. */
    KeyCtrlShiftUp(-28),
    /** Ctrl+Shift+Down arrow. */
    KeyCtrlShiftDown(-29),
    /** Ctrl+Shift+Left arrow. */
    KeyCtrlShiftLeft(-30),
    /** Ctrl+Shift+Right arrow. */
    KeyCtrlShiftRight(-31),
    /** Ctrl+Shift+Home. */
    KeyCtrlShiftHome(-32),
    /** Ctrl+Shift+End. */
    KeyCtrlShiftEnd(-33),
    /** Function key F1. */
    KeyF1(-34),
    /** Function key F2. */
    KeyF2(-35),
    /** Function key F3. */
    KeyF3(-36),
    /** Function key F4. */
    KeyF4(-37),
    /** Function key F5. */
    KeyF5(-38),
    /** Function key F6. */
    KeyF6(-39),
    /** Function key F7. */
    KeyF7(-40),
    /** Function key F8. */
    KeyF8(-41),
    /** Function key F9. */
    KeyF9(-42),
    /** Function key F10. */
    KeyF10(-43),
    /** Function key F11. */
    KeyF11(-44),
    /** Function key F12. */
    KeyF12(-45),
    /** Function key F13. */
    KeyF13(-46),
    /** Function key F14. */
    KeyF14(-47),
    /** Function key F15. */
    KeyF15(-48),
    /** Function key F16. */
    KeyF16(-49),
    /** Function key F17. */
    KeyF17(-50),
    /** Function key F18. */
    KeyF18(-51),
    /** Function key F19. */
    KeyF19(-52),
    /** Function key F20. */
    KeyF20(-53);

    private final int code;

    /**
     * Creates a key type with its numeric code.
     *
     * @param code key code value
     */
    KeyType(int code) {
        this.code = code;
    }

    /**
     * Returns the numeric key code.
     *
     * @return key code
     */
    public int getCode() {
        return code;
    }

    /**
     * Resolves a key type by numeric code.
     *
     * @param code key code value
     * @return resolved key type
     * @throws IllegalArgumentException when the code is unknown
     */
    public static KeyType fromCode(int code) {
        for (KeyType key : values()) {
            if (key.code == code) {
                return key;
            }
        }
        throw new IllegalArgumentException("No KeyType with code " + code);
    }
}
