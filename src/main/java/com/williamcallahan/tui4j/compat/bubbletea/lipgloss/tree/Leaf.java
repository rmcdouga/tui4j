package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.tree;

/**
 * @deprecated Use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Leaf} instead.
 *             This class has been moved as part of the Lip Gloss package restructuring.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Leaf extends com.williamcallahan.tui4j.compat.lipgloss.tree.Leaf {

    /**
     * Creates a leaf with a string value.
     *
     * @param value leaf value
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Leaf#Leaf(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Leaf(String value) {
        super(value);
    }

    /**
     * Creates a leaf with an object value and hidden flag.
     *
     * @param value leaf value
     * @param hidden whether the leaf is hidden
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Leaf#Leaf(Object, boolean)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Leaf(Object value, boolean hidden) {
        super(value, hidden);
    }

    /**
     * Creates an empty leaf.
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.lipgloss.tree.Leaf#Leaf()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Leaf() {
        super();
    }
}
