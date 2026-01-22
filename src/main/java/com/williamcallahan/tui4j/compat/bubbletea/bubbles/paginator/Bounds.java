package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

/**
 * @param start the starting index
 * @param end the ending index
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.paginator.Bounds}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: paginator/paginator.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record Bounds(int start, int end) {}
