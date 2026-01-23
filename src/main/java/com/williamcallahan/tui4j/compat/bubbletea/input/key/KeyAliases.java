package com.williamcallahan.tui4j.compat.bubbletea.input.key;

import java.util.EnumMap;

/**
 * Port of Bubble Tea key aliases.
 * Upstream: github.com/charmbracelet/bubbletea/key.go
 */
public class KeyAliases {

    /**
     * Creates a key alias registry.
     */
    public KeyAliases() {
    }

    /**
     * Port of Bubble Tea key alias mappings.
     * Upstream: github.com/charmbracelet/bubbletea/key.go
     */
    public static final EnumMap<KeyAlias, KeyType> CONTROL_KEY_ALIASES = new EnumMap<>(KeyAlias.class);

    /**
     * Port of Bubble Tea key alias names.
     * Upstream: github.com/charmbracelet/bubbletea/key.go
     */
    public enum KeyAlias {
        /** Alias for NUL (Ctrl+@). */
        KeyNull,
        /** Alias for ETX (Break). */
        KeyBreak,
        /** Alias for carriage return. */
        KeyEnter,
        /** Alias for backspace. */
        KeyBackspace,
        /** Alias for horizontal tab. */
        KeyTab,
        /** Alias for ESC. */
        KeyEsc,
        /** Alias for ESC. */
        KeyEscape,
        /** Alias for Ctrl+@. */
        KeyCtrlAt,
        /** Alias for Ctrl+A. */
        KeyCtrlA,
        /** Alias for Ctrl+B. */
        KeyCtrlB,
        /** Alias for Ctrl+C. */
        KeyCtrlC,
        /** Alias for Ctrl+D. */
        KeyCtrlD,
        /** Alias for Ctrl+E. */
        KeyCtrlE,
        /** Alias for Ctrl+F. */
        KeyCtrlF,
        /** Alias for Ctrl+G. */
        KeyCtrlG,
        /** Alias for Ctrl+H. */
        KeyCtrlH,
        /** Alias for Ctrl+I. */
        KeyCtrlI,
        /** Alias for Ctrl+J. */
        KeyCtrlJ,
        /** Alias for Ctrl+K. */
        KeyCtrlK,
        /** Alias for Ctrl+L. */
        KeyCtrlL,
        /** Alias for Ctrl+M. */
        KeyCtrlM,
        /** Alias for Ctrl+N. */
        KeyCtrlN,
        /** Alias for Ctrl+O. */
        KeyCtrlO,
        /** Alias for Ctrl+P. */
        KeyCtrlP,
        /** Alias for Ctrl+Q. */
        KeyCtrlQ,
        /** Alias for Ctrl+R. */
        KeyCtrlR,
        /** Alias for Ctrl+S. */
        KeyCtrlS,
        /** Alias for Ctrl+T. */
        KeyCtrlT,
        /** Alias for Ctrl+U. */
        KeyCtrlU,
        /** Alias for Ctrl+V. */
        KeyCtrlV,
        /** Alias for Ctrl+W. */
        KeyCtrlW,
        /** Alias for Ctrl+X. */
        KeyCtrlX,
        /** Alias for Ctrl+Y. */
        KeyCtrlY,
        /** Alias for Ctrl+Z. */
        KeyCtrlZ,
        /** Alias for Ctrl+[. */
        KeyCtrlOpenBracket,
        /** Alias for Ctrl+\\. */
        KeyCtrlBackslash,
        /** Alias for Ctrl+]. */
        KeyCtrlCloseBracket,
        /** Alias for Ctrl+^. */
        KeyCtrlCaret,
        /** Alias for Ctrl+_. */
        KeyCtrlUnderscore,
        /** Alias for Ctrl+?. */
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
     * Returns the key type mapped to the alias.
     *
     * @param alias alias to look up
     * @return mapped key type
     */
    public static KeyType getKeyType(KeyAlias alias) {
        return CONTROL_KEY_ALIASES.get(alias);
    }
}
