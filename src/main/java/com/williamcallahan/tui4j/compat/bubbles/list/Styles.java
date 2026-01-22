package com.williamcallahan.tui4j.compat.bubbles.list;

import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.AdaptiveColor;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;
import com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor;

/**
 * Port of Bubbles styles.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 */
public class Styles {

    /**
     * Handles default styles for this component.
     *
     * @return result
     */
    public static Styles defaultStyles() {
        TerminalColor verySubduedColor = new AdaptiveColor("#DDDADA", "#3C3C3C");
        TerminalColor subduedColor = new AdaptiveColor("#9B9B9B", "#5C5C5C");

        Styles defaultStyles = new Styles();

        defaultStyles.titleBar = Style.newStyle().padding(0, 0, 1, 2);
        defaultStyles.title = Style.newStyle()
                .background(Color.color("62"))
                .foreground(Color.color("230"))
                .padding(0, 1);

        defaultStyles.spinner = Style.newStyle()
                .foreground(new AdaptiveColor("#8E8E8E", "#747373"));

        defaultStyles.filterPrompt = Style.newStyle()
                .foreground(new AdaptiveColor("#04B575", "#ECFD65"));

        defaultStyles.filterCursor = Style.newStyle()
                .foreground(new AdaptiveColor("#EE6FF8", "#EE6FF8"));

        defaultStyles.defaultFilterCharacterMatch = Style.newStyle().underline(true);

        defaultStyles.statusBar = Style.newStyle()
                .foreground(new AdaptiveColor("#A49FA5", "#777777"))
                .padding(0, 0, 1, 2);

        defaultStyles.statusEmpty = Style.newStyle()
                .foreground(subduedColor);

        defaultStyles.statusBarActiveFilter = Style.newStyle()
                .foreground(new AdaptiveColor("#1a1a1a", "#dddddd"));

        defaultStyles.statusBarFilterCount = Style.newStyle()
                .foreground(verySubduedColor);

        defaultStyles.noItems = Style.newStyle()
                .foreground(new AdaptiveColor("#909090", "#626262"));

        defaultStyles.arabicPagination = Style.newStyle()
                .foreground(subduedColor);

        defaultStyles.paginationStyle = Style.newStyle()
                .paddingLeft(2);

        defaultStyles.helpStyle = Style.newStyle()
                .padding(1, 0, 0, 2);

        defaultStyles.activePaginationDot = Style.newStyle()
                .foreground(new AdaptiveColor("#847A85", "#979797"))
                .setString(BULLET);

        defaultStyles.inactivePaginationDot = Style.newStyle()
                .foreground(verySubduedColor)
                .setString(BULLET);

        defaultStyles.dividerDot = Style.newStyle()
                .foreground(verySubduedColor)
                .setString(" " + BULLET + " ");

        return defaultStyles;
    }

    private static final String BULLET = "•";

    private Style titleBar;
    private Style title;
    private Style spinner;
    private Style filterPrompt;
    private Style filterCursor;
    private Style defaultFilterCharacterMatch;
    private Style statusBar;
    private Style statusEmpty;
    private Style statusBarActiveFilter;
    private Style statusBarFilterCount;
    private Style noItems;
    private Style paginationStyle;
    private Style helpStyle;
    private Style activePaginationDot;
    private Style inactivePaginationDot;
    private Style arabicPagination;
    private Style dividerDot;

    /**
     * Handles title bar for this component.
     *
     * @return result
     */
    public Style titleBar() {
        return titleBar;
    }

    /**
     * Updates the title bar.
     *
     * @param titleBar title bar
     */
    public void setTitleBar(Style titleBar) {
        this.titleBar = titleBar;
    }

    /**
     * Handles title for this component.
     *
     * @return result
     */
    public Style title() {
        return title;
    }

    /**
     * Updates the title.
     *
     * @param title title
     */
    public void setTitle(Style title) {
        this.title = title;
    }

    /**
     * Handles spinner for this component.
     *
     * @return result
     */
    public Style spinner() {
        return spinner;
    }

    /**
     * Updates the spinner.
     *
     * @param spinner spinner
     */
    public void setSpinner(Style spinner) {
        this.spinner = spinner;
    }

    /**
     * Handles filter prompt for this component.
     *
     * @return result
     */
    public Style filterPrompt() {
        return filterPrompt;
    }

    /**
     * Updates the filter prompt.
     *
     * @param filterPrompt filter prompt
     */
    public void setFilterPrompt(Style filterPrompt) {
        this.filterPrompt = filterPrompt;
    }

    /**
     * Handles filter cursor for this component.
     *
     * @return result
     */
    public Style filterCursor() {
        return filterCursor;
    }

