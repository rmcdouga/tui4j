package com.williamcallahan.tui4j.compat.bubbles.list;

import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder;
import com.williamcallahan.tui4j.compat.lipgloss.color.AdaptiveColor;

/**
 * Port of Bubbles default item styles.
 * Bubbles: bubbles/list/defaultitem.go
 */
public class DefaultItemStyles {

    /**
     * Ellipsis string used for truncation.
     */
    public static final String ELLIPSIS = "…";

    private Style normalTitle;
    private Style normalDesc;

    private Style selectedTitle;
    private Style selectedDesc;

    private Style dimmedTitle;
    private Style dimmedDesc;

    private Style filterMatch;

    /**
     * Creates default styles for list items.
     */
    public DefaultItemStyles() {
        this.normalTitle = Style.newStyle()
                .foreground(new AdaptiveColor("#1a1a1a", "#dddddd"))
                .padding(0, 0, 0, 2);
        this.normalDesc = normalTitle.copy()
                .foreground(new AdaptiveColor("#A49FA5", "#777777"));

        this.selectedTitle = Style.newStyle()
                .border(StandardBorder.NormalBorder, false, false, false, true)
                .borderForeground(new AdaptiveColor("#F793FF", "#AD58B4"))
                .foreground(new AdaptiveColor("#EE6FF8", "#EE6FF8"))
                .padding(0, 0, 0, 1);
        this.selectedDesc = selectedTitle.copy()
                .foreground(new AdaptiveColor("#F793FF", "#AD58B4"));

        this.dimmedTitle = Style.newStyle()
                .foreground(new AdaptiveColor("#A49FA5", "#777777"))
                .padding(0, 0, 0, 2);
        this.dimmedDesc = dimmedTitle.copy()
                .foreground(new AdaptiveColor("#C2B8C2", "#4D4D4D"));

        this.filterMatch = Style.newStyle().underline(true);
    }

    /**
     * Returns the style for normal titles.
     *
     * @return title style
     */
    public Style normalTitle() {
        return normalTitle;
    }

    /**
     * Returns the style for normal descriptions.
     *
     * @return description style
     */
    public Style normalDesc() {
        return normalDesc;
    }

    /**
     * Returns the style for selected titles.
     *
     * @return selected title style
     */
    public Style selectedTitle() {
        return selectedTitle;
    }

    /**
     * Returns the style for selected descriptions.
     *
     * @return selected description style
     */
    public Style selectedDesc() {
        return selectedDesc;
    }

    /**
     * Returns the style for dimmed titles.
     *
     * @return dimmed title style
     */
    public Style dimmedTitle() {
        return dimmedTitle;
    }

    /**
     * Returns the style for dimmed descriptions.
     *
     * @return dimmed description style
     */
    public Style dimmedDesc() {
        return dimmedDesc;
    }

    /**
     * Returns the style for filter matches.
     *
     * @return filter match style
     */
    public Style filterMatch() {
        return filterMatch;
    }
}
