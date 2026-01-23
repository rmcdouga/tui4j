package com.williamcallahan.tui4j.compat.lipgloss;

/**
 * Port of Lip Gloss position values.
 * Upstream: lipgloss/position.go
 */
public final class Position {
    /** Top-aligned position. */
    public static final Position Top = new Position(0.0);
    /** Bottom-aligned position. */
    public static final Position Bottom = new Position(1.0);
    /** Center position. */
    public static final Position Center = new Position(0.5);
    /** Left-aligned position. */
    public static final Position Left = new Position(0.0);
    /** Right-aligned position. */
    public static final Position Right = new Position(1.0);

    private final double value;

    /**
     * Creates a position value.
     *
     * @param value normalized position value
     */
    public Position(double value) {
        this.value = value;
    }

    /**
     * Returns the normalized position value.
     *
     * @return normalized value between 0 and 1
     */
    public double value() {
        return Math.min(1, Math.max(0, this.value));
    }
}
