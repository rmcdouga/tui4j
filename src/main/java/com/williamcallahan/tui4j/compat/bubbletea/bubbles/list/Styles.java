package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.Styles}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/Styles.java}.
 * <p>
 * Bubbles: list/style.go.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.Styles}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Styles extends com.williamcallahan.tui4j.compat.bubbles.list.Styles {
    
    /**
     * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.list.Styles#defaultStyles} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static Styles defaultStyles() {
        return fromCanonical(com.williamcallahan.tui4j.compat.bubbles.list.Styles.defaultStyles());
    }

    /**
     * Converts a canonical styles instance into the legacy shim.
     *
     * @param canonical canonical styles
     * @return legacy styles shim
     */
    public static Styles fromCanonical(com.williamcallahan.tui4j.compat.bubbles.list.Styles canonical) {
        if (canonical instanceof Styles legacy) {
            return legacy;
        }
        Styles legacy = new Styles();
        legacy.setTitleBar(canonical.titleBar());
        legacy.setTitle(canonical.title());
        legacy.setSpinner(canonical.spinner());
        legacy.setFilterPrompt(canonical.filterPrompt());
        legacy.setFilterCursor(canonical.filterCursor());
        legacy.setDefaultFilterCharacterMatch(canonical.defaultFilterCharacterMatch());
        legacy.setStatusBar(canonical.statusBar());
        legacy.setStatusEmpty(canonical.statusEmpty());
        legacy.setStatusBarActiveFilter(canonical.statusBarActiveFilter());
        legacy.setStatusBarFilterCount(canonical.statusBarFilterCount());
        legacy.setNoItems(canonical.noItems());
        legacy.setPaginationStyle(canonical.paginationStyle());
        legacy.setHelpStyle(canonical.helpStyle());
        legacy.setActivePaginationDot(canonical.activePaginationDot());
        legacy.setInactivePaginationDot(canonical.inactivePaginationDot());
        legacy.setArabicPagination(canonical.arabicPagination());
        legacy.setDividerDot(canonical.dividerDot());
        return legacy;
    }
}
