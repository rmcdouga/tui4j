package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color;

import org.jline.utils.AttributedCharSequence;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/lipgloss/color/ColorProfile.java}.
 * <p>
 * Lip Gloss: color.go.
 *
 */
public enum ColorProfile {
    /** TrueColor, 24-bit color profile. */
    TrueColor(AttributedCharSequence.TRUE_COLORS),
    /** ANSI256, 8-bit color profile. */
    ANSI256(256),
    /** ANSI, 4-bit color profile. */
    ANSI(16),
    /** Ascii, uncolored profile. */
    Ascii(1);

    private final int colorsCount;

    /**
     * Creates ColorProfile to keep this component ready for use.
     *
     * @param colorsCount colors count
     */
    ColorProfile(int colorsCount) {
        this.colorsCount = colorsCount;
    }

    /**
     * Creates a terminal color from a string. Valid inputs are hex colors or ANSI codes.
     *
     * @param color color string
     * @return terminal color, or null when parsing fails
     */
    public TerminalColor color(String color) {
        if (color == null || color.isBlank()) {
            return null;
        }
        TerminalColor terminalColor;

        if (color.startsWith("#")) {
            terminalColor = new RGBColor(color);
        } else {
            try {
                int colorCode = Integer.parseInt(color);
                if (colorCode < 16) {
                    terminalColor = new ANSIColor(colorCode);
                } else {
                    terminalColor = new ANSI256Color(colorCode);
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }

        return convert(terminalColor);
    }

    /**
     * Transforms the given terminal color into a compatible color for this profile.
     *
     * @param terminalColor terminal color
     * @return compatible terminal color
     */
    public TerminalColor convert(TerminalColor terminalColor) {
        if (this == Ascii) {
            return new NoColor();
        }

        if (terminalColor instanceof ANSIColor) {
            return terminalColor;
        } else if (terminalColor instanceof ANSI256Color ansi256Color) {
            if (this == ANSI) {
                return ansi256Color.toANSIColor();
            }
            return terminalColor;
        } else if (terminalColor instanceof RGBColor rgbColor) {
            if (this != TrueColor) {
                ANSI256Color ansi256Color = rgbColor.toANSI256Color();
                if (this == ANSI) {
                    return ansi256Color.toANSIColor();
                }
                return ansi256Color;
            }
            return terminalColor;
        }
        return terminalColor;
    }

    /**
     * Returns the number of colors available for this profile.
     *
     * @return color count
     */
    public int colorsCount() {
        return colorsCount;
    }

    /**
     * Converts this shim to the canonical enum.
     *
     * @return canonical color profile
     */
    public com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile toCanonical() {
        return com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile.valueOf(name());
    }

    /**
     * Converts a canonical enum value to the legacy shim.
     *
     * @param canonical canonical color profile
     * @return legacy color profile
     */
    public static ColorProfile fromCanonical(com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile canonical) {
        if (canonical == null) {
            return null;
        }
        return ColorProfile.valueOf(canonical.name());
    }
}
