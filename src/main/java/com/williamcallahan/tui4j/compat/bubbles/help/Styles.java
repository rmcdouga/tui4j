package com.williamcallahan.tui4j.compat.bubbles.help;

import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.AdaptiveColor;

/**
 * Port of Bubbles styles.
 * Bubble Tea: bubbletea/examples/help/main.go
 * <p>
 * Bubbles: help/help.go.
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
     * Creates Styles to keep this component ready for use.
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
     * Returns the short separator.
     *
     * @return result
     */
    public Style getShortSeparator() {
        return shortSeparator;
    }

    /**
     * Returns the short key.
     *
     * @return result
     */
    public Style getShortKey() {
        return shortKey;
    }

    /**
     * Returns the short desc.
     *
     * @return result
     */
    public Style getShortDesc() {
        return shortDesc;
    }

    /**
     * Returns the full separator.
     *
     * @return result
     */
    public Style getFullSeparator() {
        return fullSeparator;
    }

    /**
     * Returns the full key.
     *
     * @return result
     */
    public Style getFullKey() {
        return fullKey;
    }

    /**
     * Returns the full desc.
     *
     * @return result
     */
    public Style getFullDesc() {
        return fullDesc;
    }

    /**
     * Returns the ellipsis.
     *
     * @return result
     */
    public Style getEllipsis() {
        return ellipsis;
    }
}
