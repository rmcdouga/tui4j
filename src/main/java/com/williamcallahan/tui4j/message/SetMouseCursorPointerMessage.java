package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests the pointer cursor.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.SetMouseCursorPointerMessage}.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public record SetMouseCursorPointerMessage() implements Message {
}
