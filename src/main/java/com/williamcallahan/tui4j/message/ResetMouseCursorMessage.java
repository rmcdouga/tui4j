package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests resetting the mouse cursor to default.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.ResetMouseCursorMessage}.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public record ResetMouseCursorMessage() implements Message {
}
