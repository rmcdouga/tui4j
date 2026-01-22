package com.williamcallahan.tui4j.compat.bubbletea.input.key;

import java.util.EnumMap;

/**
 * Mappings from human-readable key aliases to their corresponding KeyType values.
 * <p>
 * Port of charmbracelet/bubbletea key.go key alias constants.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 * <p>
 * Bubble Tea: key.go.
 */
public class KeyAliases {

    /**
     * Creates KeyAliases to keep this component ready for use.
     * <p>
     * Bubble Tea: inputreader_windows.go.
     */
    private KeyAliases() {}

    /** Map from key aliases to their corresponding KeyType. */
    public static final EnumMap<KeyAlias, KeyType> CONTROL_KEY_ALIASES = new EnumMap<>(KeyAlias.class);

    /** Human-readable key alias names. */
    public enum KeyAlias {
        /** Null character (Ctrl+@). */
        KeyNull,
        /** Break (Ctrl+C). */
        KeyBreak,
        /** Enter/Return key. */
        KeyEnter,
        /** Backspace key. */
        KeyBackspace,
        /** Tab key. */
        KeyTab,
        /** Escape key (short form). */
        KeyEsc,
        /** Escape key. */
        KeyEscape,
        /** Ctrl+@ combination. */
        KeyCtrlAt,
        /** Ctrl+A combination. */
        KeyCtrlA,
        /** Ctrl+B combination. */
        KeyCtrlB,
        /** Ctrl+C combination. */
        KeyCtrlC,
        /** Ctrl+D combination. */
        KeyCtrlD,
        /** Ctrl+E combination. */
        KeyCtrlE,
        /** Ctrl+F combination. */
        KeyCtrlF,
        /** Ctrl+G combination. */
        KeyCtrlG,
        /** Ctrl+H combination. */
        KeyCtrlH,
        /** Ctrl+I combination. */
        KeyCtrlI,
        /** Ctrl+J combination. */
        KeyCtrlJ,
        /** Ctrl+K combination. */
        KeyCtrlK,
        /** Ctrl+L combination. */
        KeyCtrlL,
        /** Ctrl+M combination. */
        KeyCtrlM,
        /** Ctrl+N combination. */
        KeyCtrlN,
        /** Ctrl+O combination. */
        KeyCtrlO,
        /** Ctrl+P combination. */
        KeyCtrlP,
        /** Ctrl+Q combination. */
        KeyCtrlQ,
        /** Ctrl+R combination. */
        KeyCtrlR,
        /** Ctrl+S combination. */
        KeyCtrlS,
        /** Ctrl+T combination. */
        KeyCtrlT,
        /** Ctrl+U combination. */
        KeyCtrlU,
        /** Ctrl+V combination. */
        KeyCtrlV,
        /** Ctrl+W combination. */
        KeyCtrlW,
        /** Ctrl+X combination. */
        KeyCtrlX,
        /** Ctrl+Y combination. */
        KeyCtrlY,
        /** Ctrl+Z combination. */
        KeyCtrlZ,
        /** Ctrl+[ combination. */
        KeyCtrlOpenBracket,
        /** Ctrl+\ combination. */
        KeyCtrlBackslash,
        /** Ctrl+] combination. */
        KeyCtrlCloseBracket,
        /** Ctrl+^ combination. */
        KeyCtrlCaret,
        /** Ctrl+_ combination. */
        KeyCtrlUnderscore,
        /** Ctrl+? combination. */
        KeyCtrlQuestionMark
    }

    static {
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyNull, KeyType.keyNUL);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyBreak, KeyType.keyETX);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyEnter, KeyType.keyCR);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyBackspace, KeyType.keyDEL);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyTab, KeyType.keyHT);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyEsc, KeyType.keyESC);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyEscape, KeyType.keyESC);

        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlAt, KeyType.keyNUL);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlA, KeyType.keySOH);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlB, KeyType.keySTX);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlC, KeyType.keyETX);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlD, KeyType.keyEOT);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlE, KeyType.keyENQ);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlF, KeyType.keyACK);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlG, KeyType.keyBEL);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlH, KeyType.keyBS);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlI, KeyType.keyHT);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlJ, KeyType.keyLF);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlK, KeyType.keyVT);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlL, KeyType.keyFF);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlM, KeyType.keyCR);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlN, KeyType.keySO);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlO, KeyType.keySI);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlP, KeyType.keyDLE);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlQ, KeyType.keyDC1);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlR, KeyType.keyDC2);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlS, KeyType.keyDC3);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlT, KeyType.keyDC4);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlU, KeyType.keyNAK);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlV, KeyType.keySYN);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlW, KeyType.keyETB);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlX, KeyType.keyCAN);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlY, KeyType.keyEM);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlZ, KeyType.keySUB);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlOpenBracket, KeyType.keyESC);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlBackslash, KeyType.keyFS);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlCloseBracket, KeyType.keyGS);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlCaret, KeyType.keyRS);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlUnderscore, KeyType.keyUS);
        CONTROL_KEY_ALIASES.put(KeyAlias.KeyCtrlQuestionMark, KeyType.keyDEL);
    }

    /**
     * Looks up the KeyType for a given alias.
     *
     * @param alias the key alias
     * @return the corresponding KeyType
     */
    public static KeyType getKeyType(KeyAlias alias) {
        return CONTROL_KEY_ALIASES.get(alias);
    }
}
