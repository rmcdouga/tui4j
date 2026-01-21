package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests the text cursor.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.SetMouseCursorTextMessage}.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public record SetMouseCursorTextMessage() implements Message {
}
