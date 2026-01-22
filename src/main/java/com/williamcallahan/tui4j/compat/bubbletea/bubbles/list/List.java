package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.List}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/List.java}.
 * <p>
 * Bubbles: list/list.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.List}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
@SuppressWarnings("removal")
public class List extends com.williamcallahan.tui4j.compat.bubbles.list.List {

    // Legacy constructors
    /**
     * Creates List to keep this component ready for use.
     *
     * @param items items
     * @param width width
     * @param height height
     */
    public List(Item[] items, int width, int height) {
        super(items, width, height);
    }

    /**
     * Creates List to keep this component ready for use.
     *
     * @param items items
     * @param delegate delegate
     * @param width width
     * @param height height
     */
    public List(Item[] items, ItemDelegate delegate, int width, int height) {
        super(items, delegate, width, height);
    }

    /**
     * Creates List to keep this component ready for use.
     *
     * @param dataSource data source
     * @param width width
     * @param height height
     */
    public List(com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.ListDataSource dataSource, int width, int height) {
        super(dataSource.toCanonical(), new com.williamcallahan.tui4j.compat.bubbles.list.DefaultDelegate(), width, height);
    }

    /**
     * Creates List to keep this component ready for use.
     *
     * @param dataSource data source
     * @param delegate delegate
     * @param width width
     * @param height height
     */
    public List(com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.ListDataSource dataSource, ItemDelegate delegate, int width, int height) {
        super(dataSource.toCanonical(), delegate, width, height);
    }

    // Forward compatibility constructors (accepting New types)
    /**
     * Creates List to keep this component ready for use.
     *
     * @param items items
     * @param width width
     * @param height height
     */
    public List(com.williamcallahan.tui4j.compat.bubbles.list.Item[] items, int width, int height) {
        super(items, width, height);
    }

    /**
     * Creates List to keep this component ready for use.
     *
     * @param items items
     * @param delegate delegate
     * @param width width
     * @param height height
     */
    public List(com.williamcallahan.tui4j.compat.bubbles.list.Item[] items, com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate delegate, int width, int height) {
        super(items, delegate, width, height);
    }

    /**
     * Creates List to keep this component ready for use.
     *
     * @param dataSource data source
     * @param width width
     * @param height height
     */
    public List(com.williamcallahan.tui4j.compat.bubbles.list.ListDataSource dataSource, int width, int height) {
        super(dataSource, width, height);
    }

    /**
     * Creates List to keep this component ready for use.
     *
     * @param dataSource data source
     * @param delegate delegate
     * @param width width
     * @param height height
     */
    public List(com.williamcallahan.tui4j.compat.bubbles.list.ListDataSource dataSource, com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate delegate, int width, int height) {
        super(dataSource, delegate, width, height);
    }

    /**
     * Handles styles for this component.
     *
     * @return result
     */
    @Override
    public Styles styles() {
        com.williamcallahan.tui4j.compat.bubbles.list.Styles styles = super.styles();
        if (styles instanceof Styles legacy) {
            return legacy;
        }
        return Styles.fromCanonical(styles);
    }
}