    /**
     * Updates the filter cursor.
     *
     * @param filterCursor filter cursor
     */
    public void setFilterCursor(Style filterCursor) {
        this.filterCursor = filterCursor;
    }

    /**
     * Handles default filter character match for this component.
     *
     * @return result
     */
    public Style defaultFilterCharacterMatch() {
        return defaultFilterCharacterMatch;
    }

    /**
     * Updates the default filter character match.
     *
     * @param defaultFilterCharacterMatch default filter character match
     */
    public void setDefaultFilterCharacterMatch(Style defaultFilterCharacterMatch) {
        this.defaultFilterCharacterMatch = defaultFilterCharacterMatch;
    }

    /**
     * Handles status bar for this component.
     *
     * @return result
     */
    public Style statusBar() {
        return statusBar;
    }

    /**
     * Updates the status bar.
     *
     * @param statusBar status bar
     */
    public void setStatusBar(Style statusBar) {
        this.statusBar = statusBar;
    }

    /**
     * Handles status empty for this component.
     *
     * @return result
     */
    public Style statusEmpty() {
        return statusEmpty;
    }

    /**
     * Updates the status empty.
     *
     * @param statusEmpty status empty
     */
    public void setStatusEmpty(Style statusEmpty) {
        this.statusEmpty = statusEmpty;
    }

    /**
     * Handles status bar active filter for this component.
     *
     * @return result
     */
    public Style statusBarActiveFilter() {
        return statusBarActiveFilter;
    }

    /**
     * Updates the status bar active filter.
     *
     * @param statusBarActiveFilter status bar active filter
     */
    public void setStatusBarActiveFilter(Style statusBarActiveFilter) {
        this.statusBarActiveFilter = statusBarActiveFilter;
    }

    /**
     * Handles status bar filter count for this component.
     *
     * @return result
     */
    public Style statusBarFilterCount() {
        return statusBarFilterCount;
    }

    /**
     * Updates the status bar filter count.
     *
     * @param statusBarFilterCount status bar filter count
     */
    public void setStatusBarFilterCount(Style statusBarFilterCount) {
        this.statusBarFilterCount = statusBarFilterCount;
    }

    /**
     * Handles no items for this component.
     *
     * @return result
     */
    public Style noItems() {
        return noItems;
    }

    /**
     * Updates the no items.
     *
     * @param noItems no items
     */
    public void setNoItems(Style noItems) {
        this.noItems = noItems;
    }

    /**
     * Handles pagination style for this component.
     *
     * @return result
     */
    public Style paginationStyle() {
        return paginationStyle;
    }

    /**
     * Updates the pagination style.
     *
     * @param paginationStyle pagination style
     */
    public void setPaginationStyle(Style paginationStyle) {
        this.paginationStyle = paginationStyle;
    }

    /**
     * Handles help style for this component.
     *
     * @return result
     */
    public Style helpStyle() {
        return helpStyle;
    }

    /**
     * Updates the help style.
     *
     * @param helpStyle help style
     */
    public void setHelpStyle(Style helpStyle) {
        this.helpStyle = helpStyle;
    }

    /**
     * Handles active pagination dot for this component.
     *
     * @return result
     */
    public Style activePaginationDot() {
        return activePaginationDot;
    }

    /**
     * Updates the active pagination dot.
     *
     * @param activePaginationDot active pagination dot
     */
    public void setActivePaginationDot(Style activePaginationDot) {
        this.activePaginationDot = activePaginationDot;
    }

    /**
     * Handles inactive pagination dot for this component.
     *
     * @return result
     */
    public Style inactivePaginationDot() {
        return inactivePaginationDot;
    }

    /**
     * Updates the inactive pagination dot.
     *
     * @param inactivePaginationDot inactive pagination dot
     */
    public void setInactivePaginationDot(Style inactivePaginationDot) {
        this.inactivePaginationDot = inactivePaginationDot;
    }

    /**
     * Handles arabic pagination for this component.
     *
     * @return result
     */
    public Style arabicPagination() {
        return arabicPagination;
    }

    /**
     * Updates the arabic pagination.
     *
     * @param arabicPagination arabic pagination
     */
    public void setArabicPagination(Style arabicPagination) {
        this.arabicPagination = arabicPagination;
    }

    /**
     * Handles divider dot for this component.
     *
     * @return result
     */
    public Style dividerDot() {
        return dividerDot;
    }

    /**
     * Updates the divider dot.
     *
     * @param dividerDot divider dot
     */
    public void setDividerDot(Style dividerDot) {
        this.dividerDot = dividerDot;
    }
}
