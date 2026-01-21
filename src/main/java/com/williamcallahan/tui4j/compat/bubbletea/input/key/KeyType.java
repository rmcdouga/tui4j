package com.williamcallahan.tui4j.compat.bubbletea.input.key;

/**
 * Port of Bubble Tea key type.
 * Bubble Tea: bubbletea/key.go
 */
public enum KeyType {
    /** Null character. */
    keyNUL(0),
    /** Start of Heading. */
    keySOH(1),
    /** Start of Text. */
    keySTX(2),
    /** End of Text. */
    keyETX(3),
    /** End of Transmission. */
    keyEOT(4),
    /** Enquiry. */
    keyENQ(5),
    /** Acknowledge. */
    keyACK(6),
    /** Bell. */
    keyBEL(7),
    /** Backspace. */
    keyBS(8),
    /** Horizontal Tab. */
    keyHT(9),
    /** Line Feed. */
    keyLF(10),
    /** Vertical Tab. */
    keyVT(11),
    /** Form Feed. */
    keyFF(12),
    /** Carriage Return. */
    keyCR(13),
    /** Shift Out. */
    keySO(14),
    /** Shift In. */
    keySI(15),
    /** Data Link Escape. */
    keyDLE(16),
    /** Device Control 1. */
    keyDC1(17),
    /** Device Control 2. */
    keyDC2(18),
    /** Device Control 3. */
    keyDC3(19),
    /** Device Control 4. */
    keyDC4(20),
    /** Negative Acknowledge. */
    keyNAK(21),
    /** Synchronous Idle. */
    keySYN(22),
    /** End of Transmission Block. */
    keyETB(23),
    /** Cancel. */
    keyCAN(24),
    /** End of Medium. */
    keyEM(25),
    /** Substitute. */
    keySUB(26),
    /** Escape. */
    keyESC(27),
    /** File Separator. */
    keyFS(28),
    /** Group Separator. */
    keyGS(29),
    /** Record Separator. */
    keyRS(30),
    /** Unit Separator. */
    keyUS(31),
    /** Delete. */
    keyDEL(127),

    /** Regular runes (text input). */
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
    /** Page Up. */
    KeyPgUp(-9),
    /** Page Down. */
    KeyPgDown(-10),
    /** Ctrl+Page Up. */
    KeyCtrlPgUp(-11),
    /** Ctrl+Page Down. */
    KeyCtrlPgDown(-12),
    /** Delete key. */
    KeyDelete(-13),
    /** Insert key. */
    KeyInsert(-14),
    /** Space key. */
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
    /** F1 key. */
    KeyF1(-34),
    /** F2 key. */
    KeyF2(-35),
    /** F3 key. */
    KeyF3(-36),
    /** F4 key. */
    KeyF4(-37),
    /** F5 key. */
    KeyF5(-38),
    /** F6 key. */
    KeyF6(-39),
    /** F7 key. */
    KeyF7(-40),
    /** F8 key. */
    KeyF8(-41),
    /** F9 key. */
    KeyF9(-42),
    /** F10 key. */
    KeyF10(-43),
    /** F11 key. */
    KeyF11(-44),
    /** F12 key. */
    KeyF12(-45),
    /** F13 key. */
    KeyF13(-46),
    /** F14 key. */
    KeyF14(-47),
    /** F15 key. */
    KeyF15(-48),
    /** F16 key. */
    KeyF16(-49),
    /** F17 key. */
    KeyF17(-50),
    /** F18 key. */
    KeyF18(-51),
    /** F19 key. */
    KeyF19(-52),
    /** F20 key. */
    KeyF20(-53);

    private final int code;

    KeyType(int code) {
        this.code = code;
    }

    /**
     * Gets the integer code for this key type.
     *
     * @return the key code
     */
    public int getCode() {
        return code;
    }

    /**
     * Returns the KeyType for the given code.
     *
     * @param code the integer code
     * @return the matching KeyType
     * @throws IllegalArgumentException if no KeyType matches the code
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
