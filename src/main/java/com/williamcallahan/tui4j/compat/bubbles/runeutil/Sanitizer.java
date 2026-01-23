package com.williamcallahan.tui4j.compat.bubbles.runeutil;

import java.util.function.Consumer;

/**
 * Port of Bubbles sanitizer.
 * Bubbles: bubbles/runeutil/sanitizer.go
 */
public class Sanitizer {

    private String replaceNewLine;
    private String replaceTab;

    /**
     * Creates a sanitizer with the given options.
     *
     * @param options configuration options
     */
    @SafeVarargs
    public Sanitizer(Consumer<Sanitizer>... options) {
        this.replaceNewLine = "\n";
        this.replaceTab = "    ";
        for (Consumer<Sanitizer> option : options) {
            option.accept(this);
        }
    }

    /**
     * Sanitizes the input character array.
     *
     * @param runes input characters
     * @return sanitized characters
     */
    public char[] sanitize(char[] runes) {
        StringBuilder result = new StringBuilder(runes.length);
        boolean copied = false;

        for (int src = 0; src < runes.length; src++) {
            char r = runes[src];
            switch (r) {
                case '\r':
                case '\n':
                    if (result.length() + replaceNewLine.length() > src && !copied) {
                        result.ensureCapacity(runes.length + replaceNewLine.length());
                        copied = true;
                    }
                    result.append(replaceNewLine);
                    break;
                case '\t':
                    if (result.length() + replaceTab.length() > src && !copied) {
                        result.ensureCapacity(runes.length + replaceTab.length());
                        copied = true;
                    }
                    result.append(replaceTab);
                    break;
                default:
                    if (isControlChar(r)) {
                        continue;
                    }
                    result.append(r);
                    break;
            }
        }
        return result.toString().toCharArray();
    }

    /**
     * Returns an option that replaces tabs with the given string.
     *
     * @param tabReplacement replacement string for tabs
     * @return configuration option
     */
    public static Consumer<Sanitizer> replaceTabs(String tabReplacement) {
        return sanitizer -> sanitizer.replaceTab = tabReplacement;
    }

    /**
     * Returns an option that replaces newlines with the given string.
     *
     * @param newlineReplacement replacement string for newlines
     * @return configuration option
     */
    public static Consumer<Sanitizer> replaceNewlines(String newlineReplacement) {
        return sanitizer -> sanitizer.replaceNewLine = newlineReplacement;
    }

    /**
     * Checks if a character is a control character that should be removed.
     * Control characters (C0, DEL, C1) corrupt terminal output and should be filtered.
     *
     * @param c character to check
     * @return true if the character is a control character
     */
    private static boolean isControlChar(char c) {
        // C0 controls (0x00-0x1F) except handled ones, DEL (0x7F), C1 controls (0x80-0x9F)
        return (c < 0x20 && c != '\t' && c != '\n' && c != '\r') ||
                c == 0x7F ||
                (c >= 0x80 && c <= 0x9F);
    }

}
