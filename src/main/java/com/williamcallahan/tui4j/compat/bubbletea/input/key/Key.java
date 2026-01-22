package com.williamcallahan.tui4j.compat.bubbletea.input.key;

/**
 * Represents a keyboard key press event.
 * <p>
 * Port of charmbracelet/bubbletea key.go Key type.
 *
 * @param type key type
 * @param runes rune sequence for {@code KeyRunes}
 * @param alt whether the Alt modifier is set
 * @param paste whether this represents a paste sequence
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/key.go">bubbletea/key.go</a>
 * <p>
 * Bubble Tea: key.go.
 */
public record Key(KeyType type, char[] runes, boolean alt, boolean paste) {

    /**
     * Creates a key with just a type.
     *
     * @param type the key type
     */
    public Key(KeyType type) {
        this(type, new char[]{}, false, false);
    }

    /**
     * Creates a key with type and runes.
     *
     * @param type the key type
     * @param runes the character runes
     */
    public Key(KeyType type, char[] runes) {
        this(type, runes, false, false);
    }

    /**
     * Creates a key with type and alt modifier.
     *
     * @param type the key type
     * @param alt whether alt is pressed
     */
    public Key(KeyType type, boolean alt) {
        this(type, new char[]{}, alt, false);
    }

    /**
     * Creates a key with type, runes, and alt modifier.
     *
     * @param type the key type
     * @param runes the character runes
     * @param alt whether alt is pressed
     */
    public Key(KeyType type, char[] runes, boolean alt) {
        this(type, runes, alt, false);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
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
