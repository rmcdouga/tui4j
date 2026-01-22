package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Port of Bubbles fetched current page items.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 */
@Deprecated(since = "0.3.0")
public record FetchedCurrentPageItems(
        FetchedItems fetchedItems,
        Runnable... postFetch
) implements Message {
}
