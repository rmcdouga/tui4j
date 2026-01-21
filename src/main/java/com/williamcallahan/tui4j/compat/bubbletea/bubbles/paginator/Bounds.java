package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

/**
 * Deprecated shim for paginator bounds.
 *
 * @param start the starting index
 * @param end the ending index
 * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.paginator.Bounds} instead.
 *             This record has been moved as part of the Bubbles package restructuring.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/paginator/paginator.go">bubbles/paginator/paginator.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record Bounds(int start, int end) {
}
