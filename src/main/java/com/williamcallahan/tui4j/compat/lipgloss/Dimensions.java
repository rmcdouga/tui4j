package com.williamcallahan.tui4j.compat.lipgloss;

import java.util.Objects;

/**
 * Port of Lip Gloss dimensions.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: size.go.
 */
public class Dimensions {
    private final int width;
    private final int height;

    /**
     * Creates Dimensions to keep this component ready for use.
     *
     * @param width width
     * @param height height
     */
    public Dimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Handles width for this component.
     *
     * @return result
     */
    public int width() {
        return width;
    }

    /**
     * Handles height for this component.
     *
     * @return result
     */
    public int height() {
        return height;
    }

    /**
     * Handles equals for this component.
     *
     * @param o o
     * @return whether uals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimensions that = (Dimensions) o;
        return width == that.width && height == that.height;
    }

    /**
     * Reports whether h code is present.
     *
     * @return whether sh code
     */
    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    /**
     * Handles to string for this component.
     *
     * @return result
     */
    @Override
    public String toString() {
        return "Dimensions[width=" + width + ", height=" + height + "]";
    }
}
