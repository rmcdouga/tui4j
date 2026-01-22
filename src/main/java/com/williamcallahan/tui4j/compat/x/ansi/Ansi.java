package com.williamcallahan.tui4j.compat.x.ansi;

/**
 * ANSI control character constants.
 * Port of github.com/charmbracelet/x/ansi (c0.go, c1.go)
 */
public final class Ansi {
    private Ansi() {}

    // ─────────────────────────────────────────────────────────────────────────────
    // C0 control characters (0x00-0x1F) as defined in ISO 646 (ASCII)
    // ─────────────────────────────────────────────────────────────────────────────

    /** Null character (Caret: ^@, Char: \0). */
    public static final byte NUL = 0x00;
    /** Start of heading character (Caret: ^A). */
    public static final byte SOH = 0x01;
    /** Start of text character (Caret: ^B). */
    public static final byte STX = 0x02;
    /** End of text character (Caret: ^C). */
    public static final byte ETX = 0x03;
    /** End of transmission character (Caret: ^D). */
    public static final byte EOT = 0x04;
    /** Enquiry character (Caret: ^E). */
    public static final byte ENQ = 0x05;
    /** Acknowledge character (Caret: ^F). */
    public static final byte ACK = 0x06;
    /** Bell character (Caret: ^G, Char: \a). */
    public static final byte BEL = 0x07;
    /** Backspace character (Caret: ^H, Char: \b). */
    public static final byte BS = 0x08;
    /** Horizontal tab character (Caret: ^I, Char: \t). */
    public static final byte HT = 0x09;
    /** Line feed character (Caret: ^J, Char: \n). */
    public static final byte LF = 0x0A;
    /** Vertical tab character (Caret: ^K, Char: \v). */
    public static final byte VT = 0x0B;
    /** Form feed character (Caret: ^L, Char: \f). */
    public static final byte FF = 0x0C;
    /** Carriage return character (Caret: ^M, Char: \r). */
    public static final byte CR = 0x0D;
    /** Shift out character (Caret: ^N). */
    public static final byte SO = 0x0E;
    /** Shift in character (Caret: ^O). */
    public static final byte SI = 0x0F;
    /** Data link escape character (Caret: ^P). */
    public static final byte DLE = 0x10;
    /** Device control 1 character (Caret: ^Q). */
    public static final byte DC1 = 0x11;
    /** Device control 2 character (Caret: ^R). */
    public static final byte DC2 = 0x12;
    /** Device control 3 character (Caret: ^S). */
    public static final byte DC3 = 0x13;
    /** Device control 4 character (Caret: ^T). */
    public static final byte DC4 = 0x14;
    /** Negative acknowledge character (Caret: ^U). */
    public static final byte NAK = 0x15;
    /** Synchronous idle character (Caret: ^V). */
    public static final byte SYN = 0x16;
    /** End of transmission block character (Caret: ^W). */
    public static final byte ETB = 0x17;
    /** Cancel character (Caret: ^X). */
    public static final byte CAN = 0x18;
    /** End of medium character (Caret: ^Y). */
    public static final byte EM = 0x19;
    /** Substitute character (Caret: ^Z). */
    public static final byte SUB = 0x1A;
    /** Escape character (Caret: ^[, Char: \e). */
    public static final byte ESC = 0x1B;
    /** File separator character (Caret: ^\). */
    public static final byte FS = 0x1C;
    /** Group separator character (Caret: ^]). */
    public static final byte GS = 0x1D;
    /** Record separator character (Caret: ^^). */
    public static final byte RS = 0x1E;
    /** Unit separator character (Caret: ^_). */
    public static final byte US = 0x1F;
    /** Delete character (0x7F). */
    public static final byte DEL = 0x7F;

    /** Locking shift 0 character, alias for SI. */
    public static final byte LS0 = SI;
    /** Locking shift 1 character, alias for SO. */
    public static final byte LS1 = SO;

    // Char versions for convenience
    /** Escape character as char. */
    public static final char ESC_CHAR = '\u001B';
    /** Bell character as char. */
    public static final char BEL_CHAR = '\u0007';

    // ─────────────────────────────────────────────────────────────────────────────
    // C1 control characters (0x80-0x9F) as defined in ISO 6429 (ECMA-48)
    // ─────────────────────────────────────────────────────────────────────────────

