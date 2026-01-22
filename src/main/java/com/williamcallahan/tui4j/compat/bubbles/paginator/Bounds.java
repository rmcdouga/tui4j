package com.williamcallahan.tui4j.compat.bubbles.paginator;

/**
 * Port of Bubbles bounds.
 * Bubble Tea: bubbletea/examples/paginator/main.go
 *
 * @param start start index (inclusive)
 * @param end end index (exclusive)
 * <p>
 * Bubbles: paginator/paginator.go.
 */
public record Bounds(int start, int end) {
}
