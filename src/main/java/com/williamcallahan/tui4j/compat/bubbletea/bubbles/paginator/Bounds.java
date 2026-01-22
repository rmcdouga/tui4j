package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

/**
 * Reports the visible range for the paginator.
 * <p>
 * Bubbles: paginator/paginator.go.
 *
 * @param start the starting index
 * @param end the ending index
 */
public record Bounds(int start, int end) {}