    /** Padding character. */
    public static final byte PAD = (byte) 0x80;
    /** High octet preset character. */
    public static final byte HOP = (byte) 0x81;
    /** Break permitted here character. */
    public static final byte BPH = (byte) 0x82;
    /** No break here character. */
    public static final byte NBH = (byte) 0x83;
    /** Index character. */
    public static final byte IND = (byte) 0x84;
    /** Next line character. */
    public static final byte NEL = (byte) 0x85;
    /** Start of selected area character. */
    public static final byte SSA = (byte) 0x86;
    /** End of selected area character. */
    public static final byte ESA = (byte) 0x87;
    /** Horizontal tab set character. */
    public static final byte HTS = (byte) 0x88;
    /** Horizontal tab with justification character. */
    public static final byte HTJ = (byte) 0x89;
    /** Vertical tab set character. */
    public static final byte VTS = (byte) 0x8A;
    /** Partial line forward character. */
    public static final byte PLD = (byte) 0x8B;
    /** Partial line backward character. */
    public static final byte PLU = (byte) 0x8C;
    /** Reverse index character. */
    public static final byte RI = (byte) 0x8D;
    /** Single shift 2 character. */
    public static final byte SS2 = (byte) 0x8E;
    /** Single shift 3 character. */
    public static final byte SS3 = (byte) 0x8F;
    /** Device control string character. */
    public static final byte DCS = (byte) 0x90;
    /** Private use 1 character. */
    public static final byte PU1 = (byte) 0x91;
    /** Private use 2 character. */
    public static final byte PU2 = (byte) 0x92;
    /** Set transmit state character. */
    public static final byte STS = (byte) 0x93;
    /** Cancel character (C1). */
    public static final byte CCH = (byte) 0x94;
    /** Message waiting character. */
    public static final byte MW = (byte) 0x95;
    /** Start of guarded area character. */
    public static final byte SPA = (byte) 0x96;
    /** End of guarded area character. */
    public static final byte EPA = (byte) 0x97;
    /** Start of string character. */
    public static final byte SOS = (byte) 0x98;
    /** Single graphic character introducer character. */
    public static final byte SGCI = (byte) 0x99;
    /** Single character introducer character. */
    public static final byte SCI = (byte) 0x9A;
    /** Control sequence introducer character. */
    public static final byte CSI = (byte) 0x9B;
    /** String terminator character. */
    public static final byte ST = (byte) 0x9C;
    /** Operating system command character. */
    public static final byte OSC = (byte) 0x9D;
    /** Privacy message character. */
    public static final byte PM = (byte) 0x9E;
    /** Application program command character. */
    public static final byte APC = (byte) 0x9F;

    // ─────────────────────────────────────────────────────────────────────────────
    // Zero-width Unicode characters
    // ─────────────────────────────────────────────────────────────────────────────

    /** Zero Width Space (U+200B). */
    public static final int ZERO_WIDTH_SPACE = 0x200B;
    /** Zero Width Non-Joiner (U+200C). */
    public static final int ZERO_WIDTH_NON_JOINER = 0x200C;
    /** Zero Width Joiner (U+200D). */
    public static final int ZERO_WIDTH_JOINER = 0x200D;
    /** Zero Width No-Break Space / Byte Order Mark (U+FEFF). */
    public static final int ZERO_WIDTH_NO_BREAK_SPACE = 0xFEFF;

    /** Zero Width Joiner as char for string operations. */
    public static final char ZWJ_CHAR = '\u200D';

    // ─────────────────────────────────────────────────────────────────────────────
    // UTF-8 byte length thresholds
    // ─────────────────────────────────────────────────────────────────────────────

    /** Threshold for 1-byte ASCII characters (less than 0x80). */
    public static final int UTF8_1BYTE_MAX = 0x80;
    /** Threshold for 2-byte UTF-8 sequences (less than 0xE0). */
    public static final int UTF8_2BYTE_MAX = 0xE0;
    /** Threshold for 3-byte UTF-8 sequences (less than 0xF0). */
    public static final int UTF8_3BYTE_MAX = 0xF0;
    /** Maximum valid UTF-8 4-byte sequence start (less than 0xF5). */
    public static final int UTF8_4BYTE_MAX = 0xF5;

    /** Byte mask for extracting unsigned value from signed byte. */
    public static final int BYTE_MASK = 0xFF;

    /**
     * Returns the expected byte length of a UTF-8 sequence given its first byte.
     * <p>
     * This function returns the EXPECTED length based on the first byte only.
     * It does NOT validate the full sequence - that is done by the UTF-8 decoder
     * (e.g., {@code new String(bytes, StandardCharsets.UTF_8)}).
     * <p>
     * Byte ranges and return values:
     * <ul>
     *   <li>0x00-0x7F: returns 1 (ASCII)</li>
     *   <li>0xC0-0xDF: returns 2 (2-byte sequence start)</li>
     *   <li>0xE0-0xEF: returns 3 (3-byte sequence start)</li>
     *   <li>0xF0-0xF7: returns 4 (4-byte sequence start)</li>
     *   <li>otherwise: returns -1 (invalid start byte)</li>
     * </ul>
     *
     * @param firstByte the first byte of a UTF-8 sequence
     * @return the expected byte length (1-4)
     */
    public static int utf8ByteLength(byte firstByte) {
        int unsigned = firstByte & BYTE_MASK;
        if (unsigned <= 0x7F) {
            return 1;
        }
        if (unsigned >= 0xC0 && unsigned <= 0xDF) {
            return 2;
        }
        if (unsigned >= 0xE0 && unsigned <= 0xEF) {
            return 3;
        }
        if (unsigned >= 0xF0 && unsigned <= 0xF7) {
            return 4;
        }
        return -1;
    }
}
