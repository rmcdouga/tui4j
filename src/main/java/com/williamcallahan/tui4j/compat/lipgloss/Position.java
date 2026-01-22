package com.williamcallahan.tui4j.compat.lipgloss;

/**
 * Port of Lip Gloss position.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 */
public class Position {
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

    private final double value;

    /**
     * Creates Position to keep this component ready for use.
     *
     * @param value value
     */
    public Position(double value) {
        this.value = value;
    }

    /**
     * Handles value for this component.
     *
     * @return result
     */
    public double value() {
        return Math.min(1, Math.max(0, this.value));
    }
}
