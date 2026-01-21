package com.williamcallahan.tui4j.compat.bubbles.paginator;

/**
 * Index range for the current page of a paginator.
 * <p>
 * Port of charmbracelet/bubbles paginator/paginator.go bounds return type.
 *
 * @param start start index (inclusive)
 * @param end end index (exclusive)
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/paginator/paginator.go">bubbles/paginator/paginator.go</a>
 */
public record Bounds(int start, int end) {
}
