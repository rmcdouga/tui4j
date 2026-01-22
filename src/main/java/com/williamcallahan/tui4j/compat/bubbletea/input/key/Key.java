package com.williamcallahan.tui4j.compat.bubbletea.input.key;

/**
 * Port of Bubble Tea key.
 * Upstream: github.com/charmbracelet/bubbletea/key.go
 *
 * @param type key type
 * @param runes rune sequence for {@code KeyRunes}
 * @param alt whether the Alt modifier is set
 * @param paste whether this represents a paste sequence
 */
public record Key(KeyType type, char[] runes, boolean alt, boolean paste) {

    /**
     * Creates a key with the provided type.
     *
     * @param type key type
     */
    public Key(KeyType type) {
        this(type, new char[]{}, false, false);
    }

    /**
     * Creates a key with runes.
     *
     * @param type key type
     * @param runes rune sequence
     */
    public Key(KeyType type, char[] runes) {
        this(type, runes, false, false);
    }

    /**
     * Creates a key with an Alt modifier.
     *
     * @param type key type
     * @param alt whether Alt is pressed
     */
    public Key(KeyType type, boolean alt) {
        this(type, new char[]{}, alt, false);
    }

    /**
     * Creates a key with runes and modifier flags.
     *
     * @param type key type
     * @param runes rune sequence
     * @param alt whether Alt is pressed
     */
    public Key(KeyType type, char[] runes, boolean alt) {
        this(type, runes, alt, false);
    }

    /**
     * Returns the display name for this key.
     *
     * @return key display string
     */
    @Override
    public String toString() {
        String keyName = KeyNames.getKeyName(type);
        StringBuilder builder = new StringBuilder();

        if (alt) {
            builder.append("alt+");
        }

        if (type == KeyType.KeyRunes) {
            if (paste) {
                builder.append('[');
            }
            builder.append(new String(runes));
            if (paste) {
                builder.append(']');
            }
            return builder.toString();
        } else if (keyName != null) {
            builder.append(keyName);
            return builder.toString();
        }

        return builder.toString();
    }
}
