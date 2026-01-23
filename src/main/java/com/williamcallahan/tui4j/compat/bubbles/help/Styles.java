package com.williamcallahan.tui4j.compat.bubbles.help;

import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.AdaptiveColor;

/**
 * Port of Bubbles styles.
 * Bubble Tea: bubbletea/examples/help/main.go
 */
public class Styles {

    private Style ellipsis;

    // Styling for the short help
    private Style shortKey;
    private Style shortDesc;
    private Style shortSeparator;

    // Styling for the full help
    private Style fullKey;
    private Style fullDesc;
    private Style fullSeparator;

    /**
     * Creates default help styles.
     */
    public Styles() {
        Style keyStyle = Style.newStyle().foreground(new AdaptiveColor("#909090", "#626262"));
        Style descStyle = Style.newStyle().foreground(new AdaptiveColor("#B2B2B2", "#4A4A4A"));
        Style sepStyle = Style.newStyle().foreground(new AdaptiveColor("#DDDADA", "#3C3C3C"));

        this.shortKey = keyStyle.copy();
        this.shortDesc = descStyle.copy();
        this.shortSeparator = sepStyle.copy();
        this.ellipsis = sepStyle.copy();
        this.fullKey = keyStyle.copy();
        this.fullDesc = descStyle.copy();
        this.fullSeparator = sepStyle.copy();
    }

    /**
     * Returns the short separator style.
     *
     * @return short separator style
     */
    public Style getShortSeparator() {
        return shortSeparator;
    }

    /**
     * Returns the short key style.
     *
     * @return short key style
     */
    public Style getShortKey() {
        return shortKey;
    }

    /**
     * Returns the short description style.
     *
     * @return short description style
     */
    public Style getShortDesc() {
        return shortDesc;
    }

    /**
     * Returns the full separator style.
     *
     * @return full separator style
     */
    public Style getFullSeparator() {
        return fullSeparator;
    }

    /**
     * Returns the full key style.
     *
     * @return full key style
     */
    public Style getFullKey() {
        return fullKey;
    }

    /**
     * Returns the full description style.
     *
     * @return full description style
     */
    public Style getFullDesc() {
        return fullDesc;
    }

    /**
     * Returns the ellipsis style.
     *
     * @return ellipsis style
     */
    public Style getEllipsis() {
        return ellipsis;
    }
}
