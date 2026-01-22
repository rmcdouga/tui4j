package com.williamcallahan.tui4j.compat.bubbletea.lipgloss;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.Position} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: position.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public final class Position extends com.williamcallahan.tui4j.compat.lipgloss.Position {
    /** Top-aligned position. */
    public static final Position Top = new Position(0.0);
    /** Bottom-aligned position. */
    public static final Position Bottom = new Position(1.0);
    /** Center-aligned position. */
    public static final Position Center = new Position(0.5);
    /** Left-aligned position. */
    public static final Position Left = new Position(0.0);
    /** Right-aligned position. */
    public static final Position Right = new Position(1.0);

    /**
     * Creates Position to keep this component ready for use.
     *
     * @param value value
     */
    public Position(double value) {
        super(value);
    }

    /**
     * Handles to new for this component.
     *
     * @return result
     */
    public com.williamcallahan.tui4j.compat.lipgloss.Position toNew() {
        return new com.williamcallahan.tui4j.compat.lipgloss.Position(value());
    }
    
    /**
     * Handles from new for this component.
     *
     * @param p p
     * @return result
     */
    public static Position fromNew(com.williamcallahan.tui4j.compat.lipgloss.Position p) {
        if (p == null) {
            return null;
        }
        return new Position(p.value());
    }
}
